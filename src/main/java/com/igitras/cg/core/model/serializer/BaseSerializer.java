package com.igitras.cg.core.model.serializer;

import com.igitras.cg.core.model.Template;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

/**
 * Created by mason on 11/17/16.
 */
public abstract class BaseSerializer<T> implements Template<T>, Serializer<T> {

    private static final Logger LOG = LoggerFactory.getLogger(BaseSerializer.class);

    private final PebbleEngine engine = new PebbleEngine.Builder().cacheActive(true).build();

    @Override
    public String serialize(T model) {
        try {
            String tmFile = getTemplate();
            PebbleTemplate template = engine.getTemplate(tmFile);
            Writer writer = new StringWriter();
            template.evaluate(writer, buildContext(model));
            return writer.toString();
        } catch (PebbleException e) {
            LOG.warn("read template failed.");
        } catch (IOException e) {
            LOG.warn("write with template failed.");
        }

        throw new SerializationException(model.getClass(), model.toString());
    }

}
