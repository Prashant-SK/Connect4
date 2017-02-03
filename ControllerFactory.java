/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp;

     // CLASS: ControllerFactory.java
     //
     //
     // REMARKS: Returns a GameLogic object
     //
     //-----------------------------------------
public class ControllerFactory {

    public static ConnectController makeController(GameDisplay gd) {
        return new GameLogic(gd);
    }
}
