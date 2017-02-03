/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp;

/**
 *
 * @author press
 */
public interface GameDisplay {
    public void gameOver(Status PlayerNumber);
    public void updateBoard(Status[][] board);
    public int promptForOpponentDifficulty(int maxDifficulty);
}
