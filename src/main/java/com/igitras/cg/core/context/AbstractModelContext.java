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
public class AbstractModelContext implements ModelContext {
    @Override
    public void registModel(Model model) throws ModelExistsException {
        
    }

    @Override
    public void unregistModel(Model model) throws ModelInUsingException {

    }

    @Override
    public void registEnum(Enum en) throws EnumExistsException {

    }

    @Override
    public void unregistEnum(Enum en) throws EnumInUsingException {

    }

    @Override
    public void makeRelation(Relationship relationship) {

    }

    @Override
    public void removeRelation(Relationship relationship) {

    }
}
