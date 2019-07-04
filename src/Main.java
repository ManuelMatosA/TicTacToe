import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[][] board = new String[3][5];
        String input;
        String player = null;
        String machine = null;
        int row = 0;
        int col = 0;

        final String MOVE_UP = "W";
        final String MOVE_DOWN = "S";
        final String TURN_RIGHT = "E";
        final String TURN_LEFT = "Q";

        //Fields
        Scanner in = new Scanner( System.in, Charset.defaultCharset() );

        System.out.println("Choose between X and O");
        input = in.nextLine();
        if (input.equalsIgnoreCase("X")) {
            player = "X";
            machine = "O";
        }

        else if (input.equalsIgnoreCase("O")) {
            player = "O";
            machine = "X";
        }

        else {
            System.out.println("There's only two players");
        }

        for (int x = 0; x < board.length ; x++) {
            for (int y = 0; y < board[x].length; y++) {
            board[x][y] = " ";
            if (y== 1 || y==3) {
                board[x][y] = "|";
            }
            System.out.print(board[x][y]);
            }
            System.out.println();
            if (x < 2)
            System.out.println("-----");
        }

        while ( !input.equals("")) {
            System.out.println("Where would you like to move your piece?  Press enter to set it");
            input = in.nextLine();

            if (input.equalsIgnoreCase( TURN_RIGHT ) && board[row][col].equals(" ")) {
                board[row][col] = player;
                col+=2;
                for (int x = 0; x < board.length; x++) {
                    for (int y = 0; y < board[x].length; y++) {
                        System.out.print( board[x][y] );
                    }
                    System.out.println();
                }
            }

            if (input.equalsIgnoreCase( TURN_LEFT ) && board[row][col].equals( " " )) {
                board[row][col] = player;
                col-=2;
                for (int x = 0; x < board.length; x++) {
                    for (int y = 0; y < board[x].length; y++) {
                        board[x][y] = " ";
                        System.out.print(board[x][y]);
                    }
                    System.out.println();
                }
            }

            if (input.equalsIgnoreCase( MOVE_UP ) && board[row][col].equals( " " )) {
                board[row][col] = player;
                row--;

                for (int x = 0; x < board.length; x++) {
                    for (int y = 0; y < board[x].length; y++) {
                        System.out.print( board[x][y] );
                    }
                    System.out.println();
                }
            }

            if (input.equalsIgnoreCase( MOVE_DOWN ) && board[row][col].equals( " " )) {
                board[row][col] = player;
                row++;
                for (int x = 0; x < board.length; x++) {
                    for (int y = 0; y < board[x].length; y++) {
                        System.out.print(board[x][y]);
                    }
                    System.out.println();
                }
            }
        }

        if (board[row][col].equals(player) && board[row][col+2].equals(" ")) {
            board[row][col+2] = machine;
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    System.out.print(board[x][y]);
                }
                System.out.println();
            }
        }
    }
}
