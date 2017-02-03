/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp;

// CLASS: GameLogic.java
//
// REMARKS: Logic Engine for Connect Four
//
//-----------------------------------------
public class GameLogic extends GameBoard implements ConnectController {

    private final GameDisplay gd;
    private ConnectPlayer cp;
    private final int COMPLEXITY = 2;

    //------------------------------------------------------
    // GameLogic
    //
    // PURPOSE:    Constructor
    // PARAMETERS:
    //     gd - Game Display object
    //------------------------------------------------------
    public GameLogic(GameDisplay gd) {
        super();
        this.gd = gd;
    }
    
    //------------------------------------------------------
    // addPiece
    //
    // PURPOSE:    Ads a piece to the board, checking for wins/draws.
    // PARAMETERS:
    //        col  - the column number the human selected to place his peg into
    // Returns: True if peg added to the board successfully
    //------------------------------------------------------
    @Override
    public boolean addPiece(int col) {
        boolean win;
        super.addMove(col, Status.ONE);
        gd.updateBoard(super.getBoard());
        win = winCheck();
        if (!win) {
            int opp = cp.makeMove(col);
            super.addAIMove(opp);
            gd.updateBoard(super.getBoard());
            winCheck();
        }
        return true;
    }

    //------------------------------------------------------
    // reset
    //
    // PURPOSE:    Set the board and create the right AI object when game begins.
    //------------------------------------------------------
    @Override
    public void reset() {
        int complexity = gd.promptForOpponentDifficulty(COMPLEXITY);
        if (complexity == 2) {
            cp = new HardAI();
        } else {
            cp = new EasyAI();
        }
        super.initializeBoard();
        this.gd.updateBoard(super.getBoard());
    }

    //------------------------------------------------------
    // winCheck
    //
    // PURPOSE:    Check it someone has won the game or there is a draw
    // RETURNS:
    //      True if there is a win in either of the eligible directions
    //------------------------------------------------------
    private boolean winCheck() {
        return (horizontal() || vertical() || diagonalCheck() || draw());
    }

    //------------------------------------------------------
    // horizontal
    //
    // PURPOSE:    Chec if a player has four consecutive pegs in a row and if yes, 
    //             pass it to gameOver()
    // RETURNS:
    //      True if there are four pegs horizontally
    //------------------------------------------------------
    private boolean horizontal() {
        boolean win;
        for (int i = 0; i < super.getHeight(); i++) {
            for (int j = 0; j <= (super.getWidth() / 2); j++) {
                Status s = super.getCoordinate(i, j);
                win = true;
                if (s != Status.NEITHER) {
                    for (int k = j; k <= j + 3; k++) {
                        if (super.getCoordinate(i, k) != s) {
                            win = false;
                        }
                    }
                    if (win) {
                        gd.gameOver(s);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //------------------------------------------------------
    // vertical
    //
    // PURPOSE:    Chec if a player has four consecutive pegs in a column and if yes, 
    //             pass it to gameOver()
    // RETURNS:
    //      True if there are four pegs vertically
    //------------------------------------------------------
    private boolean vertical() {
        boolean win;
        for (int i = 0; i < (super.getHeight() - 3); i++) {
            for (int j = 0; j < super.getWidth(); j++) {
                Status s = super.getCoordinate(i, j);
                win = true;
                if (s != Status.NEITHER) {
                    for (int k = i; k <= i + 3; k++) {
                        if (super.getCoordinate(k, j) != s) {
                            win = false;
                        }
                    }
                    if (win) {
                        gd.gameOver(s);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //------------------------------------------------------
    // diagonalCheck
    //
    // PURPOSE:    Check to see if a player has won diagonally
    // RETURNS:
    //      True if a win has been found in either of the diagonal directions
    //------------------------------------------------------
    private boolean diagonalCheck() {
        return (leftToRight() || rightToLeft());
    }

    //------------------------------------------------------
    // rightToLeft
    //
    // PURPOSE:    Check if a player has four consecutive pegs diagonally, 
    //             going from right to left. If yes, pass it to gameOver()
    // RETURNS:
    //      True if there are four pegs going from right to left of the same color
    //------------------------------------------------------
    private boolean rightToLeft() {
        boolean win;
        for (int i = super.getWidth() - 1; i >= (super.getWidth() / 2); i--) {
            for (int j = 0; j < (super.getHeight() / 2); j++) {
                Status s = super.getCoordinate(j, i);
                win = true;
                if (s != Status.NEITHER) {
                    for (int k = i; k > i - 4; k--) {
                        if (super.getCoordinate(i - (k - j), k) != s) {
                            win = false;
                        }
                    }
                    if (win) {
                        gd.gameOver(s);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //------------------------------------------------------
    // leftToRight
    //
    // PURPOSE:    Check if a player has four consecutive pegs diagonally, 
    //             going from left to right. If yes, pass it to gameOver()
    // RETURNS:
    //      True if there are four pegs going from left to right of the same color
    //------------------------------------------------------
    private boolean leftToRight() {
        boolean win;
        for (int j = 0; j < (super.getHeight() / 2); j++) {
            for (int i = 0; i <= (super.getWidth() / 2); i++) {
                Status s = super.getCoordinate(j, i);
                win = true;
                if (s != Status.NEITHER) {
                    for (int k = 1; k < 4; k++) {//[i+k][k] int k = i+1; k < i + 4; k++
                        if (super.getCoordinate(j + k, i + k) != s) {
                            win = false;
                        }
                    }
                    if (win) {
                        gd.gameOver(s);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //------------------------------------------------------
    // draw
    //
    // PURPOSE:    Check to see if all coordinates on the board are alloted to a player.
    //             If so, then gameOver() is passed NEITHER
    // RETURNS:
    //      True if the game is drawn
    //------------------------------------------------------
    private boolean draw() {
        boolean draw = true;
        for (int i = 0; i < super.getHeight(); i++) {
            for (int j = 0; j < super.getWidth(); j++) {
                if ((super.getCoordinate(i, j) != Status.ONE) || (super.getCoordinate(i, j) != Status.TWO)) {
                    draw = false;
                    break;
                }
            }
        }
        if (draw) {
            gd.gameOver(Status.NEITHER);
            return true;
        }
        return false;
    }
}

