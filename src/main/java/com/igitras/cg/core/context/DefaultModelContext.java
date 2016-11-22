package com.igitras.cg.core.context;

import com.igitras.cg.core.exception.EnumExistsException;
import com.igitras.cg.core.exception.EnumInUsingException;
import com.igitras.cg.core.exception.ModelExistsException;
import com.igitras.cg.core.exception.ModelInUsingException;
import com.igitras.cg.core.exception.RelationshipExistsException;
import com.igitras.cg.core.model.EnumModel;
import com.igitras.cg.core.model.Model;
import com.igitras.cg.core.model.PropertyType;
import com.igitras.cg.core.model.Relationship;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mason on 11/7/16.
 */
public class DefaultModelContext implements ModelContext {

    private Set<String> names = new HashSet<>();

    private Set<Model> models = new HashSet<>();
    private Set<EnumModel> enums = new HashSet<>();
    private Set<Relationship> relationships = new HashSet<>();

    @Override
    public void registerModel(Model model) throws ModelExistsException {
        if (names.contains(model.getName())) {
            throw new ModelExistsException(model.getName());
        }
        models.add(model);
    }

    @Override
    public void unregisterModel(Model model) throws ModelInUsingException {
        if (relationships.stream().anyMatch(r -> r.getFrom().equals(model) || r.getTo().equals(model))) {
            throw new ModelInUsingException();
        }
        models.remove(model);
    }

    @Override
    public void registerEnum(EnumModel en) throws EnumExistsException {
        if (names.contains(en.getName())) {
            throw new EnumExistsException(en.getName());
        }
        enums.add(en);
    }

    @Override
    public void unregisterEnum(EnumModel en) throws EnumInUsingException {
        if (models.stream()
                .anyMatch(m -> m.getProperties()
                        .stream()
                        .anyMatch(property -> property.getType() == PropertyType.Enum
                                && property.getEnumModel().equals(en)))) {
            throw new EnumInUsingException();
        }
        enums.remove(en);
    }

    @Override
    public void registerRelation(Relationship relationship) throws RelationshipExistsException {
        if (relationships.contains(relationship)) {
            throw new RelationshipExistsException(relationship);
        }
        relationships.add(relationship);
    }

    @Override
    public void unregisterRelation(Relationship relationship) {
        relationships.remove(relationship);
    }

    @Override
    public Set<Model> getAllModels() {
        return Collections.unmodifiableSet(models);
    }

    @Override
    public Set<EnumModel> getAllEnums() {
        return Collections.unmodifiableSet(enums);
    }

    @Override
    public Set<Relationship> getAllRelationship() {
        return Collections.unmodifiableSet(relationships);
    }

    @Override
    public void postProcess() {
        // TODO: validate and processing
    }
}
