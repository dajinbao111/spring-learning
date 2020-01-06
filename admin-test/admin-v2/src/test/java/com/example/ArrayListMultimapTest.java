package com.example;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

public class ArrayListMultimapTest {

    @Test
    public void test() {
        Multimap<String, String> multimap = ArrayListMultimap.create();

        multimap.put("jack", "A");
        multimap.put("jack", "B");
        multimap.put("tom", "C");
        multimap.put("tom", "D");
        System.out.println(multimap.entries());

        multimap.removeAll("tom");
        System.out.println(multimap.entries());

        boolean hasKey = multimap.containsKey("jack");
        System.out.println(hasKey);
        hasKey = multimap.containsKey("tom");
        System.out.println(hasKey);

        boolean hasEntry = multimap.containsEntry("jack", "A");
        System.out.println(hasEntry);

        multimap.remove("jack", "B");
        System.out.println(multimap.entries());
    }
}
