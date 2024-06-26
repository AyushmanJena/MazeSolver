import java.util.ArrayList;

class Point{
    int row;
    int col;
    Point(){}
    Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Solver{

    static ArrayList<Point> path = new ArrayList<>();

    static void solve(Maze maze){
        Maze.Cell[][] data = maze.mazeData;
        Point start = new Point(maze.start.row, maze.start.col);

        char lastMove = 'x';
        boolean[][] tempMaze = new boolean[data.length][data[0].length];

        ArrayList<Point> list = new ArrayList<>();
        solveUtil(maze, list, tempMaze, start.row, start.col, lastMove);
        maze.solution = path;
    }

    static void setPath(ArrayList<Point> ans){
        for(Point point : ans){
            int r = point.row;
            int c = point.col;
            path.add(new Point(r,c));
        }
    }

    static char solveUtil(Maze maze, ArrayList<Point> ans, boolean[][] tempMaze, int r, int c, char lastMove){
        if(r == maze.end.row && c == maze.end.col){
            ans.add(new Point(r, c));
            setPath(ans);
            Util.displayPath(path);
            System.out.println("END REACHED !!!");
            return 'y';
        }
        if(tempMaze[r][c]){
            return lastMove;
        }
        tempMaze[r][c] = true;

        if(maze.mazeData[r][c].right && lastMove != 'L'){
            ans.add(new Point(r,c));
            lastMove = solveUtil(maze, ans, tempMaze, r, c+1, 'R'); // Updated lastMove here
            ans.remove(ans.size() -1);
            if(lastMove == 'y') return 'y';
        }
        if(maze.mazeData[r][c].bottom && lastMove != 'U'){
            ans.add(new Point(r,c));
            lastMove = solveUtil(maze, ans, tempMaze, r+1, c, 'D'); // Updated lastMove here
            ans.remove(ans.size()-1);
            if (lastMove == 'y') return 'y';
        }
        if(maze.mazeData[r][c].left && lastMove != 'R'){
            ans.add(new Point(r,c));
            lastMove = solveUtil(maze, ans, tempMaze, r, c-1, 'L'); // Updated lastMove here
            ans.remove(ans.size()-1);
            if (lastMove == 'y') return 'y';
        }
        if(maze.mazeData[r][c].top && lastMove != 'D'){
            ans.add(new Point(r,c));
            lastMove = solveUtil(maze, ans, tempMaze, r-1, c, 'U'); // Updated lastMove here
            ans.remove(ans.size()-1);
            if (lastMove == 'y') return 'y';
        }
        tempMaze[r][c] = false;
        return lastMove;
    }
}


































//public class Solver {
//    static ArrayList<int[]> path = new ArrayList<>();
//    static void solve(Maze maze){
//        Maze.Cell[][] data = maze.mazeData;
//        int[] start = maze.start;
//        int r = start[0];
//        int c = start[1];
//
//        char lastMove = 'x';
//        boolean[][] tempMaze = new boolean[data.length][data[0].length];
//
//        ArrayList<String> list = new ArrayList<>();
//        solveUtil(maze, list, tempMaze, r, c, lastMove);
//        maze.solution = path;
//    }
//
//    static void setPath(ArrayList<String> ans){
//        for(String item : ans){
//            int r = Integer.parseInt(item.substring(0,1));
//            int c = Integer.parseInt(item.substring(1));
//            int[] arr = {r, c};
//            path.add(arr);
//        }
//    }
//
//    static char solveUtil(Maze maze, ArrayList<String> ans, boolean[][] tempMaze, int r, int c, char lastMove){
//        if(r == maze.end[0] && c == maze.end[1]){
//            ans.add(r+""+c);
//            setPath(ans);
//            Util.displayPath(path);
//            System.out.println("END REACHED !!!");
//            return 'y';
//        }
//        if(tempMaze[r][c]){
//            return lastMove;
//        }
//        tempMaze[r][c] = true;
//
//        if(maze.mazeData[r][c].right && lastMove != 'L'){
//            ans.add(r+""+c);
//            lastMove = solveUtil(maze, ans, tempMaze, r, c+1, 'R'); // Updated lastMove here
//            ans.remove(ans.size() -1);
//            if(lastMove == 'y') return 'y';
//        }
//        if(maze.mazeData[r][c].bottom && lastMove != 'U'){
//            ans.add(r+""+c);
//            lastMove = solveUtil(maze, ans, tempMaze, r+1, c, 'D'); // Updated lastMove here
//            ans.remove(ans.size()-1);
//            if (lastMove == 'y') return 'y';
//        }
//        if(maze.mazeData[r][c].left && lastMove != 'R'){
//            ans.add(r+""+c);
//            lastMove = solveUtil(maze, ans, tempMaze, r, c-1, 'L'); // Updated lastMove here
//            ans.remove(ans.size()-1);
//            if (lastMove == 'y') return 'y';
//        }
//        if(maze.mazeData[r][c].top && lastMove != 'D'){
//            ans.add(r+""+c);
//            lastMove = solveUtil(maze, ans, tempMaze, r-1, c, 'U'); // Updated lastMove here
//            ans.remove(ans.size()-1);
//            if (lastMove == 'y') return 'y';
//        }
//        tempMaze[r][c] = false;
//        return lastMove;
//    }
//
//}
