package hunger;

import java.util.ArrayList;
import java.util.Random;

public class Tribute {
	int baseOffense; //base offense
	int baseDefense; //base defense
	int baseIntelligence; //base intel
	int baseFame; //base fame
	
	int offense; //adjusted stats for items and condition
	int defense;
	int intelligence;
	int fame;
	
	String name; //name of player
	int district; //unused but may be used in future
	boolean isAlive; //player is alive or not
	int condition; //condition of player, 10 healthy 0 ded
	int killstreak; //killing streak of player
	
	ArrayList<Item> equips; //list of items
	
	Random r; //rng
	
	boolean hasInteracted; //has player interacted this turn
	
	//TODO: alliance system
	ArrayList<Tribute> allies; //unused
	
	//constructor
	public Tribute(String name, int o, int d, int i, int f) {
		this.name = name;
		this.baseOffense = o;
		this.baseDefense = d;
		this.baseIntelligence = i;
		this.baseFame = f;
		
		
		this.equips = new ArrayList<Item>();
		this.isAlive = true;
		this.condition = 10;
		this.r = new Random();
		this.hasInteracted = false;
		this.killstreak = 0;
		this.allies = new ArrayList<Tribute>();
	}
	
	//refresh stats every day
	public void updateTribute() {
		offense = baseOffense;
		defense = baseDefense;
		intelligence = baseIntelligence;
		fame = baseFame;
		
		for(int i = 0; i < equips.size(); i++) {
			offense += equips.get(i).offense;
			defense += equips.get(i).defense;
			intelligence += equips.get(i).intelligence;
			fame += equips.get(i).fame;
		}
		this.hasInteracted = false;
		if(this.condition > 10) {
			this.condition = 10;
		}
	}
	//kill the player. drops random item on death.
	public Item kill() {
		this.isAlive = false;
		if (equips.size() == 0) {
			return null;
		} else {
			int n = r.nextInt(equips.size());
			return equips.get(n);
		}
	}

}
