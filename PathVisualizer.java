import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class PathVisualizer extends JFrame{
    Maze maze;
    private ArrayList<Point> solutionPath;
    private static final int SQUARE_SIZE = 50;

    static int tempC = 0;
    static int tempR = 0;
    static int startR ; //50 by default
    static int startC ; //70 by default

    static void driver(Maze maze, ArrayList<Point> ans){
        Point startPoint = maze.start;
        startR = 50 + (startPoint.col*50);
        startC = 70 + ((startPoint.row-1)*50);

        ArrayList<Point> solutionPath = new ArrayList<>();
        for(Point p : ans){
            int x = p.row;
            int y = p.col;
            //System.out.println(x+":"+y); //for debugging
            solutionPath.add(new Point(x, y));
        }

        PathVisualizer draw = new PathVisualizer(maze, solutionPath);
        draw.setVisible(true);
    }

    PathVisualizer(Maze maze, ArrayList<Point> solutionPath){
        this.maze = maze;
        this.solutionPath = solutionPath;

        setTitle("Maze Solver");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        ImageIcon logo = new ImageIcon(this.getClass().getClassLoader().getResource("res/icon.png"));

        setIconImage(logo.getImage());
    }

    public void paint(Graphics g){
        super.paint(g);
        drawMaze(g);
        drawPath(g);
    }

    void drawMaze(Graphics g){
        int x;
        int y;
        for (int row = 0; row < maze.mazeData.length; row++) {
            for (int col = 0; col < maze.mazeData[0].length; col++) {
                x = col * SQUARE_SIZE + 30;
                y = row * SQUARE_SIZE + 50;

                g.setColor(Color.BLACK);

                drawCell(g, maze, row, col, x, y);
            }
        }
    }
    static void drawCell(Graphics g2d, Maze maze, int row, int col, int x, int y) {
        Graphics2D g2 = (Graphics2D) g2d; // Casting to Graphics2D

        // Create a thicker stroke
        Stroke oldStroke = g2.getStroke(); // Store the old stroke
        float thickness = 3; // Adjust the thickness as needed
        g2.setStroke(new BasicStroke(thickness));

        if (!maze.mazeData[row][col].top) {
            g2d.drawLine(x, y, x + SQUARE_SIZE, y); // Top line
        }
        if (!maze.mazeData[row][col].right) {
            g2d.drawLine(x + SQUARE_SIZE, y, x + SQUARE_SIZE, y + SQUARE_SIZE); // Right line
        }
        if (!maze.mazeData[row][col].bottom) {
            g2d.drawLine(x + SQUARE_SIZE, y + SQUARE_SIZE, x, y + SQUARE_SIZE); // Bottom line
        }
        if (!maze.mazeData[row][col].left) {
            g2d.drawLine(x, y + SQUARE_SIZE, x, y); // Left line
        }

        // Restore the old stroke
        g2.setStroke(oldStroke);
    }

    void drawPath(Graphics g){
        //SolveRecursive sol = new SolveRecursive();
        //System.out.println("hello"); //debugging
        //System.out.println(solutionPath.size());

        for(int i = 0; i< solutionPath.size(); i++) {
            Point point = solutionPath.get(i);
            int r = point.row;
            int c = point.col;

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
}
