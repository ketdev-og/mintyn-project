package com.orders.mintyn_order.utils;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Helpers {
    public static String genRandomId(String prefix) {

        Set<Integer> set = new Random().ints(0, 100)
                .distinct()
                .limit(5)
                .boxed()
                .collect(Collectors.toSet());
        StringBuilder stringBuilder = new StringBuilder();
        for (int x : set) {
            stringBuilder.append(Integer.toString(x));

        }
        String id = stringBuilder.toString();
        id = id.trim();
        return prefix + id;
    }
}
