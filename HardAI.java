/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp;

     // CLASS: HardAI.java
     //
     // REMARKS: Hard Artificvial Intelligence Engine for the Computer's move
     //
     //-----------------------------------------
public class HardAI extends GameBoard implements ConnectPlayer {

     //------------------------------------------------------
     // HardAI
     //
     // PURPOSE:    Constructor for the HardAI class
     //------------------------------------------------------ 
    public HardAI() {
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
     //             The AI tries to place a Yellow Peg on top of or beside wherever it finds red 
     //             pegs, and the move is added to the board as well. 
     // RETURNS:
     //     integer representing the column in which the AI wants to make a move in
     //------------------------------------------------------
    private int aiMove() {
        int col = 0;
        for (int i = super.getHeight() - 1; i > 0; i--) {
            for (int j = 1; j <= super.getWidth() - 2; j++) {
                if((super.checkCoordinate(i, j, Status.ONE)) && ((super.checkCoordinate(i, j+1, Status.NEITHER)))){
                    super.setAIMove(i, j+1, Status.TWO);
                    col = j+1;
                    break;
                }
                else if((super.checkCoordinate(i, j, Status.ONE)) && (super.checkCoordinate(i-1, j, Status.NEITHER))){
                    super.setAIMove(i-1, j, Status.TWO);
                    col = j;
                    break;
                }
                else if((super.checkCoordinate(i, j, Status.ONE)) && (super.checkCoordinate(i, j-1, Status.NEITHER))){
                    super.setAIMove(i, j-1, Status.TWO);
                    col = j-1;
                    break;
                }
                else if((super.checkCoordinate(i, j+1, Status.ONE)) && (super.checkCoordinate(i, j, Status.NEITHER))){
                    super.setAIMove(i, j, Status.TWO);
                    col = j;
                    break;
                }
            }
        }
        return col;
    }
}
