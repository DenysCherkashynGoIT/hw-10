package main.java;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListHandler {
    public String getOdd(List<String> list) {
        return IntStream.range(0, list.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> String.format("%d. %s", i + 1, list.get(i)))
                .collect(Collectors.joining(", "));
    }

    public List<String> toUpperCaseReversed(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}
