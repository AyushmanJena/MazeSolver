class MazeData {
    boolean left;
    boolean top;
    boolean right;
    boolean bottom;

    boolean isDeadEnd;
    //boolean isCheckPoint;
}
public class Main{
    public static void main(String[] args) {

        String[][] mazeStr = { // Simple one way
                {"0001", "0011", "1001"},
                {"0101", "0101", "0101"},
                {"0110", "1100", "0100"}};

        Util obj = new Util();
        Solver sol = new Solver();
        Visualizer draw = new Visualizer();

        MazeData[][] maze = obj.convert(mazeStr);
        int[] start = {0,0};
        int[] end = {2,2};
        draw.createArray(maze);
        sol.solve(maze,start, end);

        //obj.display(maze);
    }
}
