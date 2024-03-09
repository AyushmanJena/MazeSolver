Introduction :
==============================================
A simple maze runner build from scratch using Java.
This code is supposed to evolve over time with more functionalities, solving algorithms and possibilities getting added with every commit.

Main:
=============================================
Consists of Maze class which has a Cell internal Class, mazeData , start and end positions and solution.
This class is the heart of the program and all the necessary data is being initialized to the member variables of this class.
Also consists of Main class which holds the driver code for the whole MazeSolver program.


Solver :
=============================================
Has code for a recursive approach for solving the maze Problem.
Stores the solution in ArrayList of integer array named 'path' which eventually is stored in the Maze class as 'solution' of same type.


PathVisualizer :
==============================================
Uses Java Swing library for a visual representation of the maze and the path followed to get to the end point of the maze.


Util :
==============================================
Consists of few not so important utility methods which are used for general debugging processes like:
displayMaze() : displaying the maze in the console
displayPath() : display the path followed in the maze
display() : exclusively for debugging to check if the data is being properly initialized or not.