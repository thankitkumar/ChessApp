package com.pieces;
package com.Board;
public class Knight extends Piece {

    public Knight(int x, int y, boolean is_white, Board board)
    {
        super(x,y,is_white, board);
    }

    @Override
    public boolean legalMove(int destination_x, int destination_y)
    {
        // a knight can move in any L shape and can jump over anyone
        // in order to do so. He cannot attack his own pieces.
        // By an L shape, I mean it can move to a square that is 2 squares away
        // horizontally and 1 square away vertically, or 1 square away horizontally
        // and 2 squares away vertically.
        // some examples:
        //
        //  * *       * * *           *       *
        //  *             *       * * *       *
        //  *                                 * *
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
        // condition for L shape
        if(Math.abs(destination_x - this.getX()) == 2 && Math.abs(destination_y - this.getY()) == 1){
            return true;
        }

        if(Math.abs(destination_x - this.getX()) == 1 && Math.abs(destination_y - this.getY()) == 2){
            return true;
        }
        return false;
    }
}