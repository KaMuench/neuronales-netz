# neuronales-netz (IntellijIDEA Project)
Thist was a project for the AI module at my university.   

<img src="https://github.com/KaMuench/neuronales-netz/assets/104307796/2f240245-d6a0-4662-a31d-d70fc6678931" alt="sudoku image" width="300"> 

The main goal was to build a neural network. This network can have multiple layers with at least an input and an output layer. Each layer takes input values, processes them and passes them on to the succeeding layer, until the last layer is reached. In the last layer the resulting values are verified against the so called class value. After this verification each parameter of each neuron is adjusted using a calculated delta. This process is called [Backpropagation - Wikipedia](https://de.wikipedia.org/wiki/Backpropagation).  

This whole process is repeated, with the goal to reduce the delta of the final layer until the predictions of the neural network are as close as possible to the actual class values.

More detailed information to the functionality of neural networks can be found for exmaple at [https://databasecamp.de/ki/backpropagation-grundlagen](https://databasecamp.de/ki/backpropagation-grundlagen#:~:text=Backpropagation%20ist%20eine%20Art%20%C3%BCberwachter,Reinforcement%20Learning%20verwendet%20werden%20k%C3%B6nnen).


## Test Data
The data for the testing are these four files:
- [data_ecken.txt](https://github.com/KaMuench/neuronales-netz/blob/master/src/main/resources/data_ecken.txt)
- [data_gerade.txt](https://github.com/KaMuench/neuronales-netz/blob/master/src/main/resources/data_gerade.txt)
- [data_kreis.txt](https://github.com/KaMuench/neuronales-netz/blob/master/src/main/resources/data_kreis.txt)
- [data_kurve.txt](https://github.com/KaMuench/neuronales-netz/blob/master/src/main/resources/data_kurve.txt)

Each data file contains several coordinates and a class value for each of this coordinates. There are two types of classes, 0 and 1. So each coordinate is matched with either a zero or a one.  
When starting the program, the neural network is fed with this coordinates. Then the neural network is trained to predict the right class for the input coordinates. 

## Review of process state
To follow the training there is a simple GUI window. The coordinates of the test data are displayed there, coloured according to their class value. (0=blue, red=1)

The background is divided into 100 * 100 coordinate points. Every cycle the neural network is feed with all these background coordinates to predict a class. The background coordinates are then coloured according to the outcome, either light blue or orange.  
The better the network can predict the right class, the more the background color around the data coordinates matches the color of these data points.  

As seen belowe the background color changes over time until it matches the data coordinates.  

<img src="https://github.com/KaMuench/neuronales-netz/assets/104307796/444d7e47-60f9-4169-9bb8-0d830206f029" alt="sudoku image" width="300"></img>   
[data_kurve.txt](https://github.com/KaMuench/neuronales-netz/blob/master/src/main/resources/data_kurve.txt)  

<img src="https://github.com/KaMuench/neuronales-netz/assets/104307796/2f240245-d6a0-4662-a31d-d70fc6678931" alt="sudoku image" width="300"/></img>    
[data_kreis.txt](https://github.com/KaMuench/neuronales-netz/blob/master/src/main/resources/data_kreis.txt)





