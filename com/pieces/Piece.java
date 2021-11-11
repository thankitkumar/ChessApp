package com.pieces;
package com.Board;
//Declaring variable
public class Piece {
    private int x;
    private int y;
    final private boolean is_white;
    public Board board;
// constructor of each piece
    public Piece(int x, int y, boolean is_white,  Board board)
    {
        this.is_white = is_white;
        this.x = x;
        this.y = y;
        this.board = board;
    }
    public boolean isWhite()
    {
        return is_white;
    }

    public boolean isBlack()
    {
        return !is_white;
    }
    // setter for x
    public void setX(int x)
    {
        this.x = x;
    }
    // setter for y
    public void setY(int y)
    {
        this.y = y;
    }
    // getter for x
    public int getX()
    {
        return x;
    }
    // getter for y
    public int getY()
    {
        return y;
    }
// legalMoves for override each pieces
    public boolean legalMove(int destination_x, int destination_y)
    {
        return false;
    }
}
