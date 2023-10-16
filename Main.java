// Taking maze input as Strings array

public class Main {
    public static void main(String[] args) {
        //int[][] maze = new int[3][3];
        String[][] maze = { // Simple one way
                {"0001", "0011", "1001"},
                {"0101", "0101", "0101"},
                {"0110", "1100", "0100"}};
        String[][] maze2 = { //simple one way
                {"0010", "1010", "1001"},
                {"0011", "1010", "1100"},
                {"0110", "1010", "1000"}};
        String[][] maze3 = { // 3x3 with a two-way
                {"0010", "1001", "0001"},
                {"0011", "1110", "1100"},
                {"0110", "1010", "1000"}};
        String[][] maze4 = { // 4x4 maze
                {"0001", "0000", "0011", "1001"},
                {"0110", "1001", "0101", "0101"},
                {"0000", "0101", "0101", "0101"},
                {"0000", "0110", "1100", "0100"}};
        String[][] maze5 = { // 4x4 maze with a two-way
                {"0010", "1001", "0000", "0001"},
                {"0000", "0111", "1010", "1100"},
                {"0000", "0110", "1010", "1001"},
                {"0000", "0000", "0000", "0100"}};
        String[][] maze6 = { //
                {"0010", "1001", "0010", "1001"},
                {"0000", "0111", "1010", "1100"},
                {"0000", "0110", "1010", "1001"},
                {"0000", "0010", "1000", "0100"}};
        String[][] maze7 = { //
                {"0010", "1001", "0010", "1001"},
                {"0010", "1111", "1010", "1100"},
                {"0001", "0111", "1010", "1001"},
                {"0100", "0110", "1000", "0100"}};

        MazeVisualizer obj = new MazeVisualizer();
        obj.createArray(maze7);
        solve(maze7);
    }

    static void solve(String[][] maze){
        int[] pos = {0,0};
        char lastMove = 'x';
        int[] lastCheckPoint = {0,0};
        solveRecursive(maze, pos, lastMove);
        if (endVar == 1){
            System.out.println("End Reached :)");
        }
    }


    static char tempLastMove;
    static int endVar = 0;
    static void solveRecursive(String[][] maze, int[] pos,char lastMove) {
        if(reachedEnd(maze, pos) ){
            endVar = 1;
            return;
        }
        if (isDeadEnd(maze, pos, lastMove)) {
            System.out.println("DeadEnd");
            return;
        }
        if (numberOfChoices(maze, pos) > 2) {
            tempLastMove = lastMove;
            //for(int i = 0; i< numberOfChoices(maze, pos); i++) {
            while(!reachedEnd(maze, pos)){
                tempLastMove = move(maze, pos, lastMove);
                solveRecursive(maze, pos, move(maze, pos, tempLastMove));
            }
        }
        else{
            lastMove = move(maze, pos, lastMove);
        }
        solveRecursive(maze, pos, lastMove);
    }

    static boolean reachedEnd(String[][] maze,int[] pos){
        if(pos[0] == maze.length -1 && pos[1] == maze.length -1){
            return true;
        }
        return false;
    }




    public static char move(String[][] maze, int[] pos, char lastMove){
        String curr = maze[pos[0]][pos[1]];
        if(isDeadEnd(maze, pos, lastMove)){
            switch(lastMove){
                case'l':
                    pos[1]++;
                    lastMove = 'r';
                    break;
                case 'u' :
                    pos[0]++;
                    lastMove = 'd';
                    break;
                case 'r':
                    pos[1]--;
                    lastMove = 'l';
                    break;
                case 'd':
                    pos[0]--;
                    lastMove = 'u';
            }
        }
        else{
            if(curr.charAt(2) == '1' && lastMove != 'l'){
                pos[1]++; // move right
                lastMove = 'r';
            }
            else if(curr.charAt(3) == '1' && lastMove != 'u'){
                pos[0]++; // move down
                lastMove = 'd';
            }
            else if(curr.charAt(0) == '1' && lastMove != 'r'){
                pos[1]--; // move left
                lastMove = 'l';
            }
            else if(curr.charAt(1) == '1' && lastMove != 'd'){
                pos[0]--; // move up
                lastMove = 'u';
            }
        }
        System.out.println("(" + pos[0] + "," + pos[1] + ")");
        return lastMove;
    }
    public static boolean isDeadEnd(String[][] maze,int[] pos, char lastMove){
        String curr = maze[pos[0]][pos[1]]; // original
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

