package org.vashonsd;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Game thisGame = new Game();
//        thisGame.start();
        boolean stillPlaying = true;
        boolean gameOver = false;
        System.out.println(thisGame.rowFrom(2));
        System.out.println(thisGame.colFrom(2));
        Scanner scan = new Scanner((System.in));
        System.out.println(thisGame);
        while (stillPlaying) {
            while (!thisGame.isGameFinished())
                //collect user input
                System.out.println("Where would you like to play? (1-9)");
                int userInput = scan.nextInt();
                System.out.println(thisGame.handle(userInput));
                if (thisGame.isGameFinished()) {
                    break;
            }
            System.out.println("Now it is the computer's turn:");
            thisGame.computerTurn();
            System.out.println(thisGame);
            }
            if (thisGame.hasContestantWon('X')) {
                System.out.println("You win!");
            } else if (thisGame.hasContestantWon('O')) {
                System.out.println("You lose!");
            } else {
                System.out.println("Tie!");
        }
        System.out.println("Goodbye!");
    }

    }

