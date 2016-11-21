package com.igitras.cg.core.model;

import java.util.Map;

/**
 * Created by mason on 11/17/16.
 */
public interface Template<T> {
    /**
     * Get the template file.
     *
     * @return template file name
     */
    String getTemplate();

    Map<String, Object> buildContext(T model);
}
