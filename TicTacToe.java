import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    int ROWS = 9;
    int COLUMNS = 9;

    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setSize(810, 810);
        setLayout(new GridLayout(ROWS, COLUMNS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton hi = new JButton("hi");
        hi.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        JPanel panel1 = new JPanel();
        panel1.add(hi);
        add(panel1, BorderLayout.NORTH);

        setVisible(true);
    }
}