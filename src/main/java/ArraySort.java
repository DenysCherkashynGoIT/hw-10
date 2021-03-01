package main.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraySort {
    public static Object sort(String[] strings) {
        return Arrays.stream(strings)
                .flatMap(s -> Arrays.stream(s.split("\\W+")))
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(", "));
    }
}
