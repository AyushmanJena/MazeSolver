// TO BE FIXED

public class Visualizer {
    public void createArray(MazeData[][] maze){
        int z = (maze.length*2) + 1;
        int y = (maze[0].length*2) + 1;
        boolean[][] drawArray = new boolean[z][y];

        for(int row = 0; row<z; row++){
            for(int col = 0; col<y; col++){
                drawArray[row][col] = false;
            }
        }

        int i = 0, j = 0, k = 0;
        for(int r = 0; r< drawArray.length-1; r++){
            if(r > 0 && r%2==0 ){
                i++;
            }
            for(int c = 0; c < drawArray[r].length - 1; c++){
                if((r + c)%2 == 0){ // r + c is even
                    if(r == 0 || c == 0){
                        continue;
                    }
                    if(r%2 != 0){
                        drawArray[r][c] = true; // empty space for cell center
                    }
                    else{
                        drawArray[r][c] = false; // line for in between two rows
                    }
                }
                else if(r%2 == 0){ // r is even , c is odd
                    k = 1;
                    // System.out.println(r +" " + c +" > " + i+" " + j+" " + k); // for debugging
                    drawArray[r][c] = maze[i][j].charAt(k);
                    j++;
                }
                else{ // r is odd , c is even
                    k = 0;
                    // System.out.println(r +" "+ c +" > " + i+" " + j+" " + k); // for debugging
                    drawArray[r][c] = maze[i][j].charAt(k);
                    j++;
                }
            }
            j++;
        }
        //drawMaze(drawArray);
    }
}
