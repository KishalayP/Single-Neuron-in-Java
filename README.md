## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

## Dependency Management

The `JAVA DEPENDENCIES` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-pack/blob/master/release-notes/v0.9.0.md#work-with-jar-files-directly).

## Class Description

Basic implementation of a Single Neuron in Java from scratch.

            Inputs                            Outputs

     A          B          C  

     0          0          1                     0

     1          1          1                     1

     1          0          1                     1

     0          1          1                     0


     As can be seen from the above it can be inferred that whenever the input A is '1' the output is '1' else '0'.
     The model is trained on the above data using a simple error correction loop and sigmoid function for scaling.

     Example Test Case:

     1          0          0                     1

