package com.lucas.jann.java.main;

import java.util.Arrays;

/**
 * testing
 */
public class Main {

    public static void main(String[] args) {
        Network network = new Network(
                //input layer size
                3,
                //hidden layer sizes
                new int[]{4},
                //output layer size
                2);
        double[] outputs = network.feedForward(1, 0, 1);
        System.out.println(Arrays.toString(outputs));
    }
}
