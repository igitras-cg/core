package com.igitras.cg.core.model.deserializer;

import static com.igitras.cg.core.utils.Constant.Model.ENUM;
import static com.igitras.cg.core.utils.Constant.Model.MODEL;
import static com.igitras.cg.core.utils.Constant.Model.RELATION;

import com.igitras.cg.core.exception.IllegalModelConfigException;

/**
 * Deserializer Factory.
 *
 * @author mason
 */
public abstract class DeserializerFactory {

    /**
     * Get a deserializer with a given model type.
     *
     * @param modelType model type
     *
     * @return model deserializer
     *
     * @throws IllegalModelConfigException
     */
    public static Deserializer getDeserializer(String modelType) throws IllegalModelConfigException {
        switch (modelType) {
            case MODEL:
                return new ModelDeserializer();
            case ENUM:
                return new EnumDeserializer();
            case RELATION:
                return new RelationshipDeserializer();
            default:
                throw new IllegalModelConfigException(modelType);
        }
    }
}
