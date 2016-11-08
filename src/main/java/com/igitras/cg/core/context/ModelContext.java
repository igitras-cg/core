package com.igitras.cg.core.context;

import com.igitras.cg.core.exception.EnumExistsException;
import com.igitras.cg.core.exception.EnumInUsingException;
import com.igitras.cg.core.exception.ModelExistsException;
import com.igitras.cg.core.exception.ModelInUsingException;
import com.igitras.cg.core.model.Model;
import com.igitras.cg.core.model.Relationship;

/**
 * Created by mason on 11/7/16.
 */
public interface ModelContext {

    /**
     * Register a model to the context. Only non-exists model can be register.
     *
     * @param model model
     *
     * @throws ModelExistsException
     */
    void registModel(Model model) throws ModelExistsException;

    /**
     * Un-Register a model from the context. Only un-using model can be un-register.
     *
     * @param model model
     *
     * @throws ModelInUsingException
     */
    void unregistModel(Model model) throws ModelInUsingException;

    /**
     * Register a enum model to the context. Only non-exists enum model can be register.
     *
     * @param en enum object
     *
     * @throws EnumExistsException
     */
    void registEnum(Enum en) throws EnumExistsException;

    /**
     * Un-Register a enum model from the context. Only un-using model can be un-register.
     *
     * @param en enum object
     *
     * @throws EnumInUsingException
     */
    void unregistEnum(Enum en) throws EnumInUsingException;

    /**
     * Declaring a relationship between two model objects.
     *
     * @param relationship relationship
     */
    void makeRelation(Relationship relationship);

    /**
     * Un-declaring a relationship between two model objects.
     *
     * @param relationship relationship
     */
    void removeRelation(Relationship relationship);

}
