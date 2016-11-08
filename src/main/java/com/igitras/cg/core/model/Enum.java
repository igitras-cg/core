package com.igitras.cg.core.model;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by mason on 11/7/16.
 */
public class Enum {

    private String name;
    private SortedSet<String> elements = new TreeSet<>();

    public String getName() {
        return name;
    }

    public Enum setName(String name) {
        this.name = name;
        return this;
    }

    public SortedSet<String> getElements() {
        return elements;
    }

    public Enum setElements(SortedSet<String> elements) {
        this.elements = elements;
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

        Enum anEnum = (Enum) o;

        return name != null ? name.equals(anEnum.name) : anEnum.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
