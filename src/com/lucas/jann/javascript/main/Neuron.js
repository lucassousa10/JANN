export default class Neuron {

    constructor(numPreviousConnections){
        this.weights = [];
        for (let i = 0; i < numPreviousConnections; i++) {
            this.weights.push(Math.random());
        }
        this.bias = Math.random();
    }

    activation(inputs){
        let sum = this.bias;
        for (let i = 0; i < inputs.length; i++) {
            sum += inputs[i] * this.weights[i];
        }

        //sigmoid
        return 1 / (1 + Math.exp(-sum));
    }
}