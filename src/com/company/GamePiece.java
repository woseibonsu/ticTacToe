package com.company;

public class GamePiece {

    static int[][] magicSquare = new int[][]
            {
                    {4, 9, 2},
                    {3, 5, 7},
                    {8, 1, 6}
            };
    int slot;
    char mark = ' ';
    int magicValue;

    public GamePiece (int slot)
    {
        this.slot = slot;
        magicValue = magicSquare[((int)(slot/3.1))][(int)Math.ceil((double)slot%3.1)-1];

    }

    public static int[][] getMagicSquare(){
        return magicSquare;
    }
}
