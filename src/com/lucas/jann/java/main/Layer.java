package com.lucas.jann.java.main;

class Layer {

    int numNeurons;
    private Neuron[] neurons;

    Layer(int numNeurons, int numPrevious) {
        this.numNeurons = numNeurons;
        neurons = new Neuron[numNeurons];

        for (int i = 0; i < numNeurons; i++) {
            if (numPrevious == 0) {
                neurons[i] = new Neuron(numNeurons);
            } else {
                neurons[i] = new Neuron(numPrevious);
            }
        }
    }

    double[] neuronsActivations(double... inputs) {
        double[] activations = new double[numNeurons];
        for (int i = 0; i < numNeurons; i++) {
            activations[i] = neurons[i].activation(inputs);
        }
        return activations;
    }
}
