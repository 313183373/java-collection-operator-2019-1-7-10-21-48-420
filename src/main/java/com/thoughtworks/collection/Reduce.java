package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().max(Comparator.comparing(Integer::valueOf)).orElse(0);
    }

    public double getMinimum() {
        return arrayList.stream().min(Comparator.comparing(Integer::valueOf)).orElse(0);
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public double getOrderedMedian() {
        List<Integer> collect = arrayList.stream().sorted().collect(Collectors.toList());
        return (collect.get((int) Math.floor((collect.size() - 1) / 2.0)) + collect.get((int) (Math.ceil((collect.size() - 1) / 2.0)))) / 2.0;
    }

    public int getFirstEven() {
        if(arrayList.stream().anyMatch(i -> i % 2 == 0)) {
            return arrayList.stream().reduce((accumulator, i) -> (accumulator % 2 == 0) ? accumulator : i).get();
        }
        return -1;
    }

    public int getIndexOfFirstEven() {
//        return arrayList.indexOf(getFirstEven());
        if(arrayList.stream().anyMatch(i -> i % 2 == 0)) {
            return IntStream.range(0, arrayList.size()).reduce((accumulator, index) -> arrayList.get(accumulator) % 2 == 0 ? accumulator : index).orElse(-1);
        }
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList) {
        return Arrays.deepEquals(this.arrayList.toArray(), arrayList.toArray());
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        return (((Integer) singleLink.getNode((int) Math.floor((arrayList.size() + 1) / 2.0))).doubleValue() + ((Integer) singleLink.getNode((int) Math.ceil((arrayList.size() + 1) / 2.0))).doubleValue()) / 2.0;
    }

    public int getLastOdd() {
        if(arrayList.stream().anyMatch(i -> i % 2 != 0)) {
            return arrayList.stream().reduce((accumulator, i) -> i % 2 != 0 ? i : accumulator).get();
        }
        return -1;
    }

    public int getIndexOfLastOdd() {
        if(arrayList.stream().anyMatch(i -> i % 2 != 0)) {
            return IntStream.range(0, arrayList.size()).reduce((accumulator, index) -> arrayList.get(index) % 2 != 0 ? index : accumulator).orElse(-1);
        }
        return -1;
    }
}
