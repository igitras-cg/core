package com.igitras.cg.core.model;

import com.google.common.base.MoreObjects;

/**
 * Relationship between models.
 *
 * @author mason
 */
public class Relationship {

    private Model from;
    private String fromName;
    private Model to;
    private String toName;
    private RelationshipType type;

    public Model getFrom() {
        return from;
    }

    public Relationship setFrom(Model from) {
        this.from = from;
        return this;
    }

    public String getFromName() {
        return fromName;
    }

    public Relationship setFromName(String fromName) {
        this.fromName = fromName;
        return this;
    }

    public Model getTo() {
        return to;
    }

    public Relationship setTo(Model to) {
        this.to = to;
        return this;
    }

    public String getToName() {
        return toName;
    }

    public Relationship setToName(String toName) {
        this.toName = toName;
        return this;
    }

    public RelationshipType getType() {
        return type;
    }

    public Relationship setType(RelationshipType type) {
        this.type = type;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Relationship that = (Relationship) o;

        if (from != null ? !from.equals(that.from) : that.from != null) {
            return false;
        }
        return fromName != null ? fromName.equals(that.fromName) : that.fromName == null;

    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (fromName != null ? fromName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("from", from)
                .add("fromName", fromName)
                .toString();
    }
}
