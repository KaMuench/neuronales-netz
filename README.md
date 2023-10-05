# neuronales-netz (IntellijIDEA Project)

![Neuronales Netz 2023-10-05 10-35-41](https://github.com/KaMuench/neuronales-netz/assets/104307796/2f240245-d6a0-4662-a31d-d70fc6678931)  

Thist was a project for the AI module at my university.  

The main goal was to build a net of perceptrons. This network can have multiple layers with 2 layers at least. Each layer takes input values processes them and passes them on to the succeeding layer, until the last layer is reached. In the last layer the 
resulting values are varified against the so called class value. After this verification each parameters of every perecptron is adjusted using a calculated delta. This process is called [Backpropagation](https://de.wikipedia.org/wiki/Backpropagation).  

This whole process is repeated, with the goal to reduce the delta of the final layer until the predictions of the neural network are as close as possible to the actual class values.

More detailed information to the functionality of neural networks [here](https://databasecamp.de/ki/backpropagation-grundlagen#:~:text=Backpropagation%20ist%20eine%20Art%20%C3%BCberwachter,Reinforcement%20Learning%20verwendet%20werden%20k%C3%B6nnen.)  


## Test Data
The data for the testing are these foure files:
- [data_ecken.txt](https://github.com/KaMuench/neuronales-netz/blob/master/src/main/resources/data_ecken.txt)
- [data_gerade.txt](https://github.com/KaMuench/neuronales-netz/blob/master/src/main/resources/data_gerade.txt)
- [data_kreis.txt](https://github.com/KaMuench/neuronales-netz/blob/master/src/main/resources/data_kreis.txt)
- [data_kurve.txt](https://github.com/KaMuench/neuronales-netz/blob/master/src/main/resources/data_kurve.txt)

Each data file contains several coordinates and a class value for each of this coordinates. There are two types of classes, 0 and 1. So each coordinate is matched with either a zero or a one.  
When starting the program the neural network is feed with this coordinates. Then the neural network is trained to predict the right class for the input coordinates. 

## Review of process state
To follow the training there is a simple GUI window. There the coordinates of the test data are displayed coloured according to there class value. (0=blue, red=1)

The background is divided into 100 * 100 coordinate points. Every cycle the neural network is feed with all these background coordinates to predict a class. The background coordinates are then coloured according to the outcome, either light blue or orange.  
The better the network can predict the right class, the more the background color around the data coordinates matches the color of these data points.  

As seen belowe the background color changes over time until it matche the data coordinates.
![Neuronales Netz 2023-10-05 09-25-44 - Trim](https://github.com/KaMuench/neuronales-netz/assets/104307796/444d7e47-60f9-4169-9bb8-0d830206f029)  
[data_kurve.txt](https://github.com/KaMuench/neuronales-netz/blob/master/src/main/resources/data_kurve.txt)  

![Neuronales Netz 2023-10-05 10-35-41](https://github.com/KaMuench/neuronales-netz/assets/104307796/2f240245-d6a0-4662-a31d-d70fc6678931)  
[data_kreis.txt](https://github.com/KaMuench/neuronales-netz/blob/master/src/main/resources/data_kreis.txt)





