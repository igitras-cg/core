package com.igitras.cg.core.model.serializer;

import com.igitras.cg.core.model.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Model Serializer.
 *
 * @author mason
 */
public class ModelSerializer extends BaseSerializer<Model> {

    @Override
    public String getTemplate() {
        return "templates/model.tm";
    }

    @Override
    public Map<String, Object> buildContext(Model model) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", model.getName());
        params.put("properties", model.getProperties());
        return params;
    }
}
