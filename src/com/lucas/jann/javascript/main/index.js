import Network from './Network.js';


const network = new Network(3, [4, 2], 2);
const outputs = network.feedForwardOutput([1, 0, 1]);
console.log(outputs);
