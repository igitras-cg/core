package com.igitras.cg.core.model;

import com.google.common.base.MoreObjects;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Enum model.
 *
 * @author mason
 */
public class EnumModel extends Model {

    private SortedSet<String> elements = new TreeSet<>();

    public SortedSet<String> getElements() {
        return elements;
    }

    public EnumModel setElements(SortedSet<String> elements) {
        this.elements = elements;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("elements", elements)
                .toString();
    }
}
