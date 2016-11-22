package com.igitras.cg.core.context;

import com.igitras.cg.core.exception.EnumExistsException;
import com.igitras.cg.core.exception.EnumInUsingException;
import com.igitras.cg.core.exception.ModelExistsException;
import com.igitras.cg.core.exception.ModelInUsingException;
import com.igitras.cg.core.exception.RelationshipExistsException;
import com.igitras.cg.core.model.EnumModel;
import com.igitras.cg.core.model.Model;
import com.igitras.cg.core.model.Relationship;

import java.util.Set;

/**
 * Model Context.
 *
 * @author mason
 */
public interface ModelContext extends PostProcessing {

    /**
     * Register a model to the context. Only non-exists model can be register.
     *
     * @param model model
     *
     * @throws ModelExistsException
     */
    void registerModel(Model model) throws ModelExistsException;

    /**
     * Un-Register a model from the context. Only un-using model can be un-register.
     *
     * @param model model
     *
     * @throws ModelInUsingException
     */
    void unregisterModel(Model model) throws ModelInUsingException;

    /**
     * Register a enum model to the context. Only non-exists enum model can be register.
     *
     * @param en enum object
     *
     * @throws EnumExistsException
     */
    void registerEnum(EnumModel en) throws EnumExistsException;

    /**
     * Un-Register a enum model from the context. Only un-using model can be un-register.
     *
     * @param en enum object
     *
     * @throws EnumInUsingException
     */
    void unregisterEnum(EnumModel en) throws EnumInUsingException;

    /**
     * Declaring a relationship between two model objects.
     *
     * @param relationship relationship
     */
    void registerRelation(Relationship relationship) throws RelationshipExistsException;

    /**
     * Un-declaring a relationship between two model objects.
     *
     * @param relationship relationship
     */
    void unregisterRelation(Relationship relationship);

    /**
     * Get all the register models
     *
     * @return models
     */
    Set<Model> getAllModels();

    /**
     * Get all the register enum models.
     *
     * @return enum models.
     */
    Set<EnumModel> getAllEnums();

    /**
     * Get all the register relationships.
     *
     * @return relationships.
     */
    Set<Relationship> getAllRelationship();

}
