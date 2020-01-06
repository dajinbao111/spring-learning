package com.example.config;

import com.google.common.collect.ArrayListMultimap;

import java.util.List;

public class LocalCache {

    private static ArrayListMultimap multimap = ArrayListMultimap.create();

    public static void put(String key, Object value) {
        multimap.put(key, value);
    }

    public static List<Object> get(String key) {
        return multimap.get(key);
    }

    public static boolean remove(String key, Object value) {
        return multimap.remove(key, value);
    }

    public static void removeAll(String key) {
        multimap.removeAll(key);
    }
}
