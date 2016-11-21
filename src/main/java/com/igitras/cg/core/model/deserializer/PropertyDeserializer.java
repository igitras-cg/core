package com.igitras.cg.core.model.deserializer;

import static com.igitras.cg.core.model.PropertyType.valueOf;

import com.igitras.cg.core.model.Constrain;
import com.igitras.cg.core.model.EnumModel;
import com.igitras.cg.core.model.Property;
import com.igitras.cg.core.model.PropertyType;

/**
 * Property deserializer.
 *
 * @author mason
 */
public class PropertyDeserializer extends BaseDeserializer<Property> {
    @Override
    public Property newInstance() {
        return new Property();
    }

    @Override
    public void parseTo(String content, Property instance) {
        String[] split = content.split("[\\s]+");
        assert split.length >= 2;
        instance.setName(split[0]);

        try {
            PropertyType propertyType = valueOf(split[1]);
            instance.setType(propertyType);
            instance.setEnumModel(null);
        } catch (IllegalArgumentException e) {
            EnumModel model = new EnumModel();
            model.setName(split[1]);
            instance.setEnumModel(model);
        }

        for (int i = 2; i < split.length; i++) {
            instance.getConstrains().add(Constrain.valueOf(split[i]));
        }
    }

    @Override
    protected String normalize(String serialized) {
        return super.normalize(serialized).replaceAll("[\\s]+;[\\s]*", "");
    }
}
