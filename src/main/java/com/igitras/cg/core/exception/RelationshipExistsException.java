package com.igitras.cg.core.exception;

import static java.lang.String.format;

import com.igitras.cg.core.model.Relationship;

/**
 * Created by mason on 11/9/16.
 */
public class RelationshipExistsException extends RegisterModelException {

    public RelationshipExistsException(Relationship relationship) {
        super(format("Relationship defined in Model %s with name %s exists", relationship.getFrom().getName(),
                relationship.getFromName()));
    }
}
