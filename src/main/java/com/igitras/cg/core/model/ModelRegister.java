package com.igitras.cg.core.model;

import com.igitras.cg.core.context.ModelContext;
import com.igitras.cg.core.exception.RegisterModelException;

/**
 * Model Register.
 *
 * @author mason
 */
public interface ModelRegister<T> {

    /**
     * Register the model to context.
     *
     * @param model   model
     * @param context context
     */
    void register(T model, ModelContext context) throws RegisterModelException;
}
