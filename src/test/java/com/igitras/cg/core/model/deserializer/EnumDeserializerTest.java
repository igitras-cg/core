package com.igitras.cg.core.model.deserializer;

import static org.junit.Assert.assertEquals;

import com.igitras.cg.core.model.EnumModel;
import org.junit.Test;

/**
 * Created by mason on 11/21/16.
 */
public class EnumDeserializerTest {

    @Test
    public void deserialize() throws Exception {
        String str = "enum Constrain {\n"
                + "    NotNull,\n"
                + "    Required,\n"
                + "}";
        EnumModel deserialize = new EnumDeserializer().deserialize(str);
        assertEquals("Constrain", deserialize.getName());
        assertEquals(2, deserialize.getElements().size());

        str = "enum Constrain {}";
        deserialize = new EnumDeserializer().deserialize(str);
        assertEquals("Constrain", deserialize.getName());
        assertEquals(0, deserialize.getElements().size());
    }

    @Test
    public void normalize() throws Exception {
        String str = "enum Constrain {\n"
                + "    NotNull,\n"
                + "    Required,\n"
                + "}";
        System.out.println(new EnumDeserializer().normalize(str));
    }
}