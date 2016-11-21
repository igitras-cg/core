package com.igitras.cg.core.model.serializer;

import static com.igitras.cg.core.model.Constrain.Required;
import static com.igitras.cg.core.model.PropertyType.Integer;
import static com.igitras.cg.core.model.PropertyType.String;

import com.google.common.collect.Lists;
import com.igitras.cg.core.model.Model;
import com.igitras.cg.core.model.Property;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mason on 11/18/16.
 */
public class ModelSerializerTest {


    @org.junit.Test
    public void getTemplate() throws Exception {

    }

    @org.junit.Test
    public void buildContext() throws Exception {

    }

    @org.junit.Test
    public void serialize() throws Exception {
        ModelSerializer serializer = new ModelSerializer();
        Model model = new Model();
        model.setName("Person");
        Set<Property> properties = new HashSet<>();
        properties.add(new Property().setName("name").setType(String).setConstrains(Lists.newArrayList(Required)));
        properties.add(new Property().setName("age").setType(Integer).setConstrains(Lists.newArrayList(Required)));
        model.setProperties(properties);
        String serialize = serializer.serialize(model);
        System.out.println(serialize);
    }
}