import java.util.ArrayList;
import java.util.Scanner;

class Maze{
    static class Cell{
        boolean left;
        boolean top;
        boolean right;
        boolean bottom;
    }
    Cell[][] mazeData;
    int[] start = {0, 0};
    int[] end = {0,0};
    ArrayList<int[]> solution;

    Maze(){};
    Maze (String[][] mazeStr, int[] start, int[] end){
        mazeData = new Cell[mazeStr.length][mazeStr[0].length];
        for(int i = 0; i< mazeStr.length; i++){ //row of array
            for(int j = 0; j< mazeStr[i].length; j++){ // column of array
                mazeData[i][j] = new Cell();
                for(int c = 0; c <4; c++){ // for each string
                    char ch = mazeStr[i][j].charAt(c);
                    switch(c){
                        case 0:
                            if(ch == '1'){
                                mazeData[i][j].left = true;
                            }
                            break;
                        case 1:
                            if(ch == '1'){
                                mazeData[i][j].top = true;
                            }
                            break;
                        case 2:
                            if(ch == '1'){
                                mazeData[i][j].right = true;
                            }
                            break;
                        case 3:
                            if(ch == '1'){
                                mazeData[i][j].bottom = true;
                            }
                            break;
                    }
                }
                //System.out.print(maze[i][j].left+","+maze[i][j].top+","+maze[i][j].right+","+maze[i][j].bottom+"\n"); // For debugging purposes
            }
        }
        this.start = start;
        this.end = end;
    }
}

public class Main{
    public static void main(String[] args) {
        String[][] mazeStr = { // 5x5 with island
                {"0010", "1010", "1010", "1010", "1001"},
                {"0011", "1011", "1011", "1011", "1101"},
                {"0101", "0110", "1100", "0101", "0101"},
                {"0111", "1010", "1010", "1100", "0101"},
                {"0100", "0010", "1010", "1010", "1100"}};
        int[] start = {0, 0};
        int[] end = {4,4};
        Maze maze = new Maze(mazeStr, start, end);
        Util.displayMaze(maze);
        Solver.solve(maze);
        PathVisualizer.driver(maze, maze.solution);
    }
}

// Some important mazes to try :
/*

{    // Simple one way
                {"0010", "1001", "0001"},
                {"0011", "1110", "1100"},
                {"0110", "1010", "1000"}};


{ // 5x5 with island
        {"0010", "1010", "1010", "1010", "1001"},
        {"0011", "1011", "1011", "1011", "1101"},
        {"0101", "0110", "1100", "0101", "0101"},
        {"0111", "1010", "1010", "1100", "0101"},
        {"0100", "0010", "1010", "1010", "1100"}};

{ //8x8 maze
                {"0010", "1010", "1001", "0011", "1010", "1000", "0011", "1001"},
                {"0011", "1001", "0101", "0101", "0010", "1010", "1100", "0101"},
                {"0101", "0100", "0101", "0111", "1010", "1001", "0010", "1101"},
                {"0111", "1010", "1101", "0101", "0001", "0110", "1010", "1101"},
                {"0101", "0010", "1100", "0101", "0110", "1011", "1010", "1100"},
                {"0111", "1011", "1010", "1100", "0011", "1110", "1010", "1001"},
                {"0101", "0100", "0001", "0001", "0101", "0010", "1001", "0101"},
                {"0110", "1010", "1100", "0100", "0110", "1010", "1100", "0100"}};

 */