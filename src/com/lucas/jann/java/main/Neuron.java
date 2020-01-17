package com.lucas.jann.java.main;

class Neuron {

    private double[] weights;
    private double bias;

    Neuron(int numPreviousConnections) {
        weights = new double[numPreviousConnections];
        for (int i = 0; i < numPreviousConnections; i++) {
            weights[i] = Math.random();
        }
        bias = Math.random();
    }

    double activation(double... inputs) {
        if (inputs.length != weights.length){
            throw new IllegalArgumentException(
                    "The length of inputs being " +
                            "activated in a neuron MUST BE " +
                            "the same as the number of " +
                            "previous connections/weights.");
        }

        double sum = bias;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }

        return 1 / (1 + Math.exp(-sum)); //sigmoid
        //return Math.max(0, sum); // ReLU; derivative is (sum > 0 ? 1 : 0)
    }
}








