
package comp;

import java.util.Random;

     // CLASS: EasyAI.java
     //
     // REMARKS: Easy Artificvial Intelligence Engine for the Computer's move
     //
     //-----------------------------------------
public class EasyAI extends GameBoard implements ConnectPlayer {

    private final int LOW = 0;
    private final int HIGH = 6;
    
     //------------------------------------------------------
     // EasyAI
     //
     // PURPOSE:    Constructor for the EasyAI class
     //------------------------------------------------------
    public EasyAI() {
        super();
    }

     //------------------------------------------------------
     // makeMove
     //
     // PURPOSE:    Ads the Human player's move to the board and returns the column
     //             number in which the AI want's to make a move in.
     // PARAMETERS:
     //     lastCol - column number in which the human made the last move
     // RETURNS:
     //     integer representing the column in which the AI wants to make a move in
     //------------------------------------------------------
    @Override
    public int makeMove(int lastCol) {
        super.addMove(lastCol, Status.ONE);
        return aiMove();
    }

     //------------------------------------------------------
     // aiMove
     //
     // PURPOSE:    Returns the column number in which the AI wants to make a move in.
     //             The column number is derived randomly, and the move is added to the board as well.
     // RETURNS:
     //     integer representing the column in which the AI wants to make a move in
     //------------------------------------------------------
    private int aiMove() {
        int col;
        do{
        Random r = new Random();
        col =  r.nextInt(HIGH - LOW) + LOW;
        }
        while (!addAIMove(col));
        return col;
    }
}
