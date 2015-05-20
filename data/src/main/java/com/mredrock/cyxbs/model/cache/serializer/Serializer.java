package com.mredrock.cyxbs.model.cache.serializer;

/**
 * An interface provides some method to implements to serialize or deserializer.
 * <p>
 * Created by David on 15/5/19.
 */
public interface Serializer<T> {
    String serialize(T t);

    T deserialize(String jsonString, Class<T> clazz);
}
