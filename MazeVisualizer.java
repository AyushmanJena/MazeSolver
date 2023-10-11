public class MazeVisualizer {

    public void createArray(String[][] maze){

        int z = (maze.length*2) + 1;
        int y = (maze[0].length*2) + 1;
        char[][] drawArray = new char[z][z];

        for(int row = 0; row < z; row++){
            for(int col = 0 ; col < y; col++){
                drawArray[row][col] = '0';
            }
        }

        int i = 0,j = 0, k = 0;
        for(int r = 0; r < drawArray.length - 1 ; r++){
            if(r > 0 && r%2==0 ){
                i++;
            }
            for(int c = 0; c < drawArray[r].length - 1; c++){
                if((r + c)%2 == 0){ // r + c is even
                    if(r == 0 || c == 0){
                        continue;
                    }
                    if(r%2 != 0){
                        drawArray[r][c] = '1'; // empty space for cell center
                    }
                    else{
                        drawArray[r][c] = '0'; // line for in between two rows
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
            j = 0;
        }

        drawMaze(drawArray);
    }

    public void drawMaze(char[][] arr){
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){

                if(arr[i][j] == '1'){
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