import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    int ROWS = 9;
    int COLUMNS = 9;

    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setSize(810, 810);
        setLayout(new GridLayout(ROWS, COLUMNS));
        
        new JButton("hi");

        setVisible(true);
    }
}