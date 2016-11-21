package com.igitras.cg.core.model.serializer;

import com.igitras.cg.core.model.EnumModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mason on 11/18/16.
 */
public class EnumSerializer extends BaseSerializer<EnumModel> {
    @Override
    public String getTemplate() {
        return "templates/enum.tm";
    }

    @Override
    public Map<String, Object> buildContext(EnumModel model) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", model.getName());
        params.put("properties", model.getProperties());
        params.put("elements", model.getElements());
        return params;
    }
}
