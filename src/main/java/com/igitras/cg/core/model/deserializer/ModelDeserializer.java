package com.igitras.cg.core.model.deserializer;

import com.igitras.cg.core.model.Model;

import java.util.stream.Stream;

/**
 * Model Deserializer.
 *
 * @author mason
 */
public class ModelDeserializer extends BaseDeserializer<Model> {

    private static final String KEY_WORD = "model";

    @Override
    public Model newInstance() {
        return new Model();
    }

    @Override
    public void parseTo(String content, Model instance) {
        int bodyIndex = content.indexOf("{");
        String name = content.substring(KEY_WORD.length(), bodyIndex).trim();
        String props = content.substring(bodyIndex + 1, content.length() - 1);
        instance.setName(name);
        String[] splits = props.split(";");
        Stream.of(splits)
                .filter(split -> !split.trim().isEmpty())
                .forEach(split -> instance.getProperties().add(new PropertyDeserializer().deserialize(split)));
    }
}
