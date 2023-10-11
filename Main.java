// Taking maze input as Strings array

public class Main {
    public static void main(String[] args) {
        //int[][] maze = new int[3][3];
        String[][] maze = {
                {"0001", "0011", "1001"},
                {"0101", "0101", "0101"},
                {"0110", "1100", "0100"}};
        String[][] maze2 = {
                {"0010", "1010", "1001"},
                {"0011", "1010", "1100"},
                {"0110", "1010", "1000"}};
        String[][] maze3 = {
                {"0001", "0000", "0011", "1001"},
                {"0110", "1001", "0101", "0101"},
                {"0000", "0101", "0101", "0101"},
                {"0000", "0110", "1100", "0100"}
        };

        MazeVisualizer obj = new MazeVisualizer();
        obj.createArray(maze3);
        solve(maze3);
    }

    static void solve(String[][] maze) {
        int[] pos = {0,0};
        char lastMove = 'x';
        int len = maze.length - 1;
        while(true){

            if(isDeadEnd(maze, pos, lastMove)){
                System.out.println("---DEAD END---");
            }

            if(pos[0] == len && pos[1] == len)
                return;

            lastMove = move(maze, pos, lastMove);

            System.out.println("("+pos[0]+","+pos[1]+")");
        }
    }
    public static char move(String[][] maze, int[] pos, char lastMove){
        String curr = maze[pos[0]][pos[1]];
        if(curr.charAt(3) == '1' && lastMove != 'u'){
            pos[0]++; // move down
            lastMove = 'd';
        }
        else if(curr.charAt(2) == '1' && lastMove != 'l'){
            pos[1]++; // move right
            lastMove = 'r';
        }
        else if(curr.charAt(1) == '1' && lastMove != 'd'){
            pos[0]--; // move up
            lastMove = 'u';
        }
        else if(curr.charAt(0) == '1' && lastMove != 'r'){
            pos[1]--; // move left
            lastMove = 'l';
        }
        return lastMove;
    }
    public static boolean isDeadEnd(String[][] maze,int[] pos, char lastMove){
        String curr = maze[pos[0]][pos[1]]; // original
        //String curr = maze[2][0]; //for testing purpose
        //lastMove = 'd'; // testing
        boolean deadEnd = false;

        for(int i = 0; i<4; i++){
            if(lastMove == 'd'){
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
            }
            if(lastMove == 'l'){
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
            }
            if(lastMove == 'r'){
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
            }
            if(lastMove == 'u'){
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

/*
DESIRED OUTPUT :
        (1,0)
        (2,0)
        (2,1)
        (1,1)
        (0,1)
        (0,2)
        (1,2)
        (2,2)
        Dead End Reached
*/