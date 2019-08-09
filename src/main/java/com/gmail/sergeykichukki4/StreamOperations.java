package com.gmail.sergeykichukki4;

import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamOperations {
    public StreamOperations() {
    }

    public double averageNumber(int[] array) {
        return IntStream.of(array).average().getAsDouble();
    }

    public int minNumber(int[] array) {
        return IntStream.of(array).min().getAsInt();
    }

    public int minIdex(int[] array) {
        return IntStream.of(array).boxed().collect(Collectors.toList()).indexOf(minNumber(array));
    }

    public int countZeros(int[] array) {
        return (int) IntStream.of(array).filter(arr -> arr == 0).count();
    }

    public int moreThanZero(int[] array) {
        return (int) IntStream.of(array).filter(arr -> arr > 0).count();
    }

    public IntStream multiplyAllElements(int[] array, int number) {
        return IntStream.of(array).map(arr -> arr * number);
    }
}
