package com.igitras.cg.core.model;

/**
 * Created by mason on 11/7/16.
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

        return fromName != null ? fromName.equals(that.fromName) : that.fromName == null;

    }

    @Override
    public int hashCode() {
        return fromName != null ? fromName.hashCode() : 0;
    }
}
