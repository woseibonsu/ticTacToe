package com.company;

import java.util.ArrayList;

public class Board {

    GamePiece[][] board = new GamePiece[3][3];
    ArrayList<Integer> cross = new ArrayList<Integer>();
    ArrayList<Integer> checks = new ArrayList<Integer>();
    int finishValue ;
    int boardSize;
    public Board(int newFinishValue, int newBoardSize) {
        finishValue = 15;
        boardSize = 9;

        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = new GamePiece(count);
                count++;
            }
        }
    }

    public void makeMove(int slot, boolean character) {
        char mark;
        //DECIDES WHICH MARK TO USE
        if (character) {
            checks.add(GamePiece.getMagicSquare()[((int) (slot / 3.1))][(int) Math.ceil((double) slot % 3.1) - 1]);
            mark = '0';
        } else {
            cross.add(GamePiece.getMagicSquare()[((int) (slot / 3.1))][(int) Math.ceil((double) slot % 3.1) - 1]);
            mark = 'X';
        }
        //PLACES MARK ON BOARD BASED ON SLOT CHOSEN
        board[((int) (slot / 3.1))][(int) Math.ceil((double) slot % 3.1) - 1].mark = mark;
    }

    public void getBoard() {
        System.out.println(
                "\n  " + board[0][0].mark + " | " + board[0][1].mark + " | " + board[0][2].mark + "  " +
                        "\n————————\n " +
                        " " + board[1][0].mark + " | " + board[1][1].mark + " | " + board[1][2].mark + "  " +
                        "\n————————\n " +
                        " " + board[2][0].mark + " | " + board[2][1].mark + " | " + board[2][2].mark + "  \n");
    }

    public boolean checkMovement(int slot) {
        //CHECKS IF THERE IS A BLANK SPACE AT SAID COORDINATE
        if (board[((int) (slot / 3.1))][(int) Math.ceil((double) slot % 3.1) - 1].mark == ' ')
            return true;
        else
            return false;
    }

    public static void getExample() {
        System.out.println("\nWhen playing, select a position using this numbering: \n" +
                "  1 | 2 | 3  " +
                "\n————————\n  " +
                "4 | 5 | 6  " +
                "\n————————\n  " +
                "7 | 8 | 9  \n" +
                "Type \"Example\" to see it again.\n");
    }

    public boolean checkWinCross(char type) {

        System.out.println("Crosses: " + cross);

        if (cross.size() > 2) {
            return gameFinishedHelper(cross);
        }

        return false;

    }

    public boolean checkWinChecks(char type) {
        System.out.println("Checks: " + checks);

        if (checks.size() > 2) {
            return gameFinishedHelper(checks);
        }

        return false;

    }

    private boolean gameFinishedHelper(ArrayList<Integer> values) {
        int arraySize = values.size();
        boolean found = false;
        for (int i = 0; i < arraySize - 2; i++) {
            for (int j = i + 1; j < arraySize - 1; j++) {
                for (int k = j + 1; k < arraySize; k++) {

                    if (values.get(i) + values.get(j) + values.get(k) == finishValue) {
                        found = true;
                    }
                }
            }
        }
        return found;
    }

    public boolean gameOver(){
        return (this.checks.size() + this.cross.size()) == finishValue;
    }

    public void blockPlayer (char player)
    {
        int slot = 0;
        if(player == 'X')
        {
            if (cross.size() > 2)
            {
                System.out.println("got here");
                for (int i = 0; i < 3; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        if(GamePiece.getMagicSquare()[i][j] != 15 - cross.get(0))
                        {
                            slot++;
                            System.out.println("sup");
                        }
                    }
                }
            }
        }
        makeMove(slot, true);
    }
}
