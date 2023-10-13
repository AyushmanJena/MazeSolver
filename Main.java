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

        MazeVisualizer obj = new MazeVisualizer();
        obj.createArray(maze3);
        solve(maze3);
    }

    static void solve(String[][] maze) {
        int[] pos = {0,0};
        char lastMove = 'x';
        int len = maze.length - 1;
        while(true){

            if(pos[0] == maze.length -1 && pos[1] == maze.length -1){
                System.out.println("---END FOUND---");
                return;
            }
            else if(isDeadEnd(maze, pos, lastMove)){
                System.out.println("<DEAD END>");
            }

            if(pos[0] == len && pos[1] == len)
                return;

            lastMove = move(maze, pos, lastMove);
        }
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
                case 'r':
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

