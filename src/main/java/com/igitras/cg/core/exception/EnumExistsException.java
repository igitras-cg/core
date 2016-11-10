package com.igitras.cg.core.exception;

import static java.lang.String.format;

/**
 * Created by mason on 11/7/16.
 */
public class EnumExistsException extends Exception {

    public EnumExistsException(String name) {
        super(format("Model with name %s already exists", name));
    }
}
