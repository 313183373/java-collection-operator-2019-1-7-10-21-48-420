package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {
    }

    public InverseReduce(Random random) {
        this.random = random;
    }

    //todo: find a more elegant solution
    public List<Integer> divideToSmaller(int number) {
        List<Integer> list = new ArrayList<>();
        int n = random.nextInt(3);
        while (number > n) {
            list.add(number - n);
            number -= n;
        }
        return list;
    }
}
