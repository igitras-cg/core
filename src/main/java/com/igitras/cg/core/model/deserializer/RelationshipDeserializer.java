package com.igitras.cg.core.model.deserializer;

import com.igitras.cg.core.context.ModelContext;
import com.igitras.cg.core.exception.RegisterModelException;
import com.igitras.cg.core.model.Model;
import com.igitras.cg.core.model.Relationship;
import com.igitras.cg.core.model.RelationshipType;

/**
 * Relationship Deserializer.
 *
 * @author mason
 */
public class RelationshipDeserializer extends BaseDeserializer<Relationship> {

    private static final String KEY_WORD = "relation";

    @Override
    public Relationship newInstance() {
        return new Relationship();
    }

    @Override
    public void parseTo(String content, Relationship instance) {
        int bodyIndex = content.indexOf("{");
        String type = content.substring(KEY_WORD.length(), bodyIndex).trim();
        String body = content.substring(bodyIndex + 1, content.length() - 1);
        instance.setType(RelationshipType.valueOf(type));
        String[] splits = body.split("->", 2);

        String[] fromPair = splits[0].trim().split("\\[|\\]");
        String[] toPair = splits[1].trim().split("\\[|\\]");
        instance.setFrom(new Model().setName(fromPair[0]));
        instance.setFromName(fromPair[1]);
        instance.setTo(new Model().setName(toPair[0]));
        instance.setToName(toPair[1]);
    }

    @Override
    public void register(Relationship model, ModelContext context) throws RegisterModelException {
        context.registerRelation(model);
    }
}
