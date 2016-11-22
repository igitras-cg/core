package com.igitras.cg.core.context;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by mason on 11/23/16.
 */
public class ModelFactoryTest {

    @Test
    public void normalized() throws Exception {

    }

    @Test
    public void normalized1() throws Exception {

    }

    @Test
    public void parse() throws Exception {
        String str = "enum Constrain {\n"
                + "    NotNull,\n"
                + "    Required,\n"
                + "}  enum Constrain2 { \n"
                + "    NotNull,\n"
                + "    Required,\n"
                + "}";

        ModelContext context = new DefaultModelContext();
        ModelFactory.parseConfig(context, ModelFactory.normalized(str));
        assertEquals(2, context.getAllEnums().size());
    }
}