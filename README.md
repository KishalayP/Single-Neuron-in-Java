## Welcome

Welcome to Neural Network from scratch using Java.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies


## Class Description

Basic implementation of a Single Neuron in Java from scratch.

            Inputs                            Outputs

     A          B          C  

     0          0          1                     0

     1          1          1                     1

     1          0          1                     1

     0          1          1                     0


     As can be seen from the above table it can be inferred that whenever the input A is '1' the output is '1' else '0'.
     The model is trained on the above data using a simple error correction loop and sigmoid function for scaling.

     Example Test Case:

     1          0          0                     1
 
 Use these weights in case weight intialization does not work: double synaptic_weights[][]={{-0.16595599},{0.44064899},{-0.99977125}}; 
