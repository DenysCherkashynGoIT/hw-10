package main.java;

import java.util.Iterator;
import java.util.stream.Stream;

public class StreamMixer {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator firstItr = first.iterator();
        Iterator secondItr = second.iterator();
        Stream.Builder<T> builder = Stream.builder();
        while (firstItr.hasNext() && secondItr.hasNext()) {
            builder.add((T) firstItr.next());
            builder.add((T) secondItr.next());
        }
        return builder.build();
    }
}
