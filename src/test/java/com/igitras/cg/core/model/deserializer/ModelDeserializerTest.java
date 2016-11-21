package com.igitras.cg.core.model.deserializer;

import static org.junit.Assert.*;

import com.igitras.cg.core.model.Model;
import org.junit.Test;

/**
 * Created by mason on 11/21/16.
 */
public class ModelDeserializerTest {

    @Test
    public void deserialize() throws Exception {
        String str = "      model Person    {  \n"
                + "name    String  Required;\r\n"
                + "    age Integer;\r\n"
                + "}";
        Model model = new ModelDeserializer().deserialize(str);
        assertEquals("Person", model.getName());
        assertEquals(2, model.getProperties().size());

        str = "      model Person    {  \n"
                + "}";
        model = new ModelDeserializer().deserialize(str);
        assertEquals("Person", model.getName());
        assertEquals(0, model.getProperties().size());
    }

    @Test
    public void normalize() throws Exception {
        String str = "      model Person    {  \n"
                + "name    String  Required;\r\n"
                + "    age Integer;\r\n"
                + "}";
        String normalize = new ModelDeserializer().normalize(str);
        System.out.println(normalize);
    }
}