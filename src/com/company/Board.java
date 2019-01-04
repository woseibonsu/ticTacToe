package com.company;

public class Board {

    GamePiece[][] board = new GamePiece[3][3];

    public Board()
    {
        int count = 1;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = new GamePiece(count);
                count++;
            }
        }
    }

    public void makeMove(int slot, boolean character)
    {
        char mark;
        //DECIDES WHICH MARK TO USE
        if(character)
            mark = '0';
        else
            mark = 'X';
        //PLACES MARK ON BOARD BASED ON SLOT CHOSEN
        board[((int)(slot/3.1))][(int)Math.ceil((double)slot%3.1)-1].mark = mark;
    }

    public void getBoard()
    {
        System.out.println(
                "\n  " + board[0][0].mark + " | " + board[0][1].mark + " | " + board[0][2].mark + "  " +
                "\n————————\n " +
                " " + board[1][0].mark + " | " + board[1][1].mark + " | " + board[1][2].mark + "  " +
                "\n————————\n " +
                " " + board[2][0].mark + " | " + board[2][1].mark + " | " + board[2][2].mark + "  \n");
    }

    public boolean checkMovement(int slot)
    {
        //CHECKS IF THERE IS A BLANK SPACE AT SAID COORDINATE
        if (board[((int)(slot/3.1))][(int)Math.ceil((double)slot%3.1)-1].mark == ' ')
            return true;
        else
            return false;
    }

    public static void getExample ()
    {
        System.out.println("\nWhen playing, select a position using this numbering: \n" +
                "  1 | 2 | 3  " +
                "\n————————\n  " +
                "4 | 5 | 6  " +
                "\n————————\n  " +
                "7 | 8 | 9  \n" +
            "Type \"Example\" to see it again.\n");
    }

    public boolean checkWin (char type)
    {
        boolean gameStatus = false;
        int[] magicNumbers = new int[]{0, 0, 0, 0, 0};

        int count = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j].mark == type)
                {
                    magicNumbers[count] = board[i][j].magicValue;
                    count++;
                }
            }
        }
        for (int j = 0; j < 10; j ++)
        {
            if (magicNumbers[j % 5] + magicNumbers[j % 3] + magicNumbers[j % 2] == 15)
            {
                        System.out.println("J: " + magicNumbers[j]);
                        System.out.println("K: " + magicNumbers[j % 3]);
                        System.out.println("L: " + magicNumbers[j % 2]);
                        gameStatus = true;
                        for (int temp : magicNumbers)
                            System.out.println(temp);
                        break;
            }
        }

        return gameStatus;
    }
}
