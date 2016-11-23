package character;

/**
 * This class describes and manages a NPC.
 * A NPC can be an enemy or a friend. By default NPC are enemies.
 * He have a name and other parameter of a class Character.
 * A NPC may have more than 2 hands (4 max) it allows him to wear more weapons 
 * A NPC have no HP limit, but he can't heal himself. 
 * His functions are redefined compare to a normal Character to respect this.
 * 
 * @author Groupe4
 * @version 10/11/2016
 *
 */

public class NPC extends Character{
	
	private boolean enemy; //indicate if the NPC is friendly or not 
	
	/**
	 * Function NPC create Character.
	 * @param String name
	 */
	public NPC(String name){
		super(name);
		enemy=true;
	}
	
	/**
	 * This method returns an boolean true if the NPC can fight a character.
	 * Boolean false if the NPC can trade with the character
	 * @return boolean enemy
	 */
	public boolean getEnemy()
	{
		return enemy;
	}
	
	/**
	 * This method is used to modify the enemy attribute in true or false. 
	 */
	public void swapFriendShip()
	{
		
	}
	
	/**
	 * 
	 */
	public void setNbHands(int newNb)
	{
		
	}
	
	/**
	 * 
	 */
	public void addHealth(int hp)
	{
		if
		super.addHealth(hp);
		if(health + hp > 20)
			health = 20;
		else if(health + hp < 0)
			health = 0;
		else 
			health += hp;
	}
}
