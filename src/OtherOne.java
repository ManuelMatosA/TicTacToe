import java.nio.charset.Charset;
import java.util.Scanner;

public class OtherOne {
    public static void main(String[] args) {
        String[][] board = new String[3][3];
        String player;
        int row;
        int col;
        int counter = 0;
        String winner = "A";


        //Fields
        Scanner in = new Scanner( System.in, Charset.defaultCharset() );

        //Draw
        System.out.println("Col\t  0|1|2");
        System.out.println( "--------------" );
        for (int x = 0; x < board.length; x++) {
            System.out.print("Row " + x + "|");
            for (int y = 0; y < board[x].length; y++) {
                board[x][y] = " ";
                System.out.print( board[x][y] + "|");
            }
            System.out.println();
            if (x < 2)
                System.out.println( "--------------" );
        }

        while(winner.equals("A")) {
            if (counter % 2 == 0) {
                player = "X";
            } else {
                player = "O";
            }

            do {
                System.out.println( "Where would you like to move your piece?  Enter the row" );
                System.out.print("#");
                row = in.nextInt();
                if (row > 2) {
                    System.out.println( "*****************************************" );
                    System.out.println( "Invalid input, please try again." );
                    System.out.println( "*****************************************" );
                }
            } while (row >2);

            do {
                System.out.println( "Where would you like to move your piece?  Enter the column" );
                System.out.print("#");
                col = in.nextInt();
                if (col > 2) {
                    System.out.println( "*****************************************" );
                    System.out.println( "Invalid input, please try again." );
                    System.out.println( "*****************************************" );
                }
            } while (col >2);

            //Checks first if the space you entered is not taken if so decreases the counter so the player is still
            if (!board[row][col].equals( " " )) {
                System.out.println("++++++++++++++++++++++++++++++");
                System.out.println("Already taken space");
                System.out.println("++++++++++++++++++++++++++++++");
                counter -= 1;
            } else {
                board[row][col] = player;

                System.out.println( "Col\t  0|1|2" );
                System.out.println( "--------------" );
                for (int x = 0; x < board.length; x++) {
                    System.out.print( "Row " + x + "|" );
                    for (int y = 0; y < board[x].length; y++) {
                        System.out.print( board[x][y] + "|" );
                    }
                    System.out.println();
                    if (x < 2)
                        System.out.println( "--------------" );
                }
            }

            // Check if X wins
            if (board[0][0].equals( "X" ) && board[1][0].equals( "X" ) && board[2][0].equals( "X" ))
                winner = "X";
            if (board[0][1].equals( "X" ) && board[1][1].equals( "X" ) && board[2][1].equals( "X" ))
                winner = "X";
            if (board[0][2].equals( "X" ) && board[1][2].equals( "X" ) && board[2][2].equals( "X" ))
                winner = "X";
            if (board[0][0].equals( "X" ) && board[0][1].equals( "X" ) && board[0][2].equals( "X" ))
                winner = "X";
            if (board[1][0].equals( "X" ) && board[1][1].equals( "X" ) && board[1][2].equals( "X" ))
                winner = "X";
            if (board[2][0].equals( "X" ) && board[2][1].equals( "X" ) && board[2][2].equals( "X" ))
                winner = "X";
            if (board[0][0].equals( "X" ) && board[1][1].equals( "X" ) && board[2][2].equals( "X" ))
                winner = "X";
            if (board[0][2].equals( "X" ) && board[1][1].equals( "X" ) && board[2][0].equals( "X" ))
                winner = "X";

            //If "X" Wins, print it.
            if (winner.equals( "X" )) {
                System.out.println( "Player 1 wins the game." );
            }

            // Check if O wins
            if (board[0][0].equals( "O" ) && board[1][0].equals( "O" ) && board[2][0].equals( "O" ))
                winner = "O";
            if (board[0][1].equals( "O" ) && board[1][1].equals( "O" ) && board[2][1].equals( "O" ))
                winner = "O";
            if (board[0][2].equals( "O" ) && board[1][2].equals( "O" ) && board[2][2].equals( "O" ))
                winner = "O";
            if (board[0][0].equals( "O" ) && board[0][1].equals( "O" ) && board[0][2].equals( "O" ))
                winner = "O";
            if (board[1][0].equals( "O" ) && board[1][1].equals( "O" ) && board[1][2].equals( "O" ))
                winner = "O";
            if (board[2][0].equals( "O" ) && board[2][1].equals( "O" ) && board[2][2].equals( "O" ))
                winner = "O";
            if (board[0][0].equals( "O" ) && board[1][1].equals( "O" ) && board[2][2].equals( "O" ))
                winner = "O";
            if (board[0][2].equals( "O" ) && board[1][1].equals( "O" ) && board[2][0].equals( "O" ))
                winner = "O";

            //If "O" Wins, print it.
            if (winner.equals( "O" )) {
                System.out.println( "Player 2 wins the game." );
            }

            //Checks for a tie or if nobody won
            for ( int x = 0; x < board.length; x++ ) {
                for ( int y = 0; y < board[ x ].length; y++ ) {
                    if (x== 2 &&  y==2) {
                        if (!board[x][y].equals( " " )) {
                            winner = "Tie";
                            System.out.println( "Nobody won. Tie." );
                        }
                    }
                }
            }
            //This counter is to determine whether or not the player will be X or O in association with the first if statement above
            counter++;
        }
    }
}
