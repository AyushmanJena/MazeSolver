public class SolveTermaux {
    void solve(MazeData[][] maze, int[] start, int[] end){
        int r = start[0];
        int c =  start[1];
        solveUtil(maze, r, c, end);
    }

    static void solveUtil(MazeData[][] maze, int r, int c, int[] end){
        if(r == end[0] && c == end[1]){
            System.out.println("END REACHED !!!");
            return;
        }
        if(maze[r][c].isDeadEnd){
            return;
        }

        if(maze[r][c].right){
            solveUtil(maze, r, c+1, end);
        }
        if(maze[r][c].bottom){
            solveUtil(maze, r+1, c, end);
        }
        if(maze[r][c].left){
            solveUtil(maze, r, c-1, end);
        }
        if(maze[r][c].top){
            solveUtil(maze, r-1, c, end);
        }
    }
    static boolean isDeadEnd(MazeData[][] maze, int[] pos, char lastMove){
        MazeData cell = maze[pos[0]][pos[1]];
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
}
