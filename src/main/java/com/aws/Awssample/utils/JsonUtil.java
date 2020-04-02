package com.aws.Awssample.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public final class JsonUtil {
    private JsonUtil() {}

    static final ObjectMapper propertyMapper = new ObjectMapper();

    public static <E> List<E> toListFromString(String src, final TypeReference<List<E>> valueTypeRef)
    {
        List<E> object = null;
        try {
            object = propertyMapper.readValue(src,valueTypeRef);
        } catch (IOException exception) {
            final String errorMsg = "Json to Object transformation failed: " + src;
            throw new RuntimeException(errorMsg);
//			throw new ApplicationException(errorMsg,exception,ProcessingStatusCode.INTERNAL_SERVER_ERROR);
        }
        return object;
    }
}
