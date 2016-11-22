package com.igitras.cg.core.utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mason on 11/23/16.
 */
public abstract class Constant {

    public static class Model {
        public static final String MODEL = "model";
        public static final String ENUM = "enum";
        public static final String RELATION = "relation";
        public static final List<String> KEY_WORDS = Arrays.asList(MODEL, ENUM, RELATION);

    }
}
