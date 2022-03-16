package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    // The game board and the game status
        public static String playerChoice;
        public static String compChoice;
        public static String userInput;
        public static int size = 10;
        public static char[] board = new char[size];

    public static void main(String[] args) {
        initGame();
        selection();
        printBoard();
        playerTurn();
    }
    public static void initGame() {
        for (int row = 1; row < size; ++row)
        {
                board[row]= ' ';  // all cells empty
        }
        System.out.println(board[2]);
    }
    public static void selection() {
        System.out.println("Would you like to choose 'x' or 'o' to play");
        Scanner input = new Scanner(System.in);
        playerChoice = input.next();
        if (playerChoice.equalsIgnoreCase("x"))
        {
            compChoice = String.valueOf('o');
        } else {
            compChoice = String.valueOf('x');
            playerChoice = String.valueOf('o');
        }
    }
    private static void printBoard()
    {
        System.out.println("-------");
        System.out.println("|" +board[1] + "|" +  board[2] + "|" +  board[3] +"|");
        System.out.println("-------");
        System.out.println("|" +board[4] + "|" +  board[5] + "|" +  board[6] +"|");
        System.out.println("-------");
        System.out.println("|" +board[7] + "|" +  board[8] + "|" +  board[9] +"|");
        System.out.println("-------");
    }
    private static void playerTurn() {
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            Scanner input = new Scanner(System.in);
            userInput = input.next();
            if (indexCheck(board, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        //makingMove(board, userInput, playerChoice);
    }
    private static boolean indexCheck(char[] board, String userInput)
    {
        return switch (TicTacToe.userInput) {
            case "1" -> (TicTacToe.board[1] == ' ');
            case "2" -> (TicTacToe.board[2] == ' ');
            case "3" -> (TicTacToe.board[3] == ' ');
            case "4" -> (TicTacToe.board[4] == ' ');
            case "5" -> (TicTacToe.board[5] == ' ');
            case "6" -> (TicTacToe.board[6] == ' ');
            case "7" -> (TicTacToe.board[7] == ' ');
            case "8" -> (TicTacToe.board[8] == ' ');
            case "9" -> (TicTacToe.board[9] == ' ');
            default -> false;
        };
    }
}