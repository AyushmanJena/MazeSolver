import java.util.ArrayList;

public class SolveRecursive {
    void solve(MazeData[][] maze, int[] start, int[] end){
        int r = start[0];
        int c = start[1];

        char lastMove = 'x';

        boolean[][] tempMaze = new boolean[maze.length][maze[0].length];
        
        String s = "";
        ArrayList<String> list = new ArrayList<>();
        solveUtil2(maze, list ,tempMaze,r,c,end,lastMove);
    }

    static char solveUtil(MazeData[][] maze,String ans, boolean[][] tempMaze, int r, int c, int[] end, char lastMove){
        if(r == end[0] && c == end[1]){
            ans = ans + r + c;
            System.out.println(ans);
            System.out.println("END REACHED !!!");
            return 'y';
        }
        if(tempMaze[r][c]){
            return lastMove;
        }
        tempMaze[r][c] = true;

        if(maze[r][c].right && lastMove != 'L'){
            lastMove = solveUtil(maze, ans + r + c + ", ", tempMaze, r, c+1, end, 'R');
            if (lastMove == 'y') return 'y';
        }
        if(maze[r][c].bottom && lastMove != 'U'){
            lastMove = solveUtil(maze,ans + r + c + ", ", tempMaze, r+1, c, end, 'D');
            if (lastMove == 'y') return 'y';
        }
        if(maze[r][c].left && lastMove != 'R'){
            lastMove = solveUtil(maze,ans + r + c + ", ", tempMaze, r, c-1, end, 'L');
            if (lastMove == 'y') return 'y';
        }
        if(maze[r][c].top && lastMove != 'D'){
            lastMove = solveUtil(maze,ans + r + c + ", ", tempMaze, r-1, c, end, 'U');
            if (lastMove == 'y') return 'y';
        }
        tempMaze[r][c] = false;
        return lastMove;
    }

    static char solveUtil2(MazeData[][] maze,ArrayList<String> ans, boolean[][] tempMaze, int r, int c, int[] end, char lastMove){
        if(r == end[0] && c == end[1]){
            ans.add("(" + r +","+ c +")");
            System.out.println(ans);
            System.out.println("END REACHED !!!");
            return 'y';
        }
        if(tempMaze[r][c]){
            return lastMove;
        }
        tempMaze[r][c] = true;

        if(maze[r][c].right && lastMove != 'L'){
            ans.add("(" + r +","+ c +")");
            lastMove = solveUtil2(maze, ans , tempMaze, r, c+1, end, 'R');
            ans.remove(ans.size()-1);
            if (lastMove == 'y') return 'y';
        }
        if(maze[r][c].bottom && lastMove != 'U'){
            ans.add("(" + r +","+ c +")");
            lastMove = solveUtil2(maze,ans, tempMaze, r+1, c, end, 'D');
            ans.remove(ans.size()-1);
            if (lastMove == 'y') return 'y';
        }
        if(maze[r][c].left && lastMove != 'R'){
            ans.add("(" + r +","+ c +")");
            lastMove = solveUtil2(maze,ans, tempMaze, r, c-1, end, 'L');
            ans.remove(ans.size()-1);
            if (lastMove == 'y') return 'y';
        }
        if(maze[r][c].top && lastMove != 'D'){
            ans.add("(" + r +","+ c +")");
            lastMove = solveUtil2(maze,ans, tempMaze, r-1, c, end, 'U');
            ans.remove(ans.size()-1);
            if (lastMove == 'y') return 'y';
        }
        tempMaze[r][c] = false;
        return lastMove;
    }
}
