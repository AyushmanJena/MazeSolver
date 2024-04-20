import java.util.ArrayList;

public class Util {
    static void displayMaze(Maze maze){ // a console representation of the maze
        int x = (maze.mazeData.length*2) +1;
        int y = (maze.mazeData.length*2) +1;
        boolean[][] drawArray = new boolean[x][y];

        int i = 0, j = 0;
        for(int r = 0; r < drawArray.length; r++){
            if(r%2 == 0){
                continue;
            }
            j = 0;
            // else if r is odd
            for(int c = 0; c < drawArray[r].length; c++){
                if((r+c)%2 != 0){ // if r+c is odd continue;
                    continue;
                }
                else{
                    Maze.Cell cell = maze.mazeData[i][j];
                    drawArray[r][c] = true;
                    if(cell.left){
                        drawArray[r][c-1] = true;
                    }
                    if(cell.top){
                        drawArray[r-1][c] = true;
                    }
                    if(cell.right){
                        drawArray[r][c+1] = true;
                    }
                    if(cell.bottom){
                        drawArray[r+1][c] = true;
                    }
                }
                j++;
            }
            i++;
        }
        for(i = 0; i<drawArray.length; i++){
            for(j = 0; j<drawArray[i].length; j++){
                if(drawArray[i][j]){
                    System.out.print(" ");
                }
                else{
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    static void displayPath(ArrayList<Point> path){
        for(Point point : path){
            System.out.println("(" + point.row + ", " + point.col + ")");
        }
    }

    static void display(Maze maze){ // exclusively to check if data is stored or not
        for(int i = 0; i< maze.mazeData.length; i++){
            for(int j = 0; j<maze.mazeData[0].length; j++){
                System.out.print(maze.mazeData[i][j].left+","+maze.mazeData[i][j].top+","+maze.mazeData[i][j].right+","+maze.mazeData[i][j].bottom+"\n");
            }
        }
    }
}
