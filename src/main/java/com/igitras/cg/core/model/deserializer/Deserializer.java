package com.igitras.cg.core.model.deserializer;

/**
 * Deserializer from string represented object to Model.
 *
 * @author mason
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
