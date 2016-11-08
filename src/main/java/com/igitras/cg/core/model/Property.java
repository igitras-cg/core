package com.igitras.cg.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mason on 11/7/16.
 */
public class Property {

    private String name;
    private PropertyType type;
    private List<Constrain> constrains = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Property setName(String name) {
        this.name = name;
        return this;
    }

    public PropertyType getType() {
        return type;
    }

    public Property setType(PropertyType type) {
        this.type = type;
        return this;
    }

    public List<Constrain> getConstrains() {
        return constrains;
    }

    public Property setConstrains(List<Constrain> constrains) {
        this.constrains = constrains;
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

        Property property = (Property) o;

        return name != null ? name.equals(property.name) : property.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
