/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp;

     // CLASS: GameBoard.java
     //
     // REMARKS: A support class to store the moves of the Human and AI. 
     //          Also has methods to check and set coordinates on the board to make a move.
     //
     //-----------------------------------------
public class GameBoard {

    private final Status[][] board;     //board to keep track of Human and AI moves
    private final int WIDTH = 7;
    private final int HEIGHT = 6;

    //------------------------------------------------------
     // Support
     //
     // PURPOSE:    Constructor for the Support class and initializes board. 
     //------------------------------------------------------
    public GameBoard() {
        board = new Status[HEIGHT][WIDTH];
        initializeBoard();
    }

     //------------------------------------------------------
     // initializeBoard()
     //
     // PURPOSE:    Sets all coordinates on the board to NEITHER
     //------------------------------------------------------
    protected void initializeBoard() {
        Status s = Status.NEITHER;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = s;
            }
        }
    }

    //------------------------------------------------------
     // addMove
     //
     // PURPOSE:    Ads a peg to the board in the specefic column
     // PARAMETERS:
     //     col - the column in which to add the peg
     //     s   - The Status of the new peg to be added
     // RETURNS:
     //     integer representing the row in which the peg was added 
     //------------------------------------------------------
    protected int addMove(int col, Status s) {
        int row = 0;
        for (int j = HEIGHT - 1; j >= 0; j--) {
            if (board[j][col] == Status.NEITHER) {
                board[j][col] = s;
                row = j;
                break;
            }
        }
        return row;
    }

     //------------------------------------------------------
     // addAiMove
     //
     // PURPOSE:    Ads the Human AI's move to the board and returns true if
     //             added successfully
     // PARAMETERS:
     //     col - column number in which the AI wants to make a move in 
     // RETURNS:
     //     true if added successfully
     //------------------------------------------------------
    protected boolean addAIMove(int col) {
        boolean added = false;
        for (int j = HEIGHT - 1; j >= 0; j--) {
            if (board[j][col] == Status.NEITHER) {
                board[j][col] = Status.TWO;
                added = true;
                break;
            }
        }
        return added;
    }

     //------------------------------------------------------
     // getHeight
     //
     // PURPOSE:    Getter method for the HEIGHT
     //------------------------------------------------------
    protected int getHeight() {
        return this.HEIGHT;
    }

     //------------------------------------------------------
     // getWidth
     //
     // PURPOSE:    Getter method for the WIDTH
     //------------------------------------------------------
    protected int getWidth() {
        return this.WIDTH;
    }
    
     //------------------------------------------------------
     // getBoard
     //
     // PURPOSE:    Getter method for the board
     // RETURNS:
     //     2-D Status Array representing the current state of the board
     //------------------------------------------------------
    protected Status [][] getBoard(){
        return this.board;
    }

     //------------------------------------------------------
     // checkCoordinate
     //
     // PURPOSE:    checks to see if coordinate is NEITHER
     // PARAMETERS:
     //     row - the row of the coordinate
     //     col - the column of the coordinate
     // RETURNS:
     //     true if coordinate is NEITHER
     //------------------------------------------------------
    protected boolean checkCoordinate(int row, int col) {
        return board[row][col] == Status.NEITHER;
    }
    
     //------------------------------------------------------
     // checkCoordinate
     //
     // PURPOSE:    Set the Coordinate to Status s
     // PARAMETERS:
     //     row - the row of the coordinate
     //     col - the column of the coordinate
     //     s   - the status s
     // RETURNS:
     //     true if coordinate is set successfully
     //------------------------------------------------------
    protected boolean checkCoordinate(int row, int col, Status s){
        return board[row][col] == s;
    }
    
     //------------------------------------------------------
     // getCoordinate
     //
     // PURPOSE:    Get the State of a particular coordinate on the board
     // PARAMETERS:
     //     row - the row of the coordinate
     //     col - the column of the coordinate
     // RETURNS:
     //     the Status of the coordinate
     //------------------------------------------------------
    protected Status getCoordinate(int row, int col){
        return board[row][col];
    }
     //------------------------------------------------------
     // setAIMove
     //
     // PURPOSE:    Set the Coordinate to Status s
     // PARAMETERS:
     //     row - the row of the coordinate
     //     col - the column of the coordinate
     //     s   - the status s
     //------------------------------------------------------
    protected void setAIMove(int row, int col, Status s){
        board[row][col] = s;
    }
}
