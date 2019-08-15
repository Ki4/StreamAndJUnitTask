package com.gmail.sergeykichukki4;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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

    public int minIndex(int[] array) {
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

    /**Task 1:
     * The method takes a list of names. Returns a string of the form
     * "1. Ivan, 3. Peter ...", only with names on odd indices, respectively.*/

    public String anOddsIndicatedAndPlusNumber(List<String> list) {
        StringBuilder returnedString = new StringBuilder();
        list.stream().forEach(str -> {
            if ((list.indexOf(str) % 2) == 0) {
                returnedString.append(list.indexOf(str) + 1).append(". ").append(str);
                if (list.size() != list.indexOf(str) + 1) {
                    returnedString.append(", ");
                }
            }
        });
        return returnedString.toString();
    }

    /**Task 2:
     * The method map list of string to uppercase and then sort descending*/
    public List<String> mapToUppercaseAndThenSortDescending(List<String> list) {
        List<String> namesToUppercaselistPlusNaturalOrder = list.stream().sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        return namesToUppercaselistPlusNaturalOrder;
    }

    /**Task 3:
     * Given and collection = Arrays.asList ("1, 2, 0", "4, 5")
     * From the collection get all the numbers listed, separated by commas from all the elements*/
    public  List<Integer> ArraygetAllNumbersListedSeparatedByCommasFromAllTheElements(Collection<String> collection) {
        List<Integer> returnedList = new ArrayList<>();
        collection.stream().forEach(p -> Arrays.asList(p.split(",")).forEach(s -> returnedList.add(Integer.parseInt(s.trim()))));
        return returnedList;
    }
}
