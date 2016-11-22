//en cours : anatole

package room;

/**
 * This class manages the door of the room in order to allow a character to move.
 * It can be blocked by a lock and so need a key to open it : subclass LockedDoor
 * Have to check the player move in another place.
 * 
 * @author Group 4
 * @version 10/11/2016
 *
 */
public class Door {
	
	//the next room of the current one, it can exist just one next room
	protected Room nextRoom;

	/**
	 * Constructor of the door class, there is just one room given in parameters
	 */
	public Door(Room room){
		nextRoom = room;
	}
	
	/**
	 * This method returns the next room of the current room.
	 * @return Room
	 */
	public Room getNextRoom(){
		return nextRoom;
	}
}
