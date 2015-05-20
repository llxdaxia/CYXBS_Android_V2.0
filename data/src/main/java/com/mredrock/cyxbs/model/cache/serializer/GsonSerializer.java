/**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mredrock.cyxbs.model.cache.serializer;

import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Class user as Serializer/Deserializer for class.
 */
@Singleton
public class GsonSerializer<T> implements Serializer<T> {

    private final Gson gson = new Gson();

    @Inject
    public GsonSerializer() {
    }

    /**
     * Serialize an object to Json.
     *
     * @param t {@link T} to serialize.
     */
    @Override
    public String serialize(T t) {
        return gson.toJson(t);
    }

    /**
     * Deserialize a json representation of an object.
     *
     * @param jsonString A json string to deserialize.
     * @param clazz      class fo T.
     * @return {@link T}
     */
    @Override
    public T deserialize(String jsonString, Class<T> clazz) {

        return gson.fromJson(jsonString, clazz);
    }
}
