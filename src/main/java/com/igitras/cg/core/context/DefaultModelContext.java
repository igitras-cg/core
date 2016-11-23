package com.igitras.cg.core.context;

import static com.igitras.cg.core.model.PropertyType.Enum;

import com.igitras.cg.core.exception.EnumExistsException;
import com.igitras.cg.core.exception.EnumInUsingException;
import com.igitras.cg.core.exception.MissingModelException;
import com.igitras.cg.core.exception.ModelExistsException;
import com.igitras.cg.core.exception.ModelInUsingException;
import com.igitras.cg.core.exception.RelationshipExistsException;
import com.igitras.cg.core.model.EnumModel;
import com.igitras.cg.core.model.Model;
import com.igitras.cg.core.model.Relationship;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Default model context for models storing.
 *
 * @author mason
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
                        .anyMatch(property -> property.getType() == Enum
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
        // update the relationship models to model in models.
        this.relationships.stream().forEach(relationship -> {
            Model from = relationship.getFrom();
            this.models.stream().filter(model -> model == from).forEach(relationship::setFrom);
            Model to = relationship.getTo();
            this.models.stream().filter(model -> model == to).forEach(relationship::setTo);
        });

        // update the enum of the properties in model to that in enums.
        this.models.stream().forEach(model -> {
            model.getProperties().stream().filter(property -> property.getType() == Enum).forEach(property -> {
                EnumModel enumModel = property.getEnumModel();
                this.enums.stream().filter(em -> em == enumModel).forEach(property::setEnumModel);
            });
        });
    }

    @Override
    public void validate() {
        this.relationships.stream().forEach(relationship -> {
            if (!this.models.contains(relationship.getFrom())) {
                throw new MissingModelException(relationship.getFrom().getName());
            }

            if (!this.models.contains(relationship.getTo())) {
                throw new MissingModelException(relationship.getTo().getName());
            }
        });

        this.models.stream().forEach(model -> {
            model.getProperties().stream().filter(property -> property.getType() == Enum).forEach(property -> {
                if (!this.enums.contains(property.getEnumModel())) {
                    throw new MissingModelException(property.getEnumModel().getName());
                }
            });
        });
    }
}
