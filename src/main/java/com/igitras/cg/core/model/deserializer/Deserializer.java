package com.igitras.cg.core.model.deserializer;

import com.igitras.cg.core.context.ModelContext;
import com.igitras.cg.core.exception.RegisterModelException;

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

    /**
     * Read from a string to model, enum or relationship and register to model context.
     *
     * @param serialized serialized
     * @param context    context
     */
    void deserializeAndRegister(String serialized, ModelContext context) throws RegisterModelException;
}
