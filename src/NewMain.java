import java.nio.charset.Charset;
import java.util.Scanner;

public class NewMain {
    public static void main(String[] args) {
        String[][] board = new String[3][3];
        String[][] print = new String[3][3];
        String input = "A";
        String player = "X";
        int row = 0;
        int col = 0;
        int counter = 0;
        String winner = "A";

        final String MOVE_UP = "W";
        final String MOVE_DOWN = "S";
        final String TURN_LEFT = "Q";
        final String TURN_RIGHT = "E";

        //Fields
        Scanner in = new Scanner( System.in, Charset.defaultCharset() );

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                board[x][y] = " ";
                System.out.print(board[x][y] + "|");
            }
            System.out.println();
            if (x < 2)
                System.out.println( "-------------------" );
        }

        for (int x = 0; x < print.length; x++) {
            for (int y = 0; y < print[x].length; y++) {
                print[x][y] = " ";
            }
        }

        while (winner.equals( "A" )) {

            if (counter % 2 == 0) {
                player = "X";
            } else {
                player = "O";
            }
            counter++;

            board[0][0] = player;

            input = "A";

            row = 0;
            col = 0;

            //Controls Player
            while (!input.equalsIgnoreCase( "" )) {
                System.out.println( "Where would you like to move your piece? Press enter to set it" );
                System.out.print( "#" );
                input = in.nextLine();

                //If that validates user input and only lets you input the correct values
                if (input.equalsIgnoreCase( TURN_LEFT ) || input.equalsIgnoreCase( TURN_RIGHT ) || input.equalsIgnoreCase( MOVE_DOWN ) || input.equalsIgnoreCase( MOVE_UP )) {

                    //If user inputs "E" it will increment the column (in this case) so that it is ready to move to the right
                    if (input.equalsIgnoreCase( TURN_RIGHT )) {
                        col++;
                        board[row][col] = player;

                        //Deletes previous character in the maze array but not in the draw
                        if (board[row][col - 1].equals( player )) {
                            board[row][col - 1] = " ";
                        }

                        //Prints the array
                        for (int row1 = 0; row1 < board.length; row1++) {
                            for (int col1 = 0; col1 < board[row1].length; col1++) {
                                System.out.print( board[row1][col1] + "|" );
                            }
                            System.out.println();
                            if (row1 < 2)
                                System.out.println( "-------------------" );
                        }
                    }

                    //Turn Left
                    if (input.equalsIgnoreCase( TURN_LEFT )) {
                       col--;
                        board[row][col] = player;


                        if (board[row][col + 1].equals( player )) {
                            board[row][col + 1] = " ";
                        }

                        //Prints the array
                        for (int row1 = 0; row1 < board.length; row1++) {
                            for (int col1 = 0; col1 < board[row1].length; col1++) {
                                System.out.print( board[row1][col1] + "|" );
                            }
                            System.out.println();
                            if (row1 < 2)
                                System.out.println( "-------------------" );
                        }
                    }


                    //Move Up
                    if (input.equalsIgnoreCase( MOVE_UP )) {
                        row--;
                        board[row][col] = player;


                        if (board[row + 1][col].equals( player )) {
                            board[row + 1][col] = " ";
                        }
                        //Prints the array
                        for (int row1 = 0; row1 < board.length; row1++) {
                            for (int col1 = 0; col1 < board[row1].length; col1++) {
                                System.out.print( board[row1][col1] + "|" );
                            }
                            System.out.println();
                            if (row1 < 2)
                                System.out.println( "-------------------" );
                        }
                    }


                    //Move Down
                    if (input.equalsIgnoreCase( MOVE_DOWN )) {
                        row++;
                        board[row][col] = player;


                        if (!board[row][col - 1].equals( player )) {
                            board[row - 1][col] = " ";
                        }

                        //Print the array
                        for (int row1 = 0; row1 < board.length; row1++) {
                            for (int col1 = 0; col1 < board[row1].length; col1++) {
                                System.out.print( board[row1][col1] + "|" );
                            }
                            System.out.println();
                            if (row1 < 2)
                                System.out.println( "-------------------" );
                        }
                    }

                //Invalid input message
                } else {
                    System.out.println( "*****************************************" );
                    System.out.println( "Invalid input, please try again." );
                    System.out.println( "*****************************************" );
                }
            }

            print[row][col] = board[row][col];

            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[x].length; y++) {
                    board[x][y] = " ";
                    board[0][0] = player;
                }
            }

        /*   //Only decrements and "doesn't move" if a wall is encountered
        if (!board[row][col].equals( " " )) {
            System.out.println( "*****************************************" );
            System.out.println( "Already taken space." );
            System.out.println( "*****************************************" );
            col--;
        } else {
         */

        /*if (!board[row][col].equals( " " )) {
                            System.out.println( "*****************************************" );
                            System.out.println( "Already taken space." );
                            System.out.println( "*****************************************" );
                            col++;
                        } else {


if (!board[row][col].equals( " " )) {
                            System.out.println( "*****************************************" );
                            System.out.println( "Already taken space." );
                            System.out.println( "*****************************************" );
                            row++;
                        } else {


                        if (!board[row][col].equals( " " )) {
                            System.out.println( "*****************************************" );
                            System.out.println( "Already taken space." );
                            System.out.println( "*****************************************" );
                            row--;
                        } else {
                         */

            //Print the array
            for (int row1 = 0; row1 < print.length; row1++) {
                for (int col1 = 0; col1 < print[row1].length; col1++) {
                    System.out.print( print[row1][col1] + "|" );
                }
                System.out.println();
                if (row1 < 2)
                    System.out.println( "-------------------" );
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

            if (winner.equals( "O" )) {
                System.out.println( "Player 2 wins the game." );
            }

        }
    }
}
