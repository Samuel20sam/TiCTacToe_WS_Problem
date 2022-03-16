package com.bridgelabz.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    // Name-constants to represent the seeds and cell contents
    public static final int EMPTY = 0;

    // The game board and the game status
    public static final int ROWS = 3, COLS = 3; // number of rows and columns
    public static int[][] board = new int[ROWS][COLS]; // game board in 2D array containing (EMPTY, CROSS, NOUGHT)

    public static void main(String[] args) {
        initGame(); // Initialize the game-board and current status and plays the game once
        selection();
    }
    public static void initGame() //Initialize the game-board contents and the current states
    {
        for (int row = 1; row < ROWS; ++row) {
            for (int col = 1; col < COLS; ++col) {
                board[row][col] = EMPTY;  // all cells empty
            }
        }
        System.out.println(Arrays.deepToString(board));
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
}