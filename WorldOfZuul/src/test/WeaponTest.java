package test;
import item.Key;
import item.Weapon;
import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;


public class WeaponTest {
	
	private Weapon myWeapon;

	/**
	 * Default constructor for test class Weapon
	 */
	public WeaponTest()
	{
		
	}
	
	/**
	 * sets up the test fixture.
	 * <p> Initialize one weapon for the test which have their parameters:
	 * 				- name : knife
	 * 				- description :Sharp instrument, consisting of handle with a blade
	 * 				- damages : 50
	 * 				- sell : true
	 * 				- price : 150
	 * 				- oneHandle : true
	 */
	
		@Before
	public void setUp()
	{
		myWeapon = new Weapon ("Knife", "Sharp instrument, consisting of handle with a blade", 50, true, 15, true);	
		
	}
	
	/**
	 * Tears down the test fixture
	 * <p> Called after every test case method. NOthing to do in this case </p>
	 */
	 @After
	 public void tearDown()
	 {
	 }
	 
	 /**
	  * Checks if the name given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testNameKnife()
	 {
		 // The parameter "Knife" must be set as the name attribute
		 assertEquals("Knife", myWeapon.getName());
	 }
	 
	 /**
	  * Checks if the description given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testDescriptionKnife()
	 {
		 // The description must be set as the description attribute
		 assertEquals("Sharp instrument, consisting of handle with a blade", myWeapon.getDescription());
	 }
	 
	 /**
	  * Checks if the price given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testPriceKnife()
	 {
		 // The parameter "50" must be set as the price attribute
		 assertEquals(50, myWeapon.getPrice());
	 }
	 /**
	  * Checks if the boolean sell given  as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testSellKnife()
	 {
		 // The parameter "true" must be set as the boolean sell attribute
		 assertEquals(true, myWeapon.getSellAble());
	 }
	 
	 /**
	  * Checks if the damage given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testDamageKnife()
	 {
		 // The parameter "15" must be set as the damage attribute
		 assertEquals(15, myWeapon.getDamages());
	 }
	 /**
	  * Checks if the boolean handle given as parameter in the constructor is correctly set to the attribute</p>
	  */
	 @Test
	 public void testHandleKnife()
	 {
		 // The parameter "true" must be set as the boolean handle attribute
		 assertEquals(true, myWeapon.getOneHand());
	 }
	 
    /**
     * Method TestBad
     * Test the default parameters
 	 */
	 @Test
	 public void testBadWeapon()
	 {
		    Weapon bad = new Weapon("", "", -10, true, -5, true);
			assertEquals("Unidentified object",bad.getName());
			assertEquals("This object seems strange and come from nowhere.",bad.getDescription());
			assertEquals(100,bad.getPrice());
			assertEquals(2, bad.getDamages());
	 }

}
