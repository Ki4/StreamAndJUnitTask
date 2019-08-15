package com.gmail.sergeykichukki4;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamOperationsTest {

    int[] arrTest = {1, 2, 31, 17, 2, 7, 9};
    //int[] arrTestForMultiplyAllElementsFunction = {10, 20, 310, 170, 20, 70, 90};
    List<String> operatingList = Arrays.asList("Ivan", "Fedor", "Peter", "Natasha", "Sergei");
    Collection<String> secondOperatingList = Arrays.asList("1, 2, 0", "4, 5");
    StreamOperations streamOperations = new StreamOperations();

    @Test
    public void averageNumber() {
        double actual = streamOperations.averageNumber(arrTest);
        double expected = 9.85714285714;

        Assert.assertEquals(actual, expected, 0.01);
    }

    @Test
    public void minNumber() {
        int actual = streamOperations.minNumber(arrTest);
        int expected = 1;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void minIndex() {
        int actual = streamOperations.minIndex(arrTest);
        int expected = 0;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void countZeros() {
        int actual = streamOperations.countZeros(arrTest);
        int expected = 0;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void moreThanZero() {
        int actual = streamOperations.moreThanZero(arrTest);
        int expected = 7;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void multiplyAllElements() {
        List<Integer> actual = streamOperations.multiplyAllElements(arrTest, 10).boxed().collect(Collectors.toList());
        IntStream expected = IntStream.of(arrTest).map(x -> x * 10);
        List<Integer> adoptedExpected = expected.boxed().collect(Collectors.toList());

        /*List<Integer> adoptedExpected = new ArrayList<Integer>();
        for (int i : arrTestForMultiplyAllElementsFunction) {
            adoptedExpected.add(i);
        }*/

        Assert.assertEquals(adoptedExpected, actual);
    }

    @Test
    public void anOddsIndicatedAndPlusNumber() {
        String actual = streamOperations.anOddsIndicatedAndPlusNumber(operatingList);
        String expected = "1. Ivan, 3. Peter, 5. Sergei";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void mapToUpperacaseAndThenSortDescending() {
        List<String> actual = streamOperations.mapToUppercaseAndThenSortDescending(operatingList);
        List<String> expected = Arrays.asList("FEDOR", "IVAN", "NATASHA", "PETER", "SERGEI");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllNumbersListedSeparatedByCommasFromAllTheElements() {
        List<Integer> actual = streamOperations.ArraygetAllNumbersListedSeparatedByCommasFromAllTheElements(secondOperatingList);
        List<Integer> expected = Arrays.asList(1, 2, 0, 4, 5);
        Assert.assertEquals(expected, actual);
    }
}