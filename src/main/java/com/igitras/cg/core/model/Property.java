package com.igitras.cg.core.model;

import com.google.common.base.MoreObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Property of model.
 *
 * @author mason
 */
public class Property {

    private String name;
    private PropertyType type;
    private EnumModel enumModel;
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

    public EnumModel getEnumModel() {
        return enumModel;
    }

    public Property setEnumModel(EnumModel enumModel) {
        this.enumModel = enumModel;
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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .toString();
    }
}
