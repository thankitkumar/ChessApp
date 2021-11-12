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
        // Pawn can only move in straight line ,if want to move anywhere let them
        if(this.getX() != destination_x && this.getY() != destination_y){ // condition for can't move diagonally
            return false;
        }
        // if current position of piece on x is 2 then move 1 or 2 step
        if( this.getX()==2  && possiblesPiece.isWhite()){
            if(Math.abs(destination_y - getY()) <= 2) {
                return true;
            }
            else{
                return false;
            }

        }
        // check for rest move
        if(this.getX()>2 && possiblesPiece.isWhite()){
            if (Math.abs(destination_y - getY()) == 1){
                return true;
            }
        }
        // if current position of piece on x is 2 then move 1 or 2 step same for black piece
        if( this.getX()==7  && possiblesPiece.isBlack()){
            if(Math.abs(destination_y - getY()) <= 2) {
                return true;
            }
            else{
                return false;
            }

        }
        // check for rest move
        if(this.getX()>2 && possiblesPiece.isBlack()){
            if (Math.abs(destination_y - getY()) == 1){
                return true;
            }
        }

        return true;
    }
}