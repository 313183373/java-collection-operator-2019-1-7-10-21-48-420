package com.thoughtworks.collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        return left < right ? IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList()) :
                IntStream.rangeClosed(right, left).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return getListByInterval(left, right).stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(i -> i % 2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        return Arrays.stream(firstArray).filter(i -> Arrays.stream(secondArray).anyMatch(j -> j == i)).boxed().collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, firstArray);
        Collections.addAll(list, secondArray);
        return list.stream().distinct().collect(Collectors.toList());
    }
}
