import Layer from './Layer.js';


export default class Network {

    constructor(inputLayerSize, hiddenLayersSizes, outputLayerSize){
        this.inputLayer = new Layer(inputLayerSize, 0);

        let tmpLastLayerSize = inputLayerSize;
        this.hiddenLayers = [];
        for (let i = 0; i < hiddenLayersSizes.length; i++) {
            this.hiddenLayers.push(new Layer(hiddenLayersSizes[i], tmpLastLayerSize));
            tmpLastLayerSize = hiddenLayersSizes[i];
        }
        this.outputLayer = new Layer(outputLayerSize, tmpLastLayerSize);
    }

    feedForwardOutput(inputs){
        let lastOutput = this.inputLayer.neuronsActivations(inputs);
        this.hiddenLayers.forEach(hiddenLayer => {
            lastOutput = hiddenLayer.neuronsActivations(lastOutput);
        });
        return this.outputLayer.neuronsActivations(lastOutput);
    }
}