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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        EnumModel enumModel = (EnumModel) o;

        return elements != null ? elements.equals(enumModel.elements) : enumModel.elements == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (elements != null ? elements.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("elements", elements)
                .toString();
    }
}
