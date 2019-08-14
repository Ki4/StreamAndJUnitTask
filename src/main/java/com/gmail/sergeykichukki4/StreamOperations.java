package com.gmail.sergeykichukki4;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    public String anOddsIndicatedAndPlusNumber(List<String> list) {
        String returnedString = "";
        return returnedString;
    }

    public List<String> mapToUppercaseAndThenSortDescending(List<String> list) {
        List<String> namesToUppercaselistPlusNaturalOrder = list.stream().sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        return namesToUppercaselistPlusNaturalOrder;
    }

    public List<Integer> getAllNumbersListedSeparatedByCommasFromAllTheElements(Collection<String> list) {
        List<Integer> returnedList = list.stream().flatMapToInt((p) -> Arrays.asList(p.split(",")).stream().mapToInt(Integer::parseInt)).boxed().collect(Collectors.toList());

        return returnedList;
    }
}
