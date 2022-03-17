package com.bridgelabz.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    // The game board and the game status
    public static char playerChoice;
    public static char compChoice;
    public static int userPlaceSelect;
    public static int compPlaceSelect;
    public static int size = 10;
    public static char[] board = new char[size];

    public static void main(String[] args) {
        initGame();
        selection();
        printBoard();
        toss();
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
        playerChoice = input.next().charAt(0);
        if (playerChoice == 'x'|| playerChoice == 'X')
        {
            compChoice = 'o';
        } else {
            compChoice = 'x';
            playerChoice = 'o';
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
    private static void toss(){
        System.out.println("Calling for toss, player is '0' and computer '1'");
        Random rand = new Random();
        int whoPlays = rand.nextInt(2);
        System.out.println("Toss is " +whoPlays);
        if (whoPlays == 0) {
            playerTurn();
        } else {
            computerTurn();
        }
    }
    private static void computerTurn() {
        Random rand = new Random();
        while (true) {
            compPlaceSelect = rand.nextInt(9) + 1;
            System.out.println("Computer chose " + compPlaceSelect);
            if (indexCheck(board, compPlaceSelect)) {
                break;
            } else {
                System.out.println(userPlaceSelect + " is not a valid move.");
            }
            makingMove(board, compPlaceSelect, compChoice);
        }
    }
    private static void playerTurn() {
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            Scanner input = new Scanner(System.in);
            userPlaceSelect = input.nextInt();
            if (indexCheck(board, userPlaceSelect)) {
                break;
            } else {
                System.out.println(userPlaceSelect + " is not a valid move.");
            }
        }
        makingMove(board, userPlaceSelect, playerChoice);
    }
    private static boolean indexCheck(char[] board, int userPlaceSelect)
    {
        return switch (userPlaceSelect) {
            case 1 -> (board[1] == ' ');
            case 2 -> (board[2] == ' ');
            case 3 -> (board[3] == ' ');
            case 4 -> (board[4] == ' ');
            case 5 -> (board[5] == ' ');
            case 6 -> (board[6] == ' ');
            case 7 -> (board[7] == ' ');
            case 8 -> (board[8] == ' ');
            case 9 -> (board[9] == ' ');
            default -> false;
        };
    }
    private static void makingMove(char[] board, int userPlaceSelect, char playerChoice)
    {
        switch (userPlaceSelect) {
            case 1 -> board[1] = playerChoice;
            case 2 -> board[2] = playerChoice;
            case 3 -> board[3] = playerChoice;
            case 4 -> board[4] = playerChoice;
            case 5 -> board[5] = playerChoice;
            case 6 -> board[6] = playerChoice;
            case 7 -> board[7] = playerChoice;
            case 8 -> board[8] = playerChoice;
            case 9 -> board[9] = playerChoice;
            default -> System.out.println("Error");
        }
    }
}