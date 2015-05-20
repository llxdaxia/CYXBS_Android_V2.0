package com.mredrock.cyxbs.model.cache.serializer;

import com.alibaba.fastjson.JSON;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class user as Serializer/Deserializer for class.
 * <p>
 * Created by David on 15/5/19.
 */
@Singleton
public class FastJsonSerializer<T> implements Serializer<T> {

    @Inject
    public FastJsonSerializer() {
    }

    /**
     * Serialize an object to Json.
     *
     * @param t {@link T} to serialize.
     */
    public String serialize(T t) {
        return JSON.toJSONString(t);
    }

    /**
     * Deserialize a json representation of an object.
     *
     * @param jsonString A json string to deserialize.
     * @param clazz      class fo T.
     * @return {@link T}
     */
    @SuppressWarnings("unchecked")
    public T deserialize(String jsonString, Class<T> clazz) {
        return JSON.parseObject(jsonString, clazz);
    }
}
