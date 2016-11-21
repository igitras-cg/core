package com.igitras.cg.core.model;

import java.util.Map;

/**
 * Template for serializer.
 *
 * @author mason
 */
public interface Template<T> {
    /**
     * Get the template file.
     *
     * @return template file name
     */
    String getTemplate();

    /**
     * Build the model context for serialize with template from model.
     *
     * @param model model
     *
     * @return value map
     */
    Map<String, Object> buildContext(T model);
}
