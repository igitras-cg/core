package com.igitras.cg.core.context;

import static com.igitras.cg.core.model.deserializer.DeserializerFactory.getDeserializer;
import static com.igitras.cg.core.utils.Constant.Model.KEY_WORDS;

import static java.lang.Character.isSpaceChar;

import com.igitras.cg.core.exception.IllegalModelConfigException;
import com.igitras.cg.core.exception.RegisterModelException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

/**
 * Model Factory to read models from config files.
 *
 * @author mason
 */
public abstract class ModelFactory {

    /**
     * Normalize the config content.
     *
     * @param original config content
     *
     * @return normalized content
     */
    protected static String normalized(String original) {
        return original.replaceAll("\r|\n", "").replaceAll("[\\s]+", " ").trim();
    }

    /**
     * Parse the config content and update context.
     *
     * @param context context
     * @param config  config content
     *
     * @throws IllegalModelConfigException
     */
    protected static void parseConfig(ModelContext context, String config)
            throws IllegalModelConfigException, RegisterModelException {
        int index = 0;
        int startIdx = -1;
        int bodyIdx = -1;
        boolean started = false;
        Stack<Character> stack = new Stack<>();
        String modelType = null;

        StringBuilder builder = new StringBuilder();
        while (index < config.length()) {
            char c = config.charAt(index);

            if (modelType != null) {
                if (c == '{') {
                    stack.push(c);
                    bodyIdx = index;
                }

                if (c == '}') {
                    stack.pop();
                }
            } else {
                if (isSpaceChar(c)) {
                    if (started) {
                        String word = builder.toString();
                        if (KEY_WORDS.contains(word)) {
                            modelType = word;
                            startIdx = index - word.length();
                        } else {
                            throw new IllegalModelConfigException(word);
                        }
                    }
                } else {
                    builder.append(c);
                    started = true;
                }
            }

            if (stack.isEmpty() && bodyIdx != -1) {
                getDeserializer(modelType).deserializeAndRegister(config.substring(startIdx, index) + '}', context);
                startIdx = -1;
                bodyIdx = -1;
                modelType = null;
                started = false;
                builder = new StringBuilder();
            }
            index++;
        }

    }

    /**
     * Parse Config from files and update context.
     *
     * @param context context
     * @param files   config files.
     *
     * @throws IOException
     * @throws RegisterModelException
     * @throws IllegalModelConfigException
     */
    public static void parseConfig(ModelContext context, File... files)
            throws IOException, RegisterModelException, IllegalModelConfigException {
        for (File file : files) {
            String content = FileUtils.readFileToString(file);
            content = normalized(content);
            parseConfig(context, content);
        }
    }
}
