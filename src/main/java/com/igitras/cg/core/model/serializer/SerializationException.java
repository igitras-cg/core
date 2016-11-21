package com.igitras.cg.core.model.serializer;

import static java.lang.String.format;

/**
 * Created by mason on 11/18/16.
 */
public class SerializationException extends RuntimeException {

    public SerializationException(Class<?> clazz, String modelName) {
        super(format("Serialize %s: %s failed", clazz.getSimpleName(), modelName));
    }
}
