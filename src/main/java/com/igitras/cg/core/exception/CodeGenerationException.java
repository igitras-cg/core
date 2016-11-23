package com.igitras.cg.core.exception;

/**
 * Base model exception of the code generation.
 *
 * @author mason
 */
public abstract class CodeGenerationException extends RuntimeException {

    public CodeGenerationException() {
    }

    public CodeGenerationException(String message) {
        super(message);
    }

    public CodeGenerationException(String message, Throwable cause) {
        super(message, cause);
    }
}
