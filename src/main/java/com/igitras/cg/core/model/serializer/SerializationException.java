package com.igitras.cg.core.model.serializer;

import static java.lang.String.format;

/**
 * Serializer exception. Throwing while serializer the model to string failed.
 *
 * @author mason
 */
public class SerializationException extends RuntimeException {

    public SerializationException(Class<?> clazz, String modelName) {
        super(format("Serialize %s: %s failed", clazz.getSimpleName(), modelName));
    }
}
