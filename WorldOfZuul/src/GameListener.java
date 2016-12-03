import java.awt.event.*;

import character.Player;
/**
 * This class allows to listen the game interface and to perform actions
 * 
 * @author G4
 * @version 02/12/2016
 */

public class GameListener implements ActionListener {
    
	private Game game;


    /**
     * GameListener constructor
    */   
    public GameListener(Game g) {
        game = g;
    }

    /**
     * Actions performed when actions in game class are listen
     * @param e: The source of the action in the game class
     */
    
    public void actionPerformed(ActionEvent e) {
     
        if (e.getSource() == game.getFrontB())
            game.move("front");
        if (e.getSource() == game.getBehindB())
            game.move("behind");
        if (e.getSource() == game.getRightB())
            game.move("right");
        if (e.getSource() == game.getLeftB())
            game.move("left");
        if (e.getSource() == game.getBagB()) {
        	if (game.getInventoryIsOpen()) {
        		game.openInventory(false);
        		game.setOpenningInventory(false);
        	} else {
        		//the inventory is close, so we can open it
        		game.openInventory(true);
        		game.setOpenningInventory(true);
        	}
        }
        	
    }
    
   }
     
