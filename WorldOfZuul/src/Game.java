/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.  Users
 * can walk around some scenery. That's all. It should really be extended
 * to make it more interesting!
 * <p>
 * To play this game, create an instance of this class and call the "play"
 * method.
 * <p>
 * This main class creates and initialises all the others: it creates all
 * rooms, creates the parser and starts the game.  It also evaluates and
 * executes the commands that the parser returns.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */

import java.util.ArrayList;
import java.util.HashMap;

import character.Player;
import event.Event;
import room.Door;
import room.Room;
import item.Lock;
import item.Key;

public class Game {
    private Parser parser;
    private Room currentRoom;
    private Player player;
    private ArrayList<Room> rooms;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
    	rooms = new ArrayList<Room>();
        createAllRooms();
        createAllDoors(rooms);
        parser = new Parser();
        play();
    }
    
    public static void main (String[] args){
        new Game();
       }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createAllRooms() {   	
    	int fin=32;
    	for(int i=0; i<=fin; i++){
    		if (i < 14 || i > 29)
    			rooms.add(new Room("Room " + i, 0));
    		else
    			rooms.add(new Room("Room " + i, 1));
    	}
    	currentRoom = rooms.get(0);
    }
    
    private void createAllDoors(ArrayList<Room> rooms){
    	createTwoDoors(rooms.get(0), rooms.get(1) , "front");
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() {
    	player = new Player(parser.getCommand());
        printWelcome();
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul " + player.getName() + " !!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println("You are " + currentRoom.getDescription() + " Level : " + currentRoom.getLevel());
        System.out.print("Exits: ");


        for (HashMap.Entry<String, Door> entry : currentRoom.getDoors().entrySet()) {
            System.out.println(entry.getKey() + " / " + entry.getValue().getNextRoom().getDescription() + " / " + entry.getValue().getNextRoom().getLevel());
        }

        System.out.println();

    }


    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("   go quit help");
    }


    /**
     * method to associate a key and a lock
     * maybe not really useful
     */
    private Lock createLock(String keyName, String keyDescription, int keyPrice, boolean keySellAble) {
        Lock lock = new Lock();
        lock.addKey(new Key(keyName, keyDescription, keyPrice, keySellAble));
        return lock;
    }
    
    /**
     * method to associate a key and a lock
     * maybe not really useful
     */
    private void createTwoDoors(Room room, Room nextRoom, String way) {
    	Door door1 = new Door(nextRoom);
    	room.addExit(door1, way);
    	Door door2 = new Door(room);
    	String oppositeWay;
    	
    	switch (way)
    	{
    	  case "front":
    	    oppositeWay = "behind";
    	    break;  
    	  case "behind":
      	    oppositeWay = "front";
      	    break;
    	  case "right":
      	    oppositeWay = "left";
      	    break;
    	  case "left":
        	oppositeWay = "right";
        	break;
    	  case "upstair":
        	oppositeWay = "downstair";
        	break;
    	  case "downstair":
          	oppositeWay = "upstair";
          	break; 
    	  default:
    		oppositeWay="";
    	    break;             
    	}
    	nextRoom.addExit(door2, oppositeWay);
    }
}
