import javax.swing.*;
import java.awt.*;

public class VisualMaze extends JPanel {
    private static final int SQUARE_SIZE = 50;

    static MazeData[][] maze2;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int x;
        int y;

        for (int row = 0; row < maze2.length; row++) {
            for (int col = 0; col < maze2[0].length; col++) {
                x = col * SQUARE_SIZE + 30;
                y = row * SQUARE_SIZE + 30;

                g2d.setStroke(new BasicStroke(5));
                g2d.setColor(Color.BLACK);

                drawCell(g2d, maze2, row, col, x, y);

            }
        }
    }

    static void drawCell(Graphics2D g2d, MazeData[][] maze,int row, int col, int x, int y){
        if(!maze[row][col].top){
            g2d.drawLine(x, y, x + SQUARE_SIZE, y); // Top line
        }
        if(!maze[row][col].right){
            g2d.drawLine(x + SQUARE_SIZE, y, x + SQUARE_SIZE, y + SQUARE_SIZE); // Right line
        }
        if(!maze[row][col].bottom){
            g2d.drawLine(x + SQUARE_SIZE, y + SQUARE_SIZE, x, y + SQUARE_SIZE); // Bottom line
        }
        if(!maze[row][col].left){
            g2d.drawLine(x, y + SQUARE_SIZE, x, y); // Left line
        }
    }

    void visualize(MazeData[][] maze){
        maze2 = maze;
        JFrame frame = new JFrame("Maze Solver");
        VisualMaze drawSquares = new VisualMaze();
        frame.add(drawSquares);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
