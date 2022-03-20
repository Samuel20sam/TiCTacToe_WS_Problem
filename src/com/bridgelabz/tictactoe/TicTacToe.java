package com.bridgelabz.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    // The game board and the game status
    public static char playerChoice;
    public static char compChoice;
    public static int userPlaceSelect;
    public static int compPlaceSelect;
    public static int currentPlayer;
    public static int size = 10;
    public static char[] board = new char[size];

    public static void initGame() {
        System.out.println();
        for (int index = 1; index < size; ++index) {
            board[index] = ' ';  // all cells empty
            System.out.println("Value of index " + index + " is " + board[index]);
        }
    }

    public static void selection() {
        System.out.println("\nWould you like to choose 'x' or 'o' to play");
        Scanner input = new Scanner(System.in);
        playerChoice = input.next().charAt(0);
        if (playerChoice == 'x' || playerChoice == 'X') {
            compChoice = 'o';
        } else {
            compChoice = 'x';
            playerChoice = 'o';
        }
    }

    private static void printBoard() {
        System.out.println("-------");
        System.out.println("|" + board[1] + "|" + board[2] + "|" + board[3] + "|");
        System.out.println("-------");
        System.out.println("|" + board[4] + "|" + board[5] + "|" + board[6] + "|");
        System.out.println("-------");
        System.out.println("|" + board[7] + "|" + board[8] + "|" + board[9] + "|");
        System.out.println("-------");
    }

    private static void toss() {
        System.out.println("Calling for toss, player is '0' and computer '1'");
        Random rand = new Random();
        int whoPlays = rand.nextInt(2);
        System.out.println("Toss is " + whoPlays);
        if (whoPlays == 0) {
            currentPlayer = -1;
            System.out.println("Human wins");
        } else {
            currentPlayer = 1;
            System.out.println("Computer wins");
        }
    }

    public static boolean indexCheck(char[] board, int userPlaceSelect) {
        boolean result = (board[userPlaceSelect] == ' ');
        System.out.println("Result of boolean check is: " +result);
        return result;
    }

    public static void makingMove(char[] board, int userPlaceSelect, char playerChoice) {
        board[userPlaceSelect] = playerChoice;
        printBoard();
    }

    public static int evaluate(char[] board) {
        if ((board[1] == board[2] && board[2] == board[3]) ||
                (board[4] == board[5] && board[5] == board[6]) ||
                (board[7] == board[8] && board[8] == board[9]))
        {
            System.out.println("CompChoice in first if loop of evaluate is " +compChoice);
            System.out.println("playerChoice in first if loop of evaluate is " +playerChoice);
            if (board[1] == compChoice || board[4] == compChoice || board[7] == compChoice) {
                return +10;
            } else if (board[1] == playerChoice || board[4] == playerChoice || board[7] == playerChoice) {
                return -10;
            }
        }
        if ((board[1] == board[4] && board[4] == board[7]) ||
                (board[2] == board[5] && board[5] == board[8]) ||
                (board[3] == board[6] && board[6] == board[9]))
        {
            System.out.println("CompChoice in second if loop of evaluate is " +compChoice);
            System.out.println("playerChoice in second if loop of evaluate is " +playerChoice);
            if (board[1] == compChoice || board[2] == compChoice || board[3] == compChoice) {
                return +10;
            } else if (board[1] == playerChoice || board[2] == playerChoice || board[3] == playerChoice) {
                return -10;
            }
        }
        if (board[1] == board[5] && board[5] == board[9])
        {
            System.out.println("CompChoice in third if loop of evaluate is " +compChoice);
            System.out.println("playerChoice in third if loop of evaluate is " +playerChoice);
            if (board[1] == compChoice) {
                return +10;
            } else if (board[1] == playerChoice) {
                return -10;
            }
        }
        if (board[7] == board[5] && board[5] == board[3])
        {
            System.out.println("CompChoice in fourth if loop of evaluate is " +compChoice);
            System.out.println("playerChoice in fourth if loop of evaluate is " +playerChoice);
            if (board[7] == compChoice) {
                return +10;
            } else if (board[7] == playerChoice) {
                return -10;
            }
        }
        return 0;
    }

    // This is the minimax function. It considers all the possible ways the game can go and returns the value of the board
    public static int minimax(char[] board, int depth, Boolean isMax) {

        int best;
        int score = evaluate(board);

        System.out.println("The returned value in minimax is :" +score);

        if (score == 10) // If Maximizer has won the game return their evaluated score
            return score;

        if (score == -10) // If Minimizer has won the game return their evaluated score
            return score;

        if (isMax) // If this maximizer's move
        {
            best = -1000;
        } else // If this minimizer's move
        {
            best = 1000;
        }
        for (int index = 1; index < size; ++index)
        {
            System.out.println("index value in minimax is: " +index);
            if (board[index] == ' ')
            { // Check if cell is empty
                board[index] = compChoice; // Make the move
                best = Math.max(best, minimax(board, depth + 1, false)); // Call minimax recursively and choose the maximum value
                board[index] = ' '; // Undo the move
            }
        }
        return best;
    }
    public static void findBestMove(char[] board) // This will return the best possible move for the player
    {
        int bestVal = -1000;

        for (int index = 0; index < size; index++) // Traverse all cells, evaluate minimax function for all empty cells. And return the cell with optimal value.
        {
            System.out.println("index in findBestMove is: " +index);
            if (board[index] == ' ') // Check if cell is empty
            {
                System.out.println("CompChoice in findBestMove is " +compChoice);
                board[index] = compChoice; // Make the move
                int moveVal = minimax(board, 0, false); // compute evaluation function for this move.
                System.out.println("MoveVal is: " +moveVal);
                board[index] = ' '; // Undo the move

                if (moveVal > bestVal) // If the value of the current move is more than the best value, then update best
                {
                    compPlaceSelect=index;
                    System.out.println("compPlaceSelect in findBestMove is: " +compPlaceSelect);
                    bestVal = moveVal;
                }
            }
        }
    }
    public static void turn()
    {
        if (currentPlayer == 1)
        {
            System.out.println("\nCurrent player is Computer");
            findBestMove(board);
            System.out.println("Computer chose " + compPlaceSelect);

            if (indexCheck(board, compPlaceSelect)) {
                makingMove(board, compPlaceSelect, compChoice);
            } else {
                System.out.println("Hello computer " + compPlaceSelect + " is not a valid move.");
                findBestMove(board);
            }
        }
        if (currentPlayer == -1)
        {
            System.out.println("\nCurrent player is Human");
            System.out.println("Where would you like to play? (1-9)");
            Scanner input = new Scanner(System.in);
            userPlaceSelect = input.nextInt();
            if (indexCheck(board, userPlaceSelect)) {
                makingMove(board, userPlaceSelect, playerChoice);
            } else {
                System.out.println("Hello player " + userPlaceSelect + " is not a valid move.");
                turn();
            }
        }
    }
    public static void main(String[] args) {
        initGame();
        selection();
        printBoard();
        toss();

        for (int i = 1; i <= 9; i++)
        {
            turn();
            currentPlayer = -currentPlayer;
        }
    }
}