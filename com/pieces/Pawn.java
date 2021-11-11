package com.pieces;
package com.Board;
public class Pawn extends Piece {

    public Pawn(int x, int y, boolean is_white, Board board)
    {
        super(x,y,is_white, board);
    }

    @Override
    public boolean legalMove(int destination_x, int destination_y)
    {
        // A pawn may only move towards the oponent's side of the board.
        // If the pawn has not moved yet in the game, for its first move it can
        // move two spaces forward. Otherwise, it may only move one space.
        // When not attacking it may only move straight ahead.
        // When attacking it may only move space diagonally forward
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

        return true;
    }
}