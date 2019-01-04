package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GamePiece test = new GamePiece(3);
        Board board = new Board();
        boolean mark = false;
        Scanner kbinput = new Scanner(System.in);
        boolean gameStatus = true;

        while(gameStatus)
        {
            System.out.print("Slot: ");
            try
            {
                int slot = kbinput.nextInt();
                if (board.checkMovement(slot)) {
                    board.makeMove(slot, mark);
                    mark = !mark;
                    board.getBoard();
                } else {
                    System.out.println("That spot is taken. Try again.\n");
                }
            } catch (InputMismatchException e)
            {
                String slot = kbinput.next();
                if (slot.toLowerCase().equals("example"))
                    Board.getExample();
                else
                    System.out.println("That's not a proper input. Try again.");
            }

            if (board.checkWin('X'))
            {
                System.out.println("Player X wins!");
                gameStatus = false;
            }
            if (board.checkWin('0'))
            {
                System.out.println("Player X wins!");
                gameStatus = false;
            }

        }
    }
}

