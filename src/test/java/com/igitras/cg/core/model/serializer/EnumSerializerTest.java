package com.igitras.cg.core.model.serializer;

import static org.junit.Assert.*;

import com.google.common.collect.Sets;
import com.igitras.cg.core.model.EnumModel;
import org.junit.Test;

/**
 * Created by mason on 11/18/16.
 */
public class EnumSerializerTest {

    @Test
    public void getTemplate() throws Exception {

    }

    @Test
    public void buildContext() throws Exception {

    }

    @Test
    public void serialize() throws Exception {
        EnumModel model = new EnumModel().setElements(Sets.newTreeSet(Sets.newHashSet("NotNull", "Required")));
        model.setName("Constrain");
        String serialize = new EnumSerializer().serialize(model);
        System.out.println(serialize);
    }
}