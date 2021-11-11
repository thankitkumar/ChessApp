package com.pieces;
package com.Board;
public class Rook extends Piece {

    public Rook(int x, int y, boolean is_white, Board board) {
        super(x, y, is_white, board);
    }

    @Override
    public boolean legalMove(int destination_x, int destination_y) {
        // rook can move as many squares as he wants either forward,
        // backward, or sideways without jumping any pieces. He cannot attack
        // his own pieces.

        // if there is a piece at the destination and it is our own , don't let move there
        Piece possiblesPiece = board.getPiece(destination_x, destination_y);//get piece from board
        if (possiblesPiece != null) {
            if (possiblesPiece.isWhite() && this.isWhite()) {  //check if white piece then can't move and can't attack on own
                return false;
            }
            if (possiblesPiece.isBlack() && this.isBlack()) {  //same as for black piece
                return false;
            }
        }
        // Rook can only move in straight line ,if want to move anywhere let them
        if(this.getX() != destination_x && this.getY() != destination_y){ // condition for can't move diagonally
            return false;
        }
        //find direction to we are trying to move
        String  directions = "";
        if(destination_y > this.getY()){
            directions ="south";
        }
        if(destination_y < this.getY()){
            directions ="north";
        }
        if(destination_x > this.getX()){
            directions ="east";
        }
        if(destination_x < this.getX()){
            directions ="west";
        }
        // Rook can't jump any piece
        if(directions.equals("south")){
            int spaceToMove = Math.abs(destination_y -this.getY());
            for(int i = 1; i<spaceToMove ; i++){
                Piece P = board.getPiece(this.getX() , this.getY() +i);// get piece position from board
                                                                    // it get up word because increase in y position
                if( P != null) { // it means its position occupied
                    return false;
                }
            }
        }
        if(directions.equals("north")){
            int spaceToMove = Math.abs(destination_y -this.getY());
            for(int i = 1; i<spaceToMove ; i++){
                Piece P = board.getPiece(this.getX() , this.getY() - i);// get piece position from board ,
                                                                        // it get down word because decrease in y position
                if( P != null) { // it means its position occupied
                    return false;
                }
            }
        }
        if(directions.equals("east")){
            int spaceToMove = Math.abs(destination_x -this.getX());
            for(int i = 1; i<spaceToMove ; i++){
                Piece P = board.getPiece(this.getX() + i , this.getY());// get piece position from board
                if( P != null) { // it means its position occupied
                    return false;
                }
            }
        }
        if(directions.equals("west")){
            int spaceToMove = Math.abs(destination_x -this.getX());
            for(int i = 1; i<spaceToMove ; i++){
                Piece P = board.getPiece(this.getX() - i , this.getY());// get piece position from board
                if( P != null) { // it means its position occupied
                    return false;
                }
            }
        }
        return true;
    }
}