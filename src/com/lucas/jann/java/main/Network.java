package com.lucas.jann.java.main;

class Network {

    private Layer inputLayer;
    private Layer[] hiddenLayers;
    private Layer outputLayer;

    Network(int inputLayerSize,
            int[] hiddenLayersSizes,
            int outputLayerSize) {
        inputLayer = new Layer(inputLayerSize, 0);

        int tmpLastLayerSize = inputLayerSize;
        hiddenLayers = new Layer[hiddenLayersSizes.length];
        for (int i = 0; i < hiddenLayersSizes.length; i++) {
            hiddenLayers[i] = new Layer(
                    hiddenLayersSizes[i], tmpLastLayerSize);
            tmpLastLayerSize = hiddenLayersSizes[i];
        }

        outputLayer = new Layer(outputLayerSize, tmpLastLayerSize);
    }

    double[] feedForward(double... inputs) {
        if (inputs.length != inputLayer.numNeurons){
            throw new IllegalArgumentException("The amount of the main " +
                    "inputs passed MUST BE equals to the number of " +
                    "neurons in input layer.");
        }

        double[] lastOutput = inputLayer.neuronsActivations(inputs);
        for (Layer hiddenLayer : hiddenLayers) {
            lastOutput = hiddenLayer.neuronsActivations(lastOutput);
        }

        return outputLayer.neuronsActivations(lastOutput);
    }
}
