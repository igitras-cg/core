package com.igitras.cg.core.model.serializer;

import com.igitras.cg.core.model.Relationship;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mason on 11/18/16.
 */
public class RelationshipSerializer extends BaseSerializer<Relationship> {
    @Override
    public String getTemplate() {
        return "templates/relation.tm";
    }

    @Override
    public Map<String, Object> buildContext(Relationship model) {
        Map<String, Object> params = new HashMap<>();
        params.put("type", model.getType());
        params.put("from", model.getFrom());
        params.put("fromName", model.getFromName());
        params.put("to", model.getTo());
        params.put("toName", model.getToName());

        return params;
    }
}
