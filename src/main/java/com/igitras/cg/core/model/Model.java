package com.igitras.cg.core.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mason on 11/7/16.
 */
public class Model {

    private String name;

    private Set<Property> properties = new HashSet<>();

    public String getName() {
        return name;
    }

    public Model setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Property> getProperties() {
        return properties;
    }

    public Model setProperties(Set<Property> properties) {
        this.properties = properties;
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

        Model model = (Model) o;

        return name != null ? name.equals(model.name) : model.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
