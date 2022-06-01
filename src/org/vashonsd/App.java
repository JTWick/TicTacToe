package org.vashonsd;

import java.util.Scanner;

import java.util.Random;

public class App {

    //main method - creating the char "board" + checking if game finished
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        printBoard(board);
        while (true) {
            playerTurn(board, scan);
            if(isGameFinished(board)) {
                break;
            }
            printBoard(board);
            computerTurn(board);
            if(isGameFinished(board)) {
                break;
            }
            printBoard(board);
        }
        scan.close();
    }

    //checks if game is finished by calling hasContestantWon method, using symbols of player & computer respectively
    private static boolean isGameFinished(char[][] board) {
        if (hasContestantWon(board, 'X')) {
            printBoard(board);
            System.out.println("Player wins!");
            return true;
        }
        if (hasContestantWon(board, 'O')) {
            printBoard(board);
            System.out.println("Computer wins!");
            return true;
        }
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("You and the computer tied.");
        return true;
    }

    //checks if a contestant won by going through all spots on board
    private static boolean hasContestantWon(char[][] board, char symbol) {
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
    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        do {
            computerMove = rand.nextInt(9) + 1;
        } while (!isValidMove(board, Integer.toString(computerMove)));
        System.out.println("Computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove), 'O');
    }
    //checking if space chosen is available - if board at position is empty then you can play
    private static boolean isValidMove (char[][] board, String position) {
        return switch (position) {
            case "1" -> (board[0][0] == ' ');
            case "2" -> (board[0][1] == ' ');
            case "3" -> (board[0][2] == ' ');
            case "4" -> (board[1][0] == ' ');
            case "5" -> (board[1][1] == ' ');
            case "6" -> (board[1][2] == ' ');
            case "7" -> (board[2][0] == ' ');
            case "8" -> (board[2][1] == ' ');
            case "9" -> (board[2][2] == ' ');
            default -> false;
        };
    }

    //places move after confirmed valid move (nothing on that space on board)
    private static void placeMove(char[][] board, String position, char symbol) {
        switch (position) {
            case "1" -> board[0][0] = symbol;
            case "2" -> board[0][1] = symbol;
            case "3" -> board[0][2] = symbol;
            case "4" -> board[1][0] = symbol;
            case "5" -> board[1][1] = symbol;
            case "6" -> board[1][2] = symbol;
            case "7" -> board[2][0] = symbol;
            case "8" -> board[2][1] = symbol;
            case "9" -> board[2][2] = symbol;
            default -> System.out.println(":(");
        }
    }

    //asks player where they'd like to play - uses isValidMove method to determine if move is valid or not
    private static void playerTurn(char[][] board, Scanner scan) {
        String userInput;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            userInput = scan.nextLine();
            if (isValidMove(board, userInput)) {
                break;
            } else {
                System.out.println(userInput + " is not a valid move.");
            }
        }
        placeMove(board, userInput,'X');
    }

    //making the tic-tac-toe board look like tic-tac-toe
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" +  board[0][1] + "|" +  board[0][2] );
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" +  board[1][1] + "|" +  board[1][2] );
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" +  board[2][1] + "|" +  board[2][2] );
    }

}
