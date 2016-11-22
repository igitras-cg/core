package com.igitras.cg.core.exception;

import static java.lang.String.format;

/**
 * Enum register exception.
 *
 * @author mason
 */
public class EnumExistsException extends RegisterModelException {

    public EnumExistsException(String name) {
        super(format("Model with name %s already exists", name));
    }
}
