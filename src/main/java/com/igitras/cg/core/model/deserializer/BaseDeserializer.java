package com.igitras.cg.core.model.deserializer;

import com.igitras.cg.core.context.ModelContext;
import com.igitras.cg.core.exception.RegisterModelException;
import com.igitras.cg.core.model.ModelRegister;

import java.rmi.registry.Registry;

/**
 * Base Deserializer that defined the deserialize processing steps.
 *
 * @author mason
 */
public abstract class BaseDeserializer<T> implements Deserializer<T>, ModelRegister<T> {

    @Override
    public T deserialize(final String serialized) {
        String normalize = normalize(serialized);
        T model = newInstance();
        parseTo(normalize, model);

        return model;
    }

    @Override
    public void deserializeAndRegister(String serialized, ModelContext context) throws RegisterModelException {
        register(deserialize(serialized), context);
    }

    /**
     * Create an new instance of the model.
     *
     * @return model instance.
     */
    public abstract T newInstance();

    /**
     * Parse the content and set the parsed result to the instance.
     *
     * @param content  content in string
     * @param instance instance
     */
    public abstract void parseTo(final String content, final T instance);

    /**
     * Normalize the serialized content.
     *
     * @param serialized serialized string
     *
     * @return normalized string
     */
    protected String normalize(String serialized) {
        return serialized.replaceAll("\r|\n", "").replaceAll("[\\s]+", " ").trim();
    }
}
