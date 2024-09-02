package com.example.twitterspringproject.converter.hibernate;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TagsDescriptor extends AbstractTypeDescriptor<List<String>> {

    public final static TagsDescriptor INSTANCE = new TagsDescriptor();
    protected TagsDescriptor() {
        super((Class<List<String>>) (Class<?>) List.class);
    }

    @Override
    public List<String> fromString(String string) {
        List<String> result;
        if(Objects.isNull(string) || string.isEmpty()){
            return new ArrayList<>();
        }
        return List.of(string.split(", "));
    }

    @Override
    public <X> X unwrap(List<String> value, Class<X> aClass, WrapperOptions wrapperOptions) {
        if(Objects.isNull(value) || value.isEmpty()){
            return null;
        }
        String dbLine = value.toString().replace("[", "").replace("]", "");
        return (X)dbLine;
    }

    @Override
    public <X> List<String> wrap(X value, WrapperOptions wrapperOptions) {
        return fromString(value.toString());
    }
}
