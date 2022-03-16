package com.bridgelabz.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    // The game board and the game status
        public static int size = 10;
        public static char[] board = new char[size];

    public static void main(String[] args) {
        initGame();
        selection();
        printBoard();
    }
    public static void initGame() //Initialize the game-board contents and the current states
    {
        for (int row = 1; row < size; ++row)
        {
                board[row]= ' ';  // all cells empty
        }
        System.out.println(board[2]);
    }
    public static void selection() {
        System.out.println("Would you like to choose 'x' or 'o' to play");
        Scanner input = new Scanner(System.in);
        String playerChoice = input.next();
        if (playerChoice.equals("x"))
        {
            String compChoice = String.valueOf('o');
        } else {
            String compChoice = String.valueOf('x');
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
}