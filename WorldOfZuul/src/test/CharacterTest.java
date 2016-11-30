package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import character.Character;
import room.Room;

public class CharacterTest
{

	private Character c1;
	private Room firstRoom, secondRoom;
	
	/**
	 * Initialize the character with the name "pseudo"
	 */
	@Before
	public void setUp()
	{
		c1 = new Character("Pseudo");
	}
	
	/**
	 * Tears down the test fixture.
	 * Called after every test case method. Nothing to do in this case.
	 */
	@After
	public void tearDown()
	{
	}
	
	/**
	 * Method testCharacterEmptyName
	 * <p>test the constructor with the default value "Kaamelott"</p>
	 */
	@Test
	public void testCharacterEmptyName()
	{
		Character c2 = new Character("");
		assertEquals(c2.getName(), "Kaamelott");	
	}
	
	/**
	 * Method testCharacter
	 * <p>test the constructor with the setUp value</p>
	 */
	@Test
	public void testCharacter()
	{
		assertEquals(c1.getName(), "Pseudo");
	}
	
	/**
	 * Method  testMoveRoom
	 * <p>Test if the character success to move to another room</p>
	 */
	@Test
	public void testMoveRoom() 
	{
		firstRoom = new Room("test1",0);
		c1.moveRoom(firstRoom);
		assertEquals(firstRoom,c1.getLocation());
		secondRoom = new Room("test2",1);
		c1.moveRoom(secondRoom);
		secondRoom = c1.getLocation(); 
		assertEquals(secondRoom, c1.getLocation());
	}
	 
	/**
	 * Method testSetHealth
	 * <p>This method test that a player's hp will never go out of [0/MaxHp]</p>
	 * <p>It also test if the health is correctly modified</p>
	 */
	@Test
	public void testManageHealth() 
	{
		c1.manageHealth(21);
		assertEquals(20,c1.getHealth());
		c1.manageHealth(-21);
		assertEquals(0,c1.getHealth());
		c1.manageHealth(10);
		assertEquals(10,c1.getHealth());
		c1.manageHealth(-5);
		assertEquals(5,c1.getHealth());
	}

	/**
	 * Method testSwapWeapon
	 * <p>This method test if the number of hands will never go out of [0,MaxHands].</p>
	 * <p>Overwise, the number of available hands will be modified and the method will return true </p>
	 */
	@Test
	public void testSwapWeapon()
	{
		c1.swapWeapon(c1.getMaxHands() + 1);
		assertEquals(c1.getNbHandsAvailable(),c1.getMaxHands());
		c1.swapWeapon(-(c1.getMaxHands()+1));
		assertEquals(c1.getNbHandsAvailable(),c1.getMaxHands());
		c1.swapWeapon(-c1.getMaxHands());
		assertEquals(c1.getNbHandsAvailable(),0);
		c1.swapWeapon(c1.getMaxHands()/2);
		assertEquals(c1.getNbHandsAvailable(),c1.getMaxHands()/2);
		c1.swapWeapon(1);
		assertEquals(c1.getNbHandsAvailable(),(c1.getMaxHands()/2) + 1);
		c1.swapWeapon(-1);
		assertEquals(c1.getNbHandsAvailable(),c1.getMaxHands()/2);
	}
	
	/**
	 * Method testManageBonusDamages
	 * <p>This method test if the bonus damages are well applied and if it don't go out of [-5,5]</p>
	 */
	public void testManageBonusDamages()
	{
		c1.manageBonusDamages(6);
		assertEquals(5,c1.getBonusDamages());
		c1.manageBonusDamages(-11);
		assertEquals(-5,c1.getBonusDamages());
		c1.manageBonusDamages(5);
		assertEquals(0,c1.getBonusDamages());
		c1.manageBonusDamages(-1);
		assertEquals(-1,c1.getBonusDamages());
	}
}
