package main.java;

import java.math.BigInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Random {
    public Stream<Long> streamLong(long a, long c, long m, long seed) {
        BigInteger bigA = BigInteger.valueOf(a);
        BigInteger bigC = BigInteger.valueOf(c);
        BigInteger bigM = BigInteger.valueOf(m);
        BigInteger bigSeed = BigInteger.valueOf(seed);

        UnaryOperator<BigInteger> generator = x -> bigA.multiply(x).add(bigC).mod(bigM);

        return Stream.iterate(bigSeed, generator).map(BigInteger::longValue);
    }
}
