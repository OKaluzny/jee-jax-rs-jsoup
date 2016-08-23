package com.kaluzny.nasdaq.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GsonEntityConverter implements MessageBodyReader<Object>, MessageBodyWriter<Object> {

    private static final Logger LOGGER = Logger.getLogger(GsonEntityConverter.class.getName());

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        LOGGER.info("Check that entity is readable.");

        return getExactType(genericType) != null;
    }

    @Override
    public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                           MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
        LOGGER.info("Read entity.");

        Gson gson = new GsonBuilder().create();
        return gson.fromJson(new InputStreamReader(entityStream), type);
    }

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        LOGGER.info("Check that entity is writeable.");

        return getExactType(genericType) != null;
    }

    @Override
    public long getSize(Object entity, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }

    @Override
    public void writeTo(Object entity, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
            throws IOException, WebApplicationException {
        LOGGER.info("Write entity.");

        GsonBuilder builder = new GsonBuilder();
        if (getExactType(genericType).getAnnotation(GsonEntity.class).prettyPrint()) {
            builder.setPrettyPrinting();
        }
        Gson gson = builder.create();

        OutputStreamWriter writer = new OutputStreamWriter(entityStream, StandardCharsets.UTF_8);
        gson.toJson(entity, writer);
        writer.flush();
    }

    private Class<?> getExactType(Type genericType) {
        if (genericType instanceof Class) {
            Class<?> type = (Class<?>) genericType;
            if (type.isAnnotationPresent(GsonEntity.class)) {
                LOGGER.info(() -> String.format("%s is supported.", type.getName()));
                return type;
            }
        }

        if (genericType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericType;
            Class<?> rawType = (Class<?>) parameterizedType.getRawType();
            if (List.class.isAssignableFrom(rawType)) {
                Class<?> typeArgument = (Class<?>) parameterizedType.getActualTypeArguments()[0];
                if (typeArgument.isAnnotationPresent(GsonEntity.class)) {
                    LOGGER.info(() -> String.format("List of %s is supported.", typeArgument.getName()));
                    return typeArgument;
                }
            }
        }

        return null;
    }
}