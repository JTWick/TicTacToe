package org.vashonsd;

import java.util.Random;
import java.util.Scanner;

public class Game {

    char[][] board;

    //creates char board;
    public Game() {
        this.board = new char[][]{{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }

    //checks if move is possible
    public String handle(int position) {
        if(isValidMove(position)) {
            placeMove(position, 'X');
            return this.toString();
        } else {
            return Integer.toString(position) + " is not a valid move. Please try again.";
        }
    }

    //checks if game is finished by calling hasContestantWon method, using symbols of player & computer respectively
    public boolean isGameFinished() {
        if (hasContestantWon('X')) {
            return true;
        }
        if (hasContestantWon('O')) {
            return true;
        }
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    //checks if a contestant won by going through all spots on board
    public boolean hasContestantWon(char symbol) {
        return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    //computer's turn - randomly generated where places - rand int 9 + 1 because starts at 0
    public void computerTurn() {
        Random rand = new Random();
        int computerMove;
        do {
            computerMove = rand.nextInt(9) + 1;
        } while (!isValidMove(computerMove));
        placeMove(computerMove, 'O');
    }
    //checking if space chosen is available - if board at position is empty then you can play
    public boolean isValidMove (int position) {
        int rowNum = rowFrom(position);
        int colNum = colFrom(position);
        return board[rowNum][colNum] == ' ';
    }

    //places symbol of contestant after confirmed valid move (nothing on that space on board)
    public void placeMove(int position, char symbol) {
        int rowNum = rowFrom(position);
        int colNum = colFrom(position);
        board[rowNum][colNum] = symbol;
    }

    public int rowFrom(int position) {
        return (position-1)/3;
    }

    public int colFrom(int position) {
        return (position -1) % 3;
    }


    //making the tic-tac-toe board look like tic-tac-toe
    @Override
    public String toString() {
        String spacer = " | ";
        return board[0][0] + spacer + board[0][1] + spacer + this.board[0][2]
                + "\n"
        + "- + - + -"
                + "\n"
        + board[1][0] + spacer +  board[1][1] + spacer +  board[1][2]
                + "\n"
        + "- + - + -"
                + "\n"
        + board[2][0] + spacer +  board[2][1] + spacer +  board[2][2];
    }
}
