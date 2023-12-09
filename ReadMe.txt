Introduction :
==============================================
A simple maze runner build from scratch using Java. This code is supposed to evolve over time with more functionalities, solving algorithms and possibilities getting added with every commit.

For now it is a simple maze solver.

[Needs to be updated after successfully implementing the object concept for easier algorithms]

Q > How it takes maze data ?
A > The code takes a 2D string array named 'maze' in the main() which consists of 0s and 1s.
Every string represents a cell and its walls.
Every 1 signifies a no wall and 0 signifies a wall in the format Left, Top, Right, Bottom.
For Example : 
"0011" tells us that the cell has wall on left and top while it is open in right and bottom.

However I am looking forward to make it easier to take data input from another text file instead of how it is done now.

Q > Why String Array instead of Integer or Boolean ? 
A > It is easier to get to a particular character of a string array with the charAt().

NotMain() :
=============================================
Solve(String[][] maze) :
For now this method moves in any direction it finds the way. It works well with single way mazes and not so well when there are multiple choices.
*Looking forward to fix this in next phase.

Untill we reach the last/end cell the pointer moves through the while loop 

it calls move(maze, pos, lastMove) with every iteration which checks if there is a open wall then the pointer moves in that direction, with pos saving the coordinates of the current position.

Using the variable lastMove it tracks the last move it did and makes sure for the next iteration it does not go back in the same path.

Then the method prints the cell to which pointer moves.


isDeadEnd(maze, pos, lastMove) :
After taking into consideration the lastMove this method checks if there are any other ways the pointer can move to. If non then returns True.


numberOfChoices(maze, pos) :
this method returns the number of possible ways available for the pointer to move including the direction it came from (not taking lastMove into consideration)





MazeVisualizer :
==============================================
createArray(maze) :
This method takes the maze data as argument and returns another array 'drawArray' that will make it easir to draw the visualization of the array.
It stores each point of a maze like the walls, corners and empty spaces as a array format which is easier to draw from.
It stores the maze in a larger array.
a 3x3 maze is stored in 7x7  array.

Considering the patterns and repetations the walls make with each other it makes it simpler to visualize the maze.
For example :{
if r + c is even then it is an empty space
	if r is odd then it is cell center
	if r is odd then it signifies the wall between two rows.

if r is even and c is odd 
	then it stores data from maze[i][j].charAt(k) while k is 1 and incrementing j by 1;
if r is odd and c is even 
	then it stores data from maze[i][j].charAt(k) while k is 0 and incrementing j by 1;

value of i changes with every 2 rows
0,1 > 0
2,3 > 1
4,5 > 2
}
in the end it calls drawMaze(drawArray) to print the visualized maze into console.

drawMaze(drawArray) :
it prints empty space for every 1 
and desired character (here '|' ) for every 0
'|' character is best suited as it minimizes the vertical space between lines and makes it less confusing.
