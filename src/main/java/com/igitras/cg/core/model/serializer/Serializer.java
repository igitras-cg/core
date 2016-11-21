package com.igitras.cg.core.model.serializer;

/**
 * Model Serializer, serialize the model to string.
 *
 * @author mason
 */
public interface Serializer<T> {

    /**
     * Write the model to string.
     *
     * @return serialized string.
     */
    String serialize(T model);
}
