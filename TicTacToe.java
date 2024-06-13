import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    int WINDOW_SIZE = 765;
    int ROWS = 9;
    int COLUMNS = 9;
    int BORDER_SIZE = 1;
    int TEXT_SIZE = 45;
    int BUTTON_DIMENSIONS = WINDOW_SIZE / ROWS;

    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setSize(WINDOW_SIZE, WINDOW_SIZE);
        setLayout(new GridLayout(ROWS, COLUMNS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Border border = new LineBorder(Color.BLACK, BORDER_SIZE);

        for (int i = 0; i < (ROWS * COLUMNS); i++) {
            JButton button = new JButton("x");
            button.setFont(new Font("Times New Roman", Font.PLAIN, TEXT_SIZE));
            // button.setBorder(border);

            // drawRect(BUTTON_DIMENSIONS, BUTTON_DIMENSIONS, 5, 5);
            
            // if ((i / 9) % 3 == 0 && i != 0) {
            //     button.setBorder(BorderFactory.createCompoundBorder(thickBorder, thinBorder));
            // }
            // if (i % 9 % 3 == 0 && i != 0) {
            //     button.setBorder(BorderFactory.createCompoundBorder(thickBorder, thinBorder));
            // }
            
            add(button);
        }

        // setVisible(true);


        // JPanel panel = new JPanel() {
        //     @Override
        //     protected void paintComponent(Graphics g) {
        //         super.paintComponent(g);
        //         drawGrid(g);
        //     }

        //     private void drawGrid(Graphics g) {
        //         int rows = 9;
        //         int cols = 9;
        //         int width = getWidth();
        //         int height = getHeight();
        //         int cellWidth = width / cols;
        //         int cellHeight = height / rows;

        //         g.setColor(Color.BLACK);

        //         // Draw vertical lines
        //         for (int i = 0; i <= cols; i++) {
        //             int x = i * cellWidth;
        //             g.drawLine(x, 0, x, height);

        //             if (i % 3 == 0) {
        //                 g.drawLine(x-2, 0, x-2, height);
        //                 g.drawLine(x-1, 0, x-1, height);
        //                 g.drawLine(x+1, 0, x+1, height);
        //                 g.drawLine(x+2, 0, x+2, height);
        //             }
        //         }

        //         // Draw horizontal lines
        //         for (int i = 0; i <= rows; i++) {
        //             int y = i * cellHeight;
        //             g.drawLine(0, y, width, y);

        //             if (i % 3 == 0) {
        //                 g.drawLine(0, y-2, width, y-2);
        //                 g.drawLine(0, y-1, width, y-1);
        //                 g.drawLine(0, y+1, width, y+1);
        //                 g.drawLine(0, y+2, width, y+2);
        //             }
        //         }
        //     }
        // };

        // add(panel);
        // setVisible(true);

        JPanel panel = new JPanel(new GridLayout(9, 9, 1, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding

        // Add buttons to the grid
        for (int i = 0; i < 81; i++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(50, 50)); // Set preferred size for buttons
            panel.add(button);
        }

        add(panel);
        setVisible(true);
    }
}