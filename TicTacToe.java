import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
    int WINDOW_SIZE = 765;
    int ROWS = 9;
    int COLUMNS = 9;
    int BORDER_SIZE = 1;
    int TEXT_SIZE = 45;
    int BUTTON_DIMENSIONS = WINDOW_SIZE / ROWS;
    // JButton[][] buttons = new JButton[ROWS][COLUMNS];

    public TicTacToe() {
        setTitle("Tic-Tac-Toe");
        setSize(WINDOW_SIZE, WINDOW_SIZE);
        setLayout(new GridLayout(ROWS, COLUMNS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Border border = new LineBorder(Color.BLACK, BORDER_SIZE);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        JButton button = new JButton(String.valueOf(Main.bigBoard[i][k].board[j][l]));
                        button.setFont(new Font("Times New Roman", Font.PLAIN, TEXT_SIZE));
                        button.setBorder(border);
                        button.addActionListener(new ButtonClickListener());
                        // button.addActionListener(new ButtonClickListener2(i, k, j, l));
                        // buttons[i * 3 + j][k * 3 + l] = button;
                        add(button);
                    }
                }
            }
        }
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JButton buttonClicked = (JButton) e.getSource();
            if (buttonClicked.getText().equals(" ")) {

                if (Main.playerTurn == 'x') {
                    Main.playerTurn = 'o';
                    buttonClicked.setText("x");
                } else {
                    Main.playerTurn = 'x';
                    buttonClicked.setText("o");
                }
            }
        }
    }

    private class ButtonClickListener2 implements ActionListener {
        int boardRow, boardCol, cellRow, cellCol;

        public ButtonClickListener2(int boardRow, int boardCol, int cellRow, int cellCol) {
            this.boardRow = boardRow;
            this.boardCol = boardCol;
            this.cellRow = cellRow;
            this.cellCol = cellCol;
        }

        public void actionPerformed(ActionEvent e) {
            try {
                if (Main.bigBoard[boardRow][boardCol].board[cellRow][cellCol] == ' ') {
                    Main.bigBoard[boardRow][boardCol].board[cellRow][cellCol] = Main.playerTurn;
                    // buttons[boardRow * 3 + cellRow][boardCol * 3 + cellCol].setText(String.valueOf(Main.playerTurn));

                    if (Main.playerTurn == 'x') {
                        Main.playerTurn = 'o';
                    } else {
                        Main.playerTurn = 'x';
                    }

                    Main.turnOver(cellRow, cellCol);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}