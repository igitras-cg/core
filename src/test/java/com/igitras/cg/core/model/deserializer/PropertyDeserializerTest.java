package com.igitras.cg.core.model.deserializer;

import static org.junit.Assert.*;

import com.igitras.cg.core.model.Property;
import com.igitras.cg.core.model.PropertyType;
import org.junit.Test;

/**
 * Created by mason on 11/21/16.
 */
public class PropertyDeserializerTest {

    @Test
    public void normalize() throws Exception {
        String str = "      name String ; \n";
        String normalize = new PropertyDeserializer().normalize(str);
        System.out.println(normalize);

        str = "    age Integer Required ;";
        normalize = new PropertyDeserializer().normalize(str);
        System.out.println(normalize);
    }

    @Test
    public void deserialize() throws Exception {
        String str = "      name String ; \n";
        Property deserialize = new PropertyDeserializer().deserialize(str);
        assertEquals("name", deserialize.getName());
        assertEquals(PropertyType.String, deserialize.getType());
        assertEquals(0, deserialize.getConstrains().size());


        str = "    age Integer Required ;";
        deserialize = new PropertyDeserializer().deserialize(str);
        assertEquals("age", deserialize.getName());
        assertEquals(PropertyType.Integer, deserialize.getType());
        assertEquals(1, deserialize.getConstrains().size());
    }
}