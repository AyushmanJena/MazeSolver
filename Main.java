public class Main {
    public static void main(String[] args) {

        String[][] maze2 = { //8x8 maze
                {"0010", "1010", "1001", "0011", "1010", "1000", "0011", "1001"},
                {"0011", "1001", "0101", "0101", "0010", "1010", "1100", "0101"},
                {"0101", "0100", "0101", "0111", "1010", "1001", "0010", "1101"},
                {"0111", "1010", "1101", "0101", "0001", "0110", "1010", "1101"},
                {"0101", "0010", "1100", "0101", "0110", "1011", "1010", "1100"},
                {"0111", "1011", "1010", "1101", "0011", "1110", "1010", "1001"},
                {"0101", "0100", "0001", "0101", "0101", "0010", "1001", "0101"},
                {"0110", "1010", "1100", "0100", "0110", "1010", "1100", "0100"}
        };
        String[][] maze = { // 4x4 maze with T junction error
                {"0001", "0000", "0011", "1001"},
                {"0101", "0000", "0101", "0101"},
                {"0111", "1010", "1101", "0101"},
                {"0110", "1000", "0100", "0100"}};

        int[] end = {3,1};
        int[] start = {0, 3};

        MazeVisualizer obj = new MazeVisualizer();
        obj.createArray(maze);
        solve(maze, start, end);
    }

    static void solve(String[][] maze, int[] start, int[] end){
        int[] pos = {start[0],start[1]};
        System.out.println("(" + pos[0] + "," + pos[1] + ")");
        char lastMove = 'x';
        while(!reachedEnd(maze,pos,end)){
            lastMove = move(maze,pos, lastMove);
        }
        if(reachedEnd(maze, pos, end)){
            System.out.println("End Reached");
        }
        else{
            System.out.println("Couldn't find End");
        }
    }

    public static char move(String[][] maze, int[] pos, char lastMove){
        String curr = maze[pos[0]][pos[1]];
        if(isDeadEnd(maze, pos, lastMove)){
            System.out.println("DeadEnd Reached !!!");
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
        else if(numberOfChoices(maze,pos) > 2){
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
            if(curr.charAt(2) == '1' && lastMove != 'l'){
                lastMove =  moveDirection(pos, 'r');
            }
            else if(curr.charAt(3) == '1' && lastMove != 'u'){
                lastMove = moveDirection(pos, 'd');
            }
            else if(curr.charAt(0) == '1' && lastMove != 'r'){
                lastMove = moveDirection(pos, 'l');
            }
            else if(curr.charAt(1) == '1' && lastMove != 'd'){
                lastMove = moveDirection(pos, 'u');
            }
        }
        return lastMove;
    }

    public static char moveDecide(String[][] maze, int[] pos, char lastMove, int n){
        int i = n;
        String curr = maze[pos[0]][pos[1]];
        while(i <= 3){
            if(curr.charAt(i) == '1'){
                if(i == 0)
                    return moveDirection(pos, 'l');
                if(i == 1)
                    return moveDirection(pos, 'u');
                if (i == 2)
                    return moveDirection(pos, 'r');
                if(i == 3)
                    return moveDirection(pos, 'd');
            }
            i++;
            if(i==4){
                i = 0;
            }
        }
        return lastMove;
    }
    public static char moveDirection(int[] pos, char dir){
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

    static boolean reachedEnd(String[][] maze,int[] pos, int[] end){
        if(pos[0] == end[0] && pos[1] == end[1]){
            return true;
        }
        return false;
    }

    public static boolean isDeadEnd(String[][] maze,int[] pos, char lastMove){
        String curr = maze[pos[0]][pos[1]];
        boolean deadEnd = false;

        for(int i = 0; i<4; i++){
            switch(lastMove){
                case 'd':
                    if(i == 1){
                        continue;
                    }
                    else if(curr.charAt(i) == '0'){
                        deadEnd = true;
                        continue;
                    }
                    else{
                        return false;
                    }
                case 'l':
                    if(i == 2){
                        continue;
                    }
                    else if(curr.charAt(i) == '0'){
                        deadEnd = true;
                        continue;
                    }
                    else{
                        return false;
                    }
                case 'r':
                    if(i == 0){
                        continue;
                    }
                    else if(curr.charAt(i) == '0'){
                        deadEnd = true;
                        continue;
                    }
                    else{
                        return false;
                    }
                case 'u' :
                    if(i == 3){
                        continue;
                    }
                    else if(curr.charAt(i) == '0'){
                        deadEnd = true;
                        continue;
                    }
                    else{
                        return false;
                    }
            }
        }
        return deadEnd;
    }

    public static int numberOfChoices(String[][] maze, int[] pos){
        String curr = maze[pos[0]][pos[1]];
        int openWays = 0;
        for(int i = 0; i<4; i++){
            if(curr.charAt(i) == '1'){
                openWays++;
            }
        }
        return openWays;
    }
}

