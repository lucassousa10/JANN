import Neuron from './Neuron.js';


export default class Layer {

    constructor(numNeurons, numPrevious) {
        this.numNeurons = numNeurons;
        this.neurons = [];
        for (let i = 0; i < numNeurons; i++) {
            if (numPrevious === 0) {
                this.neurons.push(new Neuron(numNeurons));
            } else {
                this.neurons.push(new Neuron(numPrevious));
            }
        }
    }

    neuronsActivations(inputs) {
        const activations = [];
        for (let i = 0; i < this.numNeurons; i++) {
            activations.push(this.neurons[i].activation(inputs));
        }
        return activations;
    }
}