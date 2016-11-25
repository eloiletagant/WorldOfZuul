package test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import item.Consumable;
import item.Inventory;
import item.Item;
import item.Weapon;
import item.Key;

/**
 * The test class ConsumableTest
 * Unit tests of the Consumable class
 * @author Group4
 * @version 22/11/2016
 *
 */
public class InventoryTest
{
	private Inventory myInventory;
	private ArrayList<Item> myInventory2;
	private Consumable myConsumable;
	private Weapon myWeapon;
	private Key myKey;

	/**
	 * Sets up the test fixture.
	 * Called before every test case method.
	 * Initialize one consumable for each test, whose name is "Bread".
	 */
	@Before
	public void setUp()
	{
		myInventory = new Inventory(10);
		myConsumable=new Consumable("Bread", "This bread was cooked by the baker of the village", 20, true, "This bread get 2 health points to the person who eats it", 0, 3, true);
		myKey=new Key("Key1","This key can open something",0,false);
		myWeapon=new Weapon("Sword","This sword is very helpfull during a fight", 150, true, 5, true);
		myInventory2= new ArrayList<Item>();
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
	 * Method testAddItemsInventory
	 * <p>Checks if items is correctly added in an inventory</p>
	 */
	@Test
	public void testAddItemsInventory()
	{
		myInventory2.add(myConsumable);
		myInventory.addItem(myConsumable);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.add(myWeapon);
		myInventory.addItem(myWeapon);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.add(myKey);
		myInventory.addItem(myKey);
		assertEquals(myInventory2,myInventory.getItems());
	}
	
	/**
	 * Method testDeleteItemsInventory
	 * <p>Checks if items is correctly deleted in an inventory</p>
	 */
	@Test
	public void testDeleteItemsInventory()
	{		
		myInventory2.add(myConsumable);
		myInventory.addItem(myConsumable);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.add(myWeapon);
		myInventory.addItem(myWeapon);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.add(myKey);
		myInventory.addItem(myKey);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.remove(myConsumable);
		myInventory.deleteItem(myConsumable);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.remove(myWeapon);
		myInventory.deleteItem(myWeapon);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.remove(myKey);
		myInventory.deleteItem(myKey);
		assertEquals(myInventory2,myInventory.getItems());
	}
	
	/**
	 * Method testResetItem
	 * <p>Checks if the inventory is correctly clear</p>
	 */
	@Test
	public void testResetItem()
	{
		myInventory2.add(myConsumable);
		myInventory.addItem(myConsumable);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.add(myWeapon);
		myInventory.addItem(myWeapon);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.add(myKey);
		myInventory.addItem(myKey);
		assertEquals(myInventory2,myInventory.getItems());
		myInventory2.clear();
		myInventory.resetInventory();
		assertEquals(myInventory2,myInventory.getItems());
	}
}
