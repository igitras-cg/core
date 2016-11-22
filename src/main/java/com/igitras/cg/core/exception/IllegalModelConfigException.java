package com.igitras.cg.core.exception;

import static java.lang.String.format;

/**
 * Created by mason on 11/22/16.
 */
public class IllegalModelConfigException extends Exception {

    public IllegalModelConfigException(String name) {
        super(format("model config error! occurred at: %s", name));
    }

}
