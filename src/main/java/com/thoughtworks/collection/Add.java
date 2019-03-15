package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        IntStream stream = leftBorder < rightBorder ? IntStream.rangeClosed(leftBorder, rightBorder) : IntStream.range(rightBorder, leftBorder + 1);
        return stream.filter(x -> x % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        IntStream stream = leftBorder < rightBorder ? IntStream.rangeClosed(leftBorder, rightBorder) : IntStream.range(rightBorder, leftBorder + 1);
        return stream.filter(x -> x % 2 != 0).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(Integer::intValue).map(x -> x * 3 + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(Integer::intValue).mapToObj(x -> x % 2 == 0 ? x : x * 3 + 2).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(Integer::intValue).filter(x -> x % 2 != 0).map(x -> x * 3 + 5).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> collect = arrayList.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());
        return (collect.get((int) Math.floor((collect.size() - 1) / 2.0)) + collect.get((int) (Math.ceil((collect.size() - 1) / 2.0)))) / 2.0;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().mapToDouble(Integer::intValue).filter(i -> i % 2 == 0).average().orElse(0.0);
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream().filter(i -> i % 2 == 0).anyMatch(i -> i.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> even = arrayList.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());
        List<Integer> odd = arrayList.stream().filter(i -> i % 2 != 0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        even.addAll(odd);
        return even;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        return IntStream.range(1, arrayList.size()).mapToObj(i -> (arrayList.get(i) + arrayList.get(i - 1)) * 3).collect(Collectors.toList());
    }
}
