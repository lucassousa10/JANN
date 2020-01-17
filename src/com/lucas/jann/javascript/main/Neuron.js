export default class Neuron {

    constructor(numPreviousConnections) {
        this.weights = [];
        for (let i = 0; i < numPreviousConnections; i++) {
            this.weights.push(Math.random());
        }
        this.bias = Math.random();
    }

    //these inputs comes from the previous layer.
    //in the case of this neuron is living at the input
    //layer, the inputs are, e.g., the main input passed
    //by the user.
    activation(inputs) {
        let sum = this.bias;
        for (let i = 0; i < inputs.length; i++) {
            sum += inputs[i] * this.weights[i];
        }

        return 1 / (1 + Math.exp(-sum)); //sigmoid
        //return Math.max(0, sum); // ReLU; its derivative is (sum > 0 ? 1 : 0)
    }
}