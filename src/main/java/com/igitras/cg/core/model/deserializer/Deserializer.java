package com.igitras.cg.core.model.deserializer;

/**
 * Created by mason on 11/9/16.
 */
public interface Deserializer<T> {

    /**
     * Read from a string to the model, enum or relationship.
     *
     * @param serialized serialized.
     *
     * @return model
     */
    T deserialize(String serialized);
}
