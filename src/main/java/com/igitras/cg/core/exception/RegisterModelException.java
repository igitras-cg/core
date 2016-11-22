package com.igitras.cg.core.exception;

/**
 * Model register exception.
 *
 * @author mason
 */
public abstract class RegisterModelException extends Exception {
    public RegisterModelException(String message) {
        super(message);
    }
}
