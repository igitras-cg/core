package com.igitras.cg.core.model.serializer;

/**
 * Created by mason on 11/9/16.
 */
public interface Serializer<T> {

    /**
     * Write the model to string.
     *
     * @return serialized string.
     */
    String serialize(T model);
}
