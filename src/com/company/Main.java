package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GamePiece test = new GamePiece(3);
        Board board = new Board(15, 9);
        boolean mark = false;
        Scanner kbinput = new Scanner(System.in);

        System.out.print("Pick an Option: " +
                "\n1) Player vs Player" +
                "\n2) Player vs Computer" +
                "\n3) Computer vs Computer" +
                "\nOption: ");

        if (kbinput.nextInt() == 1) {
            while (true) {
                System.out.print("Slot: ");
                try {
                    int slot = kbinput.nextInt();
                    if (board.checkMovement(slot)) {
                        board.makeMove(slot, mark);
                        mark = !mark;
                        board.getBoard();
                    } else {
                        System.out.println("That spot is taken. Try again.\n");
                    }
                } catch (InputMismatchException e) {
                    String slot = kbinput.next();
                    if (slot.toLowerCase().equals("example"))
                        Board.getExample();
                    else
                        System.out.println("That's not a proper input. Try again.");
                }

                if (board.checkWinCross('X')) {
                    System.out.println("Player \'X\' wins!");
                    break;
                } else if (board.checkWinChecks('0')) {
                    System.out.println("Player \'0\' wins!");
                    break;
                } else if (board.gameOver()) {
                    System.out.println("Tie Game!");
                    break;
                }

            }
        } else if (kbinput.nextInt() == 2) {
            while (true) {
                System.out.print("Slot: ");
                try {
                    int slot = kbinput.nextInt();
                    if (board.checkMovement(slot)) {
                        board.makeMove(slot, mark);
                        board.getBoard();
                    } else {
                        System.out.println("That spot is taken. Try again.\n");
                    }
                } catch (InputMismatchException e) {
                    String slot = kbinput.next();
                    if (slot.toLowerCase().equals("example"))
                        Board.getExample();
                    else
                        System.out.println("That's not a proper input. Try again.");
                }
                board.blockPlayer('X');
            }
        }
    }
}

