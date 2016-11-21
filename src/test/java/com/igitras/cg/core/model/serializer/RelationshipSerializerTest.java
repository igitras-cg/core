package com.igitras.cg.core.model.serializer;

import com.igitras.cg.core.model.Model;
import com.igitras.cg.core.model.Relationship;
import com.igitras.cg.core.model.RelationshipType;
import org.junit.Test;

/**
 * Created by mason on 11/18/16.
 */
public class RelationshipSerializerTest {

    @Test
    public void getTemplate() throws Exception {

    }

    @Test
    public void buildContext() throws Exception {

    }

    @Test
    public void serialize() throws Exception {
        Relationship relationship = new Relationship().setFrom(new Model().setName("Class"))
                .setFromName("students")
                .setTo(new Model().setName("Students"))
                .setToName("class")
                .setType(RelationshipType.One2Many);
        String serialize = new RelationshipSerializer().serialize(relationship);
        System.out.println(serialize);
    }
}