import java.util.Scanner;

public class Main {
    public static Board[][] bigBoard = {{new Board(), new Board(), new Board()},
                                        {new Board(), new Board(), new Board()},
                                        {new Board(), new Board(), new Board()}};
    public static char playerTurn = 'x';
    public static int activeBoardCoor1;
    public static int activeBoardCoor2;
    public static Scanner in;

    public static void main(String[] args) throws Exception {
        // console version: 
        printBoard();
        in = new Scanner(System.in);
        chooseBoard();
        in.close();

        // app version:
        // new TicTacToe();
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        System.out.print(bigBoard[i][k].board[j][l] + " ");
                    }
                    if (k < 2) {
                        System.out.print("| ");
                    }
                }
                System.out.println("");
            }
            if (i < 2) {
                System.out.println("---------------------"); // 21 _____________________
            }
        }
    }

    public static void chooseBoard() throws Exception {
        System.out.println("\nPlayer " + playerTurn + ", it's your turn!");
        System.out.println("Type in the coordinates of where you want to play. Topmost leftmost cell is 0 0 0 0, and bottommost rightmost cell is 2 2 2 2.");

        boolean noInput = true;
        int coor1 = -1;
        int coor2 = -1;
        int coor3 = -1;
        int coor4 = -1;
        
        while (noInput) {
            try {
                coor1 = in.nextInt();
                coor2 = in.nextInt();
                coor3 = in.nextInt();
                coor4 = in.nextInt();

                if (coor1 < 0 || coor1 > 2 ||
                    coor2 < 0 || coor2 > 2 ||
                    coor3 < 0 || coor3 > 2 ||
                    coor4 < 0 || coor4 > 2 ||
                    bigBoard[coor1][coor2].board[coor3][coor4] != ' ' ||
                    bigBoard[coor1][coor2].isFull()) {
                        System.out.println("Invalid input, try again.");
                } else {
                    noInput = false;
                }
            } catch(Exception e) {
                throw new Exception("Invalid input, try again.");
            }
        }
        activeBoardCoor1 = coor1;
        activeBoardCoor2 = coor2;
        bigBoard[coor1][coor2].board[coor3][coor4] = playerTurn;
        
        turnOver(coor3, coor4);
    }

    public static void newTurn() throws Exception {
        if (bigBoard[activeBoardCoor1][activeBoardCoor2].isFull()) {
            chooseBoard();
            return;
        }
        System.out.println("\nPlayer " + playerTurn + ", it's your turn!");
        System.out.println("Type in the coordinates of where you want to play. You must play in board (" + activeBoardCoor1 + ", "
                            + activeBoardCoor2 + "). \nTopmost leftmost cell is 0 0, and bottommost rightmost cell is 2 2.");

        boolean noInput = true;
        int coor1 = -1;
        int coor2 = -1;
        
        while (noInput) {
            try {
                coor1 = in.nextInt();
                coor2 = in.nextInt();

                if (coor1 < 0 || coor1 > 2 ||
                    coor2 < 0 || coor2 > 2 ||
                    bigBoard[activeBoardCoor1][activeBoardCoor2].board[coor1][coor2] != ' ') {
                        System.out.println("Invalid input, try again.");
                } else {
                    noInput = false;
                }
            } catch(Exception e) {
                throw new Exception("Invalid input, try again.");
            }
        }
        
        bigBoard[activeBoardCoor1][activeBoardCoor2].board[coor1][coor2] = playerTurn;
        turnOver(coor1, coor2);
    }

    public static void turnOver(int coor1, int coor2) throws Exception {
        System.out.println("");
        printBoard();

        if (bigBoard[activeBoardCoor1][activeBoardCoor2].checkWin()) {
            System.out.println("Congrats Player " + playerTurn + "! You have won board (" + activeBoardCoor1 + ", " + activeBoardCoor2 + ").");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    bigBoard[activeBoardCoor1][activeBoardCoor2].board[i][j] = playerTurn;
                }
            }
            
            if (checkBigWin()) {
                System.out.println("Congrats Player " + playerTurn + "! You have won the game.");
                return;
            }
        }

        if (playerTurn == 'x') {
            playerTurn = 'o';
        } else {
            playerTurn = 'x';
        }
        
        activeBoardCoor1 = coor1;
        activeBoardCoor2 = coor2;
        newTurn();
    }

    public static boolean checkBigWin() {
        for (int i = 0; i < 3; i++) {
            if ((bigBoard[i][0].checkWin() && bigBoard[i][1].checkWin() && bigBoard[i][2].checkWin()) ||
                (bigBoard[0][i].checkWin() && bigBoard[1][i].checkWin() && bigBoard[2][i].checkWin())) {
                return true;
            }
        }

        if ((bigBoard[0][0].checkWin() && bigBoard[1][1].checkWin() && bigBoard[2][2].checkWin()) ||
            (bigBoard[2][0].checkWin() && bigBoard[1][1].checkWin() && bigBoard[0][2].checkWin())) {
            return true;
        }

        return false;
    }
}
