package com.igitras.cg.core.model.deserializer;

import com.igitras.cg.core.model.EnumModel;

import java.util.stream.Stream;

/**
 * Enum Deserializer.
 *
 * @author mason
 */
public class EnumDeserializer extends BaseDeserializer<EnumModel> {

    private static final String KEY_WORD = "enum";

    @Override
    public EnumModel newInstance() {
        return new EnumModel();
    }

    @Override
    public void parseTo(String content, EnumModel instance) {
        int bodyIndex = content.indexOf("{");
        String name = content.substring(KEY_WORD.length(), bodyIndex).trim();
        String elems = content.substring(bodyIndex + 1, content.length() - 1);
        instance.setName(name);
        String[] splits = elems.split(",");
        Stream.of(splits)
                .filter(split -> !split.trim().isEmpty())
                .forEach(split -> instance.getElements().add(split.trim()));
    }
}
