// TO BE FIXED

public class Visualizer {

    public void createArray(MazeData[][] maze){
        int z = (maze.length*2) + 1;
        int y = (maze[0].length*2) + 1;
        boolean[][] drawArray = new boolean[z][y];

        for(int row = 0; row<z; row++){ //not really necessary but for error searching purpose
            for(int col = 0; col<y; col++){
                drawArray[row][col] = false;
            }
        }

        int i = 0, j =0; // variables for original data table if not array
        for(int r = 0; r<drawArray.length; r++){
            if(r %2 == 0){
                continue;
            }
            j = 0;
            //else if r is odd
            for(int c = 0; c<drawArray[r].length; c++){
                if((r+c)%2 != 0){ // if r+c is odd continue;
                    continue;
                }
                else{ // if r+c is even do check sides and stuff

                    MazeData cell = maze[i][j]; // this is a cell
                    drawArray[r][c] = true;
                    if(cell.left == true){
                        drawArray[r][c-1] = true;
                    }
                    if(cell.top == true){
                        drawArray[r-1][c] = true;
                    }
                    if(cell.right == true){
                        drawArray[r][c+1] = true;
                    }
                    if(cell.bottom == true){
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
}
