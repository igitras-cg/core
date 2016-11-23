package com.igitras.cg.core.exception;

/**
 * Model register exception.
 *
 * @author mason
 */
public abstract class RegisterModelException extends CodeGenerationException {

    public RegisterModelException() {
    }

    public RegisterModelException(String message) {
        super(message);
    }

    public RegisterModelException(String message, Throwable cause) {
        super(message, cause);
    }
}
