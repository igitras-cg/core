package com.igitras.cg.core.model.deserializer;

import static org.junit.Assert.*;

import com.igitras.cg.core.model.Relationship;
import com.igitras.cg.core.model.RelationshipType;
import org.junit.Test;

/**
 * Created by mason on 11/21/16.
 */
public class RelationshipDeserializerTest {

    @Test
    public void deserialize() throws Exception {
        String str = "relation One2Many {\n"
                + "    Class[students] -> Students[class]\n"
                + "}";
        Relationship deserialize = new RelationshipDeserializer().deserialize(str);
        assertEquals(RelationshipType.One2Many, deserialize.getType());
        assertEquals("students", deserialize.getFromName());
    }

    @Test
    public void normalize() throws Exception {
        String str = "relation One2Many {\n"
                + "    Class[students] -> Students[class]\n"
                + "}";
        System.out.println(new RelationshipDeserializer().normalize(str));
    }
}