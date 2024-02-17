class Util {
    public MazeData[][] convert(String[][] mazeStr){
        MazeData[][] maze = new MazeData[mazeStr.length][mazeStr[0].length];
        for(int i = 0; i< mazeStr.length; i++){ //row of array
            for(int j = 0; j< mazeStr[i].length; j++){ // column of array
                maze[i][j] = new MazeData();
                for(int c = 0; c <4; c++){ // for each string
                    char ch = mazeStr[i][j].charAt(c);
                    switch(c){
                        case 0:
                            if(ch == '1'){
                                maze[i][j].left = true;
                            }
                            break;
                        case 1:
                            if(ch == '1'){
                                maze[i][j].top = true;
                            }
                            break;
                        case 2:
                            if(ch == '1'){
                                maze[i][j].right = true;
                            }
                            break;
                        case 3:
                            if(ch == '1'){
                                maze[i][j].bottom = true;
                            }
                            break;
                    }
                }
                //System.out.print(maze[i][j].left+","+maze[i][j].top+","+maze[i][j].right+","+maze[i][j].bottom+"\n"); // For debugging purposes
            }
        }
        return maze;
    }

    public void display(MazeData[][] maze){
        for(int i = 0; i<maze.length; i++){
            for(int j = 0; j<maze[i].length; j++){
                System.out.print(maze[i][j].left+
                        ","+maze[i][j].top+","+maze[i][j].right+
                        ","+maze[i][j].bottom+"\n");
            }
            System.out.println();
        }
    }
}
