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

    public static void main(String[] args) {
        initGame();
        selection();
        printBoard();
        toss();
        for (int i = 1; i <= 9; i++) {
            turn();
        }
    }

    public static void initGame() {
        for (int row = 1; row < size; ++row) {
            board[row] = ' ';  // all cells empty
        }
        System.out.println(board[2]);
    }

    public static void selection() {
        System.out.println("Would you like to choose 'x' or 'o' to play");
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
        } else {
            currentPlayer = 1;
        }
    }

    private static void turn() {
        while (currentPlayer == 1) {
            Random rand = new Random();
            while (true) {
                compPlaceSelect = rand.nextInt(9) + 1;
                System.out.println("Computer chose " + compPlaceSelect);
                if (indexCheck(board, compPlaceSelect)) {
                    break;
                } else {
                    System.out.println("Hello computer " + compPlaceSelect + " is not a valid move.");
                }
                makingMove(board, compPlaceSelect, compChoice);
            }
        }
        while (currentPlayer == -1) {
            while (true) {
                System.out.println("Where would you like to play? (1-9)");
                Scanner input = new Scanner(System.in);
                userPlaceSelect = input.nextInt();
                if (indexCheck(board, userPlaceSelect)) {
                    break;
                } else {
                    System.out.println("Hello player " + userPlaceSelect + " is not a valid move.");
                }
            }
            makingMove(board, userPlaceSelect, playerChoice);
        }
        currentPlayer = -currentPlayer;
    }

    private static boolean indexCheck(char[] board, int userPlaceSelect) {
        return (board[userPlaceSelect] == ' ');
    }

    private static void makingMove(char[] board, int userPlaceSelect, char playerChoice) {
        board[userPlaceSelect] = playerChoice;
    }

    public static int evaluate() {
        if ((board[1] == board[2] && board[2] == board[3]) || (board[4] == board[5] && board[5] == board[6]) || (board[7] == board[8] && board[8] == board[9])) {
            if (board[1] == compChoice || board[4] == compChoice || board[7] == compChoice) {
                return +10;
            } else if (board[1] == playerChoice || board[4] == playerChoice || board[7] == playerChoice) {
                return -10;
            }
        }
        if ((board[1] == board[4] && board[4] == board[7]) || (board[2] == board[5] && board[5] == board[8]) || (board[3] == board[6] && board[6] == board[9])) {
            if (board[1] == compChoice || board[2] == compChoice || board[3] == compChoice) {
                return +10;
            } else if (board[1] == playerChoice || board[2] == playerChoice || board[3] == playerChoice) {
                return -10;
            }
        }
        if ((board[1] == board[2] && board[2] == board[3]) || (board[4] == board[5] && board[5] == board[6]) || (board[7] == board[8] && board[8] == board[9])) {
            if (board[1] == compChoice || board[4] == compChoice || board[7] == compChoice) {
                return +10;
            } else if (board[1] == playerChoice || board[4] == playerChoice || board[7] == playerChoice) {
                return -10;
            }
        }
        return 0;
    }
}