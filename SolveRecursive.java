public class SolveRecursive {
    void solve(MazeData[][] maze, int[] start, int[] end){
        int r = start[0];
        int c = start[1];

        char lastMove = 'x';

        boolean[][] tempMaze = new boolean[maze.length][maze[0].length];

        solveUtil(maze, tempMaze, r, c, end, lastMove);
    }

    static char solveUtil(MazeData[][] maze, boolean[][] tempMaze, int r, int c, int[] end, char lastMove){
        if(r == end[0] && c == end[1]){
            System.out.println("("+r+","+c+")");
            System.out.println("END REACHED !!!");
            return 'y';
        }
        if(tempMaze[r][c]){
            return lastMove;
        }
        else if(isDeadEnd(maze,r, c, lastMove)){
            System.out.println("("+r+","+c+")");
            System.out.println("DEADEND REACHED");
            switch(lastMove){
                case'L':
                    return 'R';
                case 'U':
                    return 'D';
                case 'R':
                    return 'L';
                case 'D':
                    return 'U';
            }
        }
        tempMaze[r][c] = true;

        if(maze[r][c].right && lastMove != 'L'){
            System.out.println("("+r+","+c+")");
            lastMove = solveUtil(maze, tempMaze, r, c+1, end, 'R');
            if (lastMove == 'y') return 'y';
        }
        if(maze[r][c].bottom && lastMove != 'U'){
            System.out.println("("+r+","+c+")");
            lastMove = solveUtil(maze, tempMaze, r+1, c, end, 'D');
            if (lastMove == 'y') return 'y';
        }
        if(maze[r][c].left && lastMove != 'R'){
            System.out.println("("+r+","+c+")");
            lastMove = solveUtil(maze, tempMaze, r, c-1, end, 'L');
            if (lastMove == 'y') return 'y';
        }
        if(maze[r][c].top && lastMove != 'D'){
            System.out.println("("+r+","+c+")");
            lastMove = solveUtil(maze, tempMaze, r-1, c, end, 'U');
            if (lastMove == 'y') return 'y';
        }
        tempMaze[r][c] = false;
        return lastMove;
    }

    static boolean isDeadEnd(MazeData[][] maze, int r, int c, char lastMove){
        MazeData cell = maze[r][c];
        //boolean deadEnd = false;

        switch(lastMove){
            case 'd':
                if(!cell.right && !cell.bottom && !cell.left){
                    return true;
                }
            case 'l':
                if(!cell.left && !cell.bottom && !cell.top){
                    return true;
                }
            case 'r':
                if(!cell.right && !cell.bottom && !cell.top){
                    return true;
                }
            case 'u':
                if(!cell.left && !cell.right && !cell.top){
                    return true;
                }
        }
        return false;
    }


    // NOT WORKING
    /*static void solveUtil2(MazeData[][] maze, boolean[][] tempMaze, int r, int c, int[] end){
        if(r == end[0] && c == end[1]){
            System.out.println("End found");
            return;
        }
        if(maze[r][c].isDeadEnd){
            return;
        }

        tempMaze[r][c] = false;

        if(r < maze.length - 1 && maze[r][c].bottom){
            System.out.println("("+r+","+c+")");
            solveUtil(maze,tempMaze, r+1, c, end);
        }
        if(c < maze.length - 1 && maze[r][c].right){
            System.out.println("("+r+","+c+")");
            solveUtil(maze,tempMaze, r, c+1, end);
        }
        if(r > 0 && maze[r][c].top){
            System.out.println("("+r+","+c+")");
            solveUtil(maze,tempMaze, r-1, c, end);
        }
        if(r > 0  && maze[r][c].left){
            System.out.println("("+r+","+c+")");
            solveUtil(maze,tempMaze, r, c-1, end);
        }

        tempMaze[r][c] = true;
    }*/
}
