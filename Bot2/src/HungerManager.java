package hunger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HungerManager {
	ArrayList<Tribute> players;
	ArrayList<Tribute> deathList;
	
	Random r;
	
	int turn;
	
	//event percentages. add to 100 pls
	public static final int PERSONAL_CHANCE = 40;
	public static final int DOUBLE_CHANCE = 40;
	public static final int TRIPLE_CHANCE = 20;
	public static final int QUADRUPLE_CHANCE = 0;
	
	//sides of dice for chances for each event type.
	public static final int PERSONAL_ROLL = 50;
	public static final int DOUBLE_ROLL = 15;
	public static final int TRIPLE_ROLL = 4;
	public static final int QUADRUPLE_ROLL = 50;
	
	//common items (+4)
	Item hatchet;
	Item bow;
	Item matches;
	Item shield;
	Item book;
	Item kit;
	Item drink;
	Item badge;
	Item tools;
	Item knife;
	
	//rare items (+6)
	Item backpack;
	Item pin;
	Item explosives;
	Item mace;
	Item helmet;
	
	
	
	//legendary items (+8)

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HungerManager h = new HungerManager();
		h.loadGame(); //load stats
		//System.out.println("hi"); (test)
		while(h.playersAlive() > 1) { //while there is no winner
			h.executeDay(); //perform the day
		}
		h.findWinner();
		

	}
	//load game
	public void loadGame() {
		this.players = new ArrayList<Tribute>();
		this.deathList = new ArrayList<Tribute>();
		this.r = new Random();
		this.turn = 0;
		
		//tribute friend set
		 
		Tribute t1 = new Tribute("Tyler", 5, 5, 5, 5);
		Tribute t2 = new Tribute("Dylan", 5, 5, 5, 5);
		Tribute t3 = new Tribute("Drake", 5, 5, 5, 5);
		Tribute t4 = new Tribute("Blake", 5, 5, 5, 5);
		Tribute t5 = new Tribute("Henry", 5, 5, 5, 5);
		Tribute t6 = new Tribute("Chad", 5, 5, 5, 5);
		Tribute t7 = new Tribute("Raven", 5, 5, 5, 5);
		Tribute t8 = new Tribute("Marissa", 5, 5, 5, 5);
		players.add(t1);
		players.add(t2);
		players.add(t3);
		players.add(t4);
		players.add(t5);
		players.add(t6);
		players.add(t7);
		players.add(t8);
		
		
		//test set
		/**
		Tribute test1 = new Tribute("t1", 5, 5, 5, 5);
		Tribute test2 = new Tribute("t2", 5, 5, 5, 5);
		Tribute test3 = new Tribute("t3", 5, 5, 5, 5);
		Tribute test4 = new Tribute("t4", 5, 5, 5, 5);
		Tribute test5 = new Tribute("t5", 5, 5, 5, 5);
		Tribute test6 = new Tribute("t6", 5, 5, 5, 5);
		Tribute test7 = new Tribute("t7", 5, 5, 5, 5);
		Tribute test8 = new Tribute("t8", 5, 5, 5, 5);
		Tribute test9 = new Tribute("t9", 5, 5, 5, 5);
		Tribute test10 = new Tribute("t10", 5, 5, 5, 5);
		Tribute test11 = new Tribute("t11", 5, 5, 5, 5);
		Tribute test12 = new Tribute("t12", 5, 5, 5, 5);
		Tribute test13 = new Tribute("t13", 5, 5, 5, 5);
		Tribute test14 = new Tribute("t14", 5, 5, 5, 5);
		Tribute test15 = new Tribute("t15", 5, 5, 5, 5);
		Tribute test16 = new Tribute("t16", 5, 5, 5, 5);
		Tribute test17 = new Tribute("t17", 5, 5, 5, 5);
		Tribute test18 = new Tribute("t18", 5, 5, 5, 5);
		Tribute test19 = new Tribute("t19", 5, 5, 5, 5);
		Tribute test20 = new Tribute("t20", 5, 5, 5, 5);
		Tribute test21 = new Tribute("t21", 5, 5, 5, 5);
		Tribute test22 = new Tribute("t22", 5, 5, 5, 5);
		Tribute test23 = new Tribute("t23", 5, 5, 5, 5);
		Tribute test24 = new Tribute("t24", 5, 5, 5, 5);
		
		players.add(test1);
		players.add(test2);
		players.add(test3);
		players.add(test4);
		players.add(test5);
		players.add(test6);
		players.add(test7);
		players.add(test8);
		players.add(test9);
		players.add(test10);
		players.add(test11);
		players.add(test12);
		players.add(test13);
		players.add(test14);
		players.add(test15);
		players.add(test16);
		players.add(test17);
		players.add(test18);
		players.add(test19);
		players.add(test20);
		players.add(test21);
		players.add(test22);
		players.add(test23);
		players.add(test24);
		*/
		
		
		//common item stats
		hatchet = new Item("Hatchet", 2, 1, 1, 0);
		bow = new Item("Bow", 3, 0, 0, 1);
		matches = new Item("Matches", 2, 0, 2, 0);
		shield = new Item("Shield", 0, 4, 0, 0);
		book = new Item("Guide", 0, 0, 4, 0);
		kit = new Item("Kit", 1, 1, 1, 1);
		drink = new Item("Drink", 3, 2, -3, 2);
		badge = new Item("Badge", -1, -2, 2, 5);
		tools = new Item("Tools", 1, 0, 3, -4);
		knife = new Item("Knife", 3, 0, 2, -1);
		
		//rare item stats
		backpack = new Item("Backpack", 1, 2, 3, 0);
		pin = new Item("Pin", 1, 1, 1, 3);
		explosives = new Item("Explosives", 4, -1, 3, 0);
		mace = new Item("Mace", 4, 1, -1, 2);
		helmet = new Item("Helmet", 0, 4, 1, 1);
		
		
		
	}
	//count number of players remaining
	public int playersAlive() {
		int count = 0;
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).isAlive) {
				count++;
			}
		}
		return count;
	}
	
	public void executeDay() {
		turn++; //new day
		System.out.println("DAY " + turn);
		
		//shuffle player order
		Collections.shuffle(players);
		
		//have players do stuff
		for(int i = 0; i < players.size(); i++) {
			if(!players.get(i).hasInteracted && players.get(i).isAlive) {
				playerTurn(players.get(i), i);
			}
			
		}
		
		
		
		//update every player
		for(int i = 0; i < players.size(); i++) {
			players.get(i).updateTribute();
			if(players.get(i).condition <= 0 && players.get(i).isAlive) {
				System.out.println(players.get(i).name + " endured too much suffering and collapsed from poor condition.");
				players.get(i).kill();
				deathList.add(players.get(i));
			}
		}
		
		//report deaths for the day
		if(deathList.size() > 0) {
			reportDeaths();
		} else {
			System.out.println("There were no deaths today. Get back to fighting!");
		}
		System.out.println("Tributes remaining: " + playersAlive());
		
		//TODO: interact with user to view stats and pause
		
		
	}
	public void playerTurn(Tribute t1, int index) {
		int e = r.nextInt(100) + 1;
		if(e < PERSONAL_CHANCE) {
			personalEvent(t1);
			t1.hasInteracted = true;
		} else if(e >= PERSONAL_CHANCE && e <= PERSONAL_CHANCE + DOUBLE_CHANCE) {
			if(index >= players.size() - 1 || !players.get(index + 1).isAlive) {
				personalEvent(t1);
				t1.hasInteracted = true;
			} else {
				doubleEvent(t1, players.get(index + 1));
				t1.hasInteracted = true;
				players.get(index + 1).hasInteracted = true;
			}
		} else if (e <= PERSONAL_CHANCE + DOUBLE_CHANCE + TRIPLE_CHANCE) {
			if(index >= players.size() + -2 || !players.get(index + 1).isAlive || !players.get(index + 2).isAlive) {
				personalEvent(t1);
				t1.hasInteracted = true;
			} else {
				tripleEvent(t1, players.get(index + 1), players.get(index + 2));
				t1.hasInteracted = true;
				players.get(index + 1).hasInteracted = true;
				players.get(index + 2).hasInteracted = true;
			}
		} else if (e <= PERSONAL_CHANCE + DOUBLE_CHANCE + TRIPLE_CHANCE + QUADRUPLE_CHANCE) {
			if(index >= players.size() + 1 || !players.get(index + 1).isAlive || !players.get(index + 2).isAlive || !players.get(index + 3).isAlive) {
				personalEvent(t1);
				t1.hasInteracted = true;
			} else {
				quadrupleEvent(t1, players.get(index + 1), players.get(index + 2), players.get(index + 3));
				t1.hasInteracted = true;
				players.get(index + 1).hasInteracted = true;
				players.get(index + 2).hasInteracted = true;
				players.get(index + 3).hasInteracted = true;
			}
		}
	}
	public void personalEvent(Tribute t1) {
		int e = r.nextInt(PERSONAL_ROLL) + 1; //roll
		
		if(e <= 5) {
			if(t1.condition < 5) {
				if(e == 1 || e == 2) {
					System.out.println(t1.name + " commited suicide.");
				}
				if(e == 3 || e == 4) {
					System.out.println(t1.name + " tried to escape the world boundary and got fried.");
					
				}
				
				t1.kill();
				deathList.add(t1);
				return;
			} else {
				if(e == 1 || e == 2) {
					System.out.println(t1.name + " thought about the games and became depressed, worsening their condition.");
					t1.condition -= 5;
				}
				if(e > 2) {
					System.out.println(t1.name + " tripped in the woods and became injured.");
					t1.condition -= 3;
				}
			}
			
		} else if(e < 10) {
			t1.condition += 2;
			if(e <= 15) {
				System.out.println(t1.name + " rested up and regained some of their strength.");
			} else {
				System.out.println(t1.name + " found some first aid supplies and bandaged themselves up.");
			}
			
		} else if(e < 20) {
			if(e == 10) {
				System.out.println(t1.name + " found a stone hatchet and upgraded their offense.");
				t1.equips.add(hatchet);
			}
			if(e == 11) {
				System.out.println(t1.name + " found a bow and upgraded their offense.");
				t1.equips.add(bow);
			}
			if(e == 12) {
				System.out.println(t1.name + " found some matches and upgraded their offensive tactics.");
				t1.equips.add(matches);
			}
			if(e == 13) {
				System.out.println(t1.name + " found a field guide and upgraded their knowledge and preparedness.");
				t1.equips.add(book);
			}
			if(e == 14) {
				System.out.println(t1.name + " found a kit and slightly upgraded all stats.");
				t1.equips.add(kit);
			}
			if(e == 15) {
				System.out.println(t1.name + " found a shield and is well equipped in their defense.");
				t1.equips.add(shield);
			}
			if(e == 16) {
				System.out.println(t1.name + " found a sketchy drink and upgraded their combat skills and the expense of their sobreity.");
				t1.equips.add(drink);
			}
			if(e == 17) {
				System.out.println(t1.name + " found a badge and upgraded their popularity.");
				t1.equips.add(badge);
			}
			if(e == 18) {
				System.out.println(t1.name + " found some farming tools and upgraded their intelligence and survivability at the expense of their popularity.");
				t1.equips.add(tools);
			}
			if(e == 19) {
				System.out.println(t1.name + " found a knife and upgraded their offense and utility.");
				t1.equips.add(knife);
			}
			
		} else if(e < 30) {
			
			if(e == 20 || e == 21) {
				int d = t1.defense;
				if(d < 5) {
					System.out.println(t1.name + " got ran down by a pack of dogs, and was mauled to death.");
					t1.kill();
					deathList.add(t1);
				} else if (d > 7) {
					System.out.println(t1.name + " was attacked by a pack of dogs, but was able to fend them off handily and feed themselves.");
					t1.condition += 2;
				} else {
					System.out.println(t1.name + " was attacked by a pack of dogs and was slightly wounded, but able to get away.");
					t1.condition -= 2;
				}
			}
			if(e == 22 || e == 23) {
				int i = t1.intelligence;
				if(i < 5) {
					System.out.println(t1.name + " became trapped under falling rocks, and died because couldn't figure out how to escape.");
					t1.kill();
					deathList.add(t1);
				} else if (i > 7) {
					System.out.println(t1.name + " almost fell victim to an avalanche, but avoided it with style.");
					t1.condition += 1;
				} else {
					System.out.println(t1.name + " narrowly avoided death to an avalanche.");
					t1.condition -= 4;
				}
			}
			if(e == 24 || e == 25) {
				int o = t1.offense;
				if(o < 5) {
					System.out.println(t1.name + " attempted to go hunting but was actually countered and killed when they tried to attack.");
					t1.kill();
					deathList.add(t1);
				} else if (o > 7) {
					System.out.println(t1.name + " successfully went hunting and fed themselves well.");
					t1.condition += 3;
				} else {
					System.out.println(t1.name + " went hunting and scavenged just enough for sustenance.");
					t1.condition -= 2;
				}
			}
			if(e == 26 || e == 27) {
				int s = t1.defense + t1.intelligence;
				if(s < 10) {
					System.out.println(t1.name + " was attacked by a hooded figure and mysteriously died.");
					t1.kill();
					deathList.add(t1);
				} else if (s > 14) {
					System.out.println(t1.name + " was attacked by a hooded figure, but turned and outsmarted the attacker to survive.");
					t1.condition += 2;
				} else {
					System.out.println(t1.name + " was attacked by a stealthed assassin and narrowly avoided death.");
					t1.condition -= 6;
				}
			}
			if(e == 28 || e == 29) {
				int s = t1.defense;
				if(s < 6) {
					System.out.println(t1.name + " was exploded to death by hidden missiles.");
					t1.kill();
					deathList.add(t1);
				} else if (s > 8) {
					System.out.println(t1.name + " was attacked by missiles from the shadows, but managed to dodge and run away.");
				} else {
					System.out.println(t1.name + " nearly went up in smoke after a bomb but only caught on fire instead.");
					t1.condition -= 6;
				}
			}
			
		} else if(e < 40) {
			if(e < 35) {
				int f = t1.fame;
				if(f < 4) {
					System.out.println("Due to their poor popularity, " + t1.name + " was dropped a care package that combusted in their face, killing them.");
					t1.kill();
					deathList.add(t1);
				} else if (f < 8) {
					System.out.println(t1.name + " spent the day recooperating.");
					t1.condition += 1;
				} else {
					System.out.println(t1.name + " was dropped bountiful food and supplies by their sponsors!");
					t1.condition += 5;
				}
			} else {
				if (t1.killstreak > 2) {
					System.out.println("The sponsors of " + t1.name + " are impressed with their killing spree, and have paid to drop them a powerful helmet!");
					t1.equips.add(helmet);
				} else if (t1.killstreak > 0) {
					System.out.println("The few kills " + t1.name + " has gotten impress their sponsors, but are not enough to satisfy them!");
				} else {
					System.out.println("Disappointed with the passive playstyle of " + t1.name + ", their sponsors have dropped a toxic gas in their vicinity.");
					t1.condition -= 4;
				}
			}
			
		} else if(e < 50) { //meme and equip stuff
			if(e == 40) {
				System.out.println("Depressed from realizing they will never find true love, " + t1.name + " embarks on a journey to find their soulmate.");
				t1.condition -= 2;
			}
			if(e == 41) {
				System.out.println(t1.name + " found a rare backpack with excellent supplies!");
				t1.equips.add(backpack);
			}
			if(e == 42) {
				System.out.println(t1.name + " was chased out of their shelter, losing all their acquired items but staying alive.");
				t1.equips.clear();
			}
			if(e == 43) {
				if(t1.fame > 10) {
					System.out.println(t1.name + "choked to death on their own ego.");
					t1.kill();
					deathList.add(t1);
				} else {
					System.out.println(t1.name + " didn't get any sleep due to paranoia.");
					t1.condition -= 3;
				}
			}
			if(e == 44) {
				System.out.println(t1.name + " discovered their one true love was themselves.");
				
			}
			if(e == 45) {
				System.out.println(t1.name + " became filled with determination.");
				t1.condition += 2;
			}
			if(e == 46) {
				System.out.println(t1.name + " stepped on a mine and ceased to exist.");
				t1.kill();
				deathList.add(t1);
			}
			//more stat checks
			if(e == 47 || e == 48) {
				int i = t1.intelligence;
				if(i < 5) {
					System.out.println(t1.name + " became excessively drunk and fell into a pit to their death.");
					t1.kill();
					deathList.add(t1);
					
				} else if (i < 8) {
					System.out.println(t1.name + " spent the day pondering their existence.");
					
				} else {
					System.out.println(t1.name + " armed their own trap, increasing their security.");
					t1.condition += 3;
				}
			}
			if(e == 49 || e == 50) {
				int d = t1.defense;
				if(d < 6) {
					System.out.println(t1.name + " spent too long in the cold and froze to death.");
					t1.kill();
					deathList.add(t1);
				} else {
					System.out.println(t1.name + " was caught in a snowstorm, but had enough gear to survive this time.");
					t1.condition -= 2;
				}
			}
		//TODO: will be implemented later	
		} else if(e < 60) {
			
		} else if(e < 70) {
			
		}
	}
	
	public void doubleEvent(Tribute t1, Tribute t2) {
		int e = r.nextInt(DOUBLE_ROLL) + 1; //roll
		
		
		//peaceful meetings
		if(e == 1) {
			System.out.println(t1.name + " and " + t2.name + " pooled together their supplies and regained their strength.");
			t1.condition += 2;
			t2.condition += 2;
			
		}
		if(e == 2) {
			System.out.println("Things got steamy today between " + t1.name + " and " + t2.name + ", and both are exhausted.");
			t1.condition -= 2;
			t2.condition -= 2;
			
		}
		if(e == 3) {
			System.out.println("As a peace offering between their districts, " + t1.name + " gave all their supplies and equipment to " + t2.name + ".");
			for(int i = 0; i < t1.equips.size(); i++) {
				t2.equips.add(t1.equips.get(i));
			}
			t1.equips.clear();
		}
		if(e == 4) {
			System.out.println(t1.name + " found " + t2.name + " bleeding out on the ground, and rushed to save them.");
			t2.condition -= 4;
		}
		if(e == 5) {
			System.out.println(t1.name + " and " + t2.name + " jumped off a waterfall together to end their suffering.");
			t1.kill();
			t2.kill();
			deathList.add(t1);
			deathList.add(t2);
		}
		//ambush and killings
		if(e == 6) {
			System.out.println(t1.name + " was ambushed and killed by " + t2.name + ".");
			Item i = t1.kill();
			if(i != null) {
				System.out.println(t2.name + " stole a " + i.name + " off the body of " + t1.name + "!");
				t2.equips.add(i);
			}
			//t1.kill();
			deathList.add(t1);
			t2.killstreak++;
		}
		if(e == 7) {
			System.out.println(t1.name + " set up a trap with bait for " + t2.name + ", finding them and slitting their throat from behind.");
			Item i = t2.kill();
			if(i != null) {
				System.out.println(t1.name + " stole a " + i.name + " off the body of " + t2.name + "!");
				t1.equips.add(i);
			}
			deathList.add(t2);
			t1.killstreak++;
			
		}
		if(e == 8) {
			if(t1.killstreak > 0) {
				System.out.println(t2.name + " got revenge for their friend by assassinating " + t1.name + ".");
				Item i = t1.kill();
				if(i != null) {
					System.out.println(t2.name + " stole a " + i.name + " off the body of " + t1.name + "!");
					t2.equips.add(i);
				}
				deathList.add(t1);
			} else if (t2.killstreak > 0) {
				System.out.println(t1.name + " got revenge for their friend by assassinating " + t2.name + ".");
				Item i = t2.kill();
				if(i != null) {
					System.out.println(t1.name + " stole a " + i.name + " off the body of " + t2.name + "!");
					t1.equips.add(i);
				}
				deathList.add(t2);
			} else {
				System.out.println(t1.name + " and " + t2.name + " narrowly missed each other in tall grass.");
			}
		}
		if(e == 9) {
			System.out.println(t1.name + " tried to make friends with " + t2.name + ", but was backstabbed.");
			Item i = t1.kill();
			if(i != null) {
				System.out.println(t2.name + " stole a " + i.name + " off the body of " + t1.name + "!");
				t2.equips.add(i);
			}
			deathList.add(t1);
		}
		
		
		//stat checks
		
		if(e == 10 || e == 11) {
			if(t1.offense > t2.offense) {
				System.out.println(t1.name + " triumphed in a duel to the death over " + t2.name + " thanks to their superior strength.");
				Item i = t2.kill();
				if(i != null) {
					System.out.println(t1.name + " stole a " + i.name + " off the body of " + t2.name + "!");
					t1.equips.add(i);
				}
				deathList.add(t2);
			} else if (t2.offense > t1.offense) {
				System.out.println(t2.name + " triumphed in a duel to the death over " + t1.name + " thanks to their superior strength.");
				Item i = t1.kill();
				if(i != null) {
					System.out.println(t2.name + " stole a " + i.name + " off the body of " + t1.name + "!");
					t2.equips.add(i);
				}
				deathList.add(t1);
			} else {
				System.out.println(t1.name + " and " + t2.name + " had a duel of strength, but were equally matched and both escaped.");
				t1.condition -= 2;
				t2.condition -= 2;
			}
		}
		
		if(e == 12) {
			if(t1.defense > t2.defense) {
				System.out.println(t1.name + " triumphed in a duel to the death over " + t2.name + " thanks to their superior defense.");
				Item i = t2.kill();
				if(i != null) {
					System.out.println(t1.name + " stole a " + i.name + " off the body of " + t2.name + "!");
					t1.equips.add(i);
				}
				deathList.add(t2);
			} else if (t2.defense > t1.defense) {
				System.out.println(t2.name + " triumphed in a duel to the death over " + t1.name + " thanks to their superior defense.");
				Item i = t1.kill();
				if(i != null) {
					System.out.println(t2.name + " stole a " + i.name + " off the body of " + t1.name + "!");
					t2.equips.add(i);
				}
				deathList.add(t1);
			} else {
				System.out.println(t1.name + " and " + t2.name + " had a duel of attrition, but were equally matched and both escaped.");
				t1.condition -= 2;
				t2.condition -= 2;
			}
		}
		
		if(e == 13) {
			if(t1.intelligence > t2.intelligence) {
				System.out.println(t1.name + " triumphed in a duel to the death over " + t2.name + " thanks to their superior tactics.");
				Item i = t2.kill();
				if(i != null) {
					System.out.println(t1.name + " stole a " + i.name + " off the body of " + t2.name + "!");
					t1.equips.add(i);
				}
				deathList.add(t2);
			} else if (t2.intelligence > t1.intelligence) {
				System.out.println(t2.name + " triumphed in a duel to the death over " + t1.name + " thanks to their superior tactics.");
				Item i = t1.kill();
				if(i != null) {
					System.out.println(t2.name + " stole a " + i.name + " off the body of " + t1.name + "!");
					t2.equips.add(i);
				}
				deathList.add(t1);
			} else {
				System.out.println(t1.name + " and " + t2.name + " had a duel of tactics, but were equally matched and both escaped.");
				t1.condition -= 2;
				t2.condition -= 2;
			}
		}
		
		if(e == 14) {
			if(t1.intelligence + t2.intelligence > 12) {
				System.out.println(t1.name + " and " + t2.name + " found a map of the arena and raised their prepardness.");
				t1.condition += 3;
				t2.condition += 3;
			} else {
				System.out.println(t1.name + " and " + t2.name + " became trapped under falling rocks and only narrowly escaped together.");
				t1.condition -= 4;
				t2.condition -= 4;
			}
			
		}
		if(e == 15) {
			if(t1.fame + t2.fame > 12) {
				System.out.println("The sponsors of " + t1.name + " and " + t2.name + " paid to drop supply kits for them.");
				t1.equips.add(kit);
				t2.equips.add(kit);
			} else {
				System.out.println(t1.name + " and " + t2.name + " are failing to live up to their sponsors, and feel the pressure.");
				t1.condition -= 2;
				t2.condition -= 2;
			}
			
		}
		
		
		//TODO: more team interactions
	}
	
	public void tripleEvent(Tribute t1, Tribute t2, Tribute t3) {
		
		int e = r.nextInt(TRIPLE_ROLL) + 1; //roll
		
		//friendly
		if(e == 1) {
			System.out.println(t1.name + ", " + t2.name + ", and " + t3.name + " set up a campfire for the night.");
			t1.condition += 2;
			t2.condition += 2;
			t3.condition += 2;
			
		}
		if(e == 2) {
			System.out.println(t1.name + ", " + t2.name + ", and " + t3.name + " had a standoff that led to no blood shed.");
		}
		if(e == 3) {
			System.out.println("While out for a walk, " + t1.name + ", " + t2.name + ", and " + t3.name + " all found various equipment.");
			t1.equips.add(hatchet);
			t2.equips.add(bow);
			t3.equips.add(shield);
		}
		if(e == 4) {
			System.out.println(t1.name + " decided to cheat on " + t2.name + " with " + t3.name + ", heavily damaging the morale of " + t2.name + ".");
			t2.condition -= 4;
		}
		
		//TODO: more triples interactions
	}
	
	public void quadrupleEvent(Tribute t1, Tribute t2, Tribute t3, Tribute t4) {
		//TODO: quadruples interactions
	}
	
	public void reportDeaths() {
		if(deathList.size() == 1) {
			System.out.println(deathList.get(0).name + " died today.");
			deathList.remove(0);
		} else if (deathList.size() == 2) {
			System.out.println(deathList.get(0).name + " and " + deathList.get(1).name + " died today.");
			deathList.remove(1);
			deathList.remove(0);
		} else {
			String report = "";
			while(deathList.size() > 0) {
				if(deathList.size() > 1) {
					report += deathList.get(0).name + ", ";
				} else {
					report += "and " + deathList.get(0).name + " died today.";
				}
				
				//System.out.println(name + " died today.");
				players.remove(deathList.get(0));
				deathList.remove(0);
				
			}
			System.out.println(report);
			
			
		}
		
		
	}
	
	public void findWinner() {
		String name = "";
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).isAlive) {
				name = players.get(i).name;
				break;
			}
		}
		if(name.equals("")) {
			System.out.println("Everyone's dead! No one won the game!");
		} else {
			System.out.println(name + " has won the game!");
		}
		
	}

}
