package com.example;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import org.junit.Test;

import java.util.Set;

public class ArrayListMultimapTest {

    @Test
    public void test() {
        Multimap<String, String> multimap = ArrayListMultimap.create();

        multimap.put("jack", "A");
        multimap.put("jack", "B");
        multimap.put("tom", "C");
        multimap.put("tom", "D");
        System.out.println(multimap.entries());

        Multiset multiset = multimap.keys();
        System.out.println(multiset);
        Set<String> set = multimap.keySet();
        System.out.println(set);

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
