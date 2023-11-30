public class Solver {
    public void solve(MazeData[][] maze, int[] start, int[] end){
        int[] pos = {start[0], start[1]};
        System.out.println("(" + pos[0] + "," + pos[1] + ")");
        char lastMove = 'x';
        while(!reachedEnd(maze,pos, end)){
            lastMove = move(maze, pos, lastMove);
        }
        if(reachedEnd(maze,pos,end)){
            System.out.println("===END REACHED===");
        }
        else{
            System.out.println("COULDN'T FIND END");
        }
    }

    public char move(MazeData[][] maze, int[] pos, char lastMove){
        MazeData cell = new MazeData();
        cell = maze[pos[0]][pos[1]];
        if(isDeadEnd(maze,pos,lastMove)){
            System.out.println("DEADEND REACHED");
            switch(lastMove){
                case'l':
                    lastMove = moveDirection(pos, 'r');
                    break;
                case 'u':
                    lastMove = moveDirection(pos, 'd');
                    break;
                case 'r':
                    lastMove = moveDirection(pos, 'l');
                    break;
                case 'd':
                    lastMove = moveDirection(pos, 'u');
                    break;
            }
        }
        else if(isCheckPoint(maze,pos)){
            switch (lastMove){
                case 'u':
                    lastMove = moveDecide(maze,pos, lastMove, 0);
                    break;
                case 'r':
                    lastMove = moveDecide(maze, pos,lastMove, 1);
                    break;
                case 'd' :
                    lastMove = moveDecide(maze,pos, lastMove, 2);
                    break;
                case 'l':
                    lastMove = moveDecide(maze,pos, lastMove, 3);
                    break;
            }
        }
        else{
            if(cell.right == true && lastMove != 'l'){
                lastMove = moveDirection(pos, 'r');
            }
            else if(cell.bottom == true && lastMove != 'u'){
                lastMove = moveDirection(pos, 'd');
            }
            else if(cell.left == true && lastMove != 'r'){
                lastMove = moveDirection(pos, 'l');
            }
            else if(cell.top == true && lastMove != 'd'){
                lastMove = moveDirection(pos, 'u');
            }
        }
        return lastMove;
    }

    public char moveDecide(MazeData[][] maze,int[] pos,char lastMove, int n){
        int i = n;
        MazeData cell = maze[pos[0]][pos[1]];
        while(i<3){
            if(cell.left == true && i == 0){
                return moveDirection(pos, 'l');
            }
            if(cell.top == true && i == 1)
                return moveDirection(pos, 'u');
            if (cell.right == true && i == 2)
                return moveDirection(pos, 'r');
            if(cell.bottom == true && i == 3)
                return moveDirection(pos, 'd');
        }
        i++;
        if(i == 4){
            i = 0;
        }
        return lastMove;
    }

    public char moveDirection(int[] pos, char dir){
        switch (dir){
            case 'r':
                pos[1]++;
                System.out.println("(" + pos[0] + "," + pos[1] + ")");
                return 'r'; //lastMove
            case 'd':
                pos[0]++;
                System.out.println("(" + pos[0] + "," + pos[1] + ")");
                return 'd';
            case 'l':
                pos[1]--;
                System.out.println("(" + pos[0] + "," + pos[1] + ")");
                return 'l';
            case 'u':
                pos[0]--;
                System.out.println("(" + pos[0] + "," + pos[1] + ")");
                return 'u';
            default:
                return 'x';
        }
    }

    public boolean reachedEnd(MazeData[][] maze, int[] pos, int[] end){
        if(pos[0] == end[0] && pos[1] == end[1]){
            return true;
        }
        return false;
    }

    public static boolean isDeadEnd(MazeData[][] maze, int[] pos, char lastMove){
        MazeData cell = maze[pos[0]][pos[1]];
        //boolean deadEnd = false;

        switch(lastMove){
            case 'd':
                if(!cell.right && !cell.bottom && !cell.left){
                    return true;
                }
            case 'l':
                if(!cell.right && !cell.bottom && !cell.top){
                    return true;
                }
            case 'r':
                if(!cell.left && !cell.bottom && !cell.top){
                    return true;
                }
            case 'u':
                if(!cell.left && !cell.bottom && !cell.top){
                    return true;
                }
        }
        return false;
    }

    public boolean isCheckPoint(MazeData[][] maze, int[] pos){
        MazeData cell = maze[pos[0]][pos[1]];
        int count = 0;

        if(cell.left)
            count++;
        if(cell.top)
            count++;
        if(cell.right)
            count++;
        if(cell.bottom)
            count++;

        if(count > 2){
            return true; // is a checkpoint
        }

        return false;
    }
}
