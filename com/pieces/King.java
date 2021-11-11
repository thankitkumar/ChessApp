package com.pieces;
package com.Board;
public class King extends Piece {

    public King(int x, int y, boolean is_white, Board board)
    {
        super(x,y,is_white,board);
    }

    @Override
    public boolean legalMove(int destination_x, int destination_y)
    {
        //a king can move one square up, right, left, or down, or
        // diagonally, but he can never put himself in danger of an opposing
        // piece attacking him on the next turn. He cannot attack his own pieces.
        Piece possiblesPiece = board.getPiece(destination_x, destination_y);//get piece from board
        if (possiblesPiece != null) {
            if (possiblesPiece.isWhite() && this.isWhite()) {  //check if white piece then can't move and can't attack on own
                return false;
            }
            if (possiblesPiece.isBlack() && this.isBlack()) {  //same as for black piece
                return false;
            }
        }
        // Check if the destination tile is the same as your current location.
        if(destination_x == getX()) {
            return false;
        }
        if(destination_y == getY()) {
            return false;
        }
        // Destination is in the same tile but in a higher rank.
        if(Math.abs(destination_x - getX()) < 2 && Math.abs(destination_y - getY()) < 2) {
            return true;
        }
        // Destination is some other tile on the board (can't move there).
        else{
            return false;
        }

        return true;
    }
}