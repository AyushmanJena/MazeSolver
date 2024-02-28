import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PathVisualizer extends JFrame{
    MazeData[][] mazeData;
    private ArrayList<Point> solutionPath;
    private static final int SQUARE_SIZE = 50;

    static int tempC = 0;
    static int tempR = 0;
    static int startR = 50;
    static int startC = 70;

    PathVisualizer(MazeData[][] mazeData, ArrayList<Point> solutionPath){
        this.mazeData = mazeData;
        this.solutionPath = solutionPath;

        setTitle("Maze Solver");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void paint(Graphics g){
        super.paint(g);
        drawMaze(g);
        drawPath(g);
    }

    void drawMaze(Graphics g){
        int x;
        int y;
        for (int row = 0; row < mazeData.length; row++) {
            for (int col = 0; col < mazeData[0].length; col++) {
                x = col * SQUARE_SIZE + 30;
                y = row * SQUARE_SIZE + 50;

                g.setColor(Color.BLACK);

                drawCell(g, mazeData, row, col, x, y);
            }
        }
    }
    static void drawCell(Graphics g2d, MazeData[][] maze, int row, int col, int x, int y) {
        Graphics2D g2 = (Graphics2D) g2d; // Casting to Graphics2D

        // Create a thicker stroke
        Stroke oldStroke = g2.getStroke(); // Store the old stroke
        float thickness = 3; // Adjust the thickness as needed
        g2.setStroke(new BasicStroke(thickness));

        if (!maze[row][col].top) {
            g2d.drawLine(x, y, x + SQUARE_SIZE, y); // Top line
        }
        if (!maze[row][col].right) {
            g2d.drawLine(x + SQUARE_SIZE, y, x + SQUARE_SIZE, y + SQUARE_SIZE); // Right line
        }
        if (!maze[row][col].bottom) {
            g2d.drawLine(x + SQUARE_SIZE, y + SQUARE_SIZE, x, y + SQUARE_SIZE); // Bottom line
        }
        if (!maze[row][col].left) {
            g2d.drawLine(x, y + SQUARE_SIZE, x, y); // Left line
        }

        // Restore the old stroke
        g2.setStroke(oldStroke);
    }

    void drawPath(Graphics g){
        SolveRecursive sol = new SolveRecursive();
        //System.out.println("hello"); //debugging
        //System.out.println(solutionPath.size());

        for(int i = 0; i< solutionPath.size(); i++) {
            Point point = solutionPath.get(i);
            int r = (int)point.getX();
            int c = (int)point.getY();

            g.setColor(Color.RED);
            g.fillOval(startR, startC,9, 9);

            if(c > tempC){
                startR += 50;
            } else if (c <tempC) {
                startR -= 50;
            }

            if(r > tempR){
                startC += 50;
            }
            if(r < tempR){
                startC -= 50;
            }
            tempR = r;
            tempC = c;

            try {
                Thread.sleep(200); // timer
            } catch (InterruptedException e) {
                return;
            }
        }
        g.fillOval(startR, startC,9, 9);
        //repaint();
    }

    public static void driver(MazeData[][] maze, ArrayList<int[]> ans){
        //SolveRecursive sol = new SolveRecursive();

        ArrayList<Point> solutionPath = new ArrayList<>();
        for(int[] p : ans){
            int x = p[0];
            int y = p[1];
            //System.out.println(x+":"+y); //for debugging
            solutionPath.add(new Point(x, y));
        }

        PathVisualizer draw = new PathVisualizer(maze, solutionPath);
        draw.setVisible(true);
    }

}