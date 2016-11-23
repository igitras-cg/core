package com.igitras.cg.core.exception;

/**
 * Missing model founded to throw this exception while validating the context.
 *
 * @author mason
 */
public class MissingModelException extends CodeGenerationException {

    public MissingModelException(String message) {
        super(message);
    }

}
