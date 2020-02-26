package testPack;
/**
 * 
 */

/**
 * @author agerh
 *
 */
public class Invader {
	
	int maxHP;
	int currentHP;
	int damage;
	int strifeamount;

	/**
	 * 
	 */
	public Invader(String invaderType) {
		switch(invaderType) {
			case "Explorer":
				maxHP = 1;
				damage = 1;
				break;
			case "Town":
				maxHP = 2;
				damage = 2;
				break;
				
			case "City":
				maxHP = 3;
				damage = 3;
				
				break;
			default:
				System.out.println("error, type: " + invaderType + " is not a valid type of invader");
		}
		strifeamount = 0;
		currentHP = maxHP;
	}
	
	public void setmaxHP(int hpMod) {
		maxHP = hpMod;
	}	
	public int getmaxHP(int hpMod) {
		return maxHP;
	}
	
	public void setcurrentHP(int currenthpMod) {
		currentHP = currenthpMod;
	}	
	public int getcurrentHP(int currenthpMod) {
		return currentHP;
	}
	
	public void setdamage(int damageMod) {
		damage = damageMod;
	}	
	public int getdamage(int damageMod) {
		return damage;
	}
	
	public void addStrife() {
		strifeamount +=1;
	}	
	public void removeStrife() {
		if(strifeamount >= 1)
			strifeamount -= 1;
	}
	


	


	/**
	 * @param args
	 */


}
