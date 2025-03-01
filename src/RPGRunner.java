
import java.time.DateTimeException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RPGRunner  {
    public final static Logger log = LogManager.getLogger(RPGRunner.class.getName());
    public static void main(String[] args) {
      try {

          Function<String,Integer> f1 = String::length;
          System.out.println(f1.apply("hello"));

          Stats playerSt = new Stats();

          //Consumer Usage
          BiConsumer<String, Integer> setStats = (k, v) -> playerSt.setStat(k, v);

          setStats.accept("HP", 100);
          setStats.accept("MAXHP", 100);
          setStats.accept("Attack", 20);
          setStats.accept("Defense", 30);
          setStats.accept("Magic Power", 10);
          setStats.accept("Stanima", 100);
          setStats.accept("StanimaMax", 100);

          Attacks[] attack = new Attacks[]{
                  new Attacks(AttackTypes.RANGED, "Potion Throw", 10, 1),
                  new Attacks(AttackTypes.RANGED, "Knife Throw", 11,1),
                  new Attacks(AttackTypes.RANGED, "Slingshot", 12, 1),
                  new Attacks(AttackTypes.RANGED, "Rock Throw", 13, 1),
                  new Attacks(AttackTypes.RANGED, "Spear Throw", 500, 1)
          };
       //   System.out.println("Ordered HashMap:");
      //   HashMap<Effects, CharClass> activeEffects = new HashMap<>();
      //   activeEffects.put(new Effects("Poison","does damage over time",5,0,4),new CharClass("Hero", Professions.SOLDIER, 100,playerSt, attack, ClassTypes.WARRIOR));
       //  activeEffects.put(new Effects("Withering","does large damage over a shorter time",10,0,2),new CharClass("Hero", Professions.SOLDIER, 100,playerSt, attack, ClassTypes.WARRIOR));
      //   activeEffects.put(new Effects("Blindness","lowers your accuracy with attacks",0,0,3),new CharClass("Hero", Professions.SOLDIER, 100,playerSt, attack, ClassTypes.WARRIOR));
      //   activeEffects.put(new Effects("Regenerative","does healing over time",0,5,3),new CharClass("Hero", Professions.SOLDIER, 100,playerSt, attack, ClassTypes.WARRIOR));
      //   List<Map.Entry<Effects,CharClass>> sortedEffects = new ArrayList<>(activeEffects.entrySet());
      //   sortedEffects.sort((getEffect1,getEffect2) -> Integer.compare(getEffect2.getKey().getEffectDamage(),getEffect1.getKey().getEffectDamage()));
     //    LinkedHashMap<Effects, CharClass> effects = new LinkedHashMap<>();
     //    for (Map.Entry<Effects, CharClass> entry : sortedEffects) {
     //        effects.put(entry.getKey(), entry.getValue());
     //    }
     //    for (Map.Entry<Effects, CharClass> entry : effects.entrySet()) {
     //        System.out.println(entry.getKey().getEffectName() + " Damage Done " + entry.getKey().getEffectDamage() );
     //    }
          //attacks is used to hold all of the players attacks
          Attacks[] attacks = new Attacks[]{
                  new Attacks(AttackTypes.RANGED, "Potion Throw", 10, 1),
                  new Attacks(AttackTypes.RANGED, "Knife Throw", 11,1),
                  new Attacks(AttackTypes.RANGED, "Slingshot", 12, 1),
                  new Attacks(AttackTypes.RANGED, "Rock Throw", 13, 1),
                  new Attacks(AttackTypes.RANGED, "Spear Throw", 500, 1)
          };
          //npcattacks is used to hold all the npcs attacks
          Attacks[] npcattacks = new Attacks[]{
                  new Attacks(AttackTypes.RANGED, "Potion Throw", 10, 1),
                  new Attacks(AttackTypes.RANGED, "Knife Throw", 11,1),
                  new Attacks(AttackTypes.RANGED, "Slingshot", 12, 1),
                  new Attacks(AttackTypes.RANGED, "Rock Throw", 13, 1),
                  new Attacks(AttackTypes.RANGED, "Spear Throw", 13, 1)
          };
       //   DatabaseLoad dl = new DatabaseLoad();

         // dl.main(args);
          //cretes a new player class to be used within the main runner
          CharClass player;

      //    EmbeddedDataSource ds = new EmbeddedDataSource();
         // System.out.println(dl.getPlayername("Warrior"));
//          ds.setDatabaseName("rpgdata");
//          ds.setCreateDatabase("create");

//          Connection con = ds.getConnection();
//          Statement stmt = con.createStatement();
//          ResultSet rs = stmt.executeQuery("select name,description,ispassive from npc where name = 'Guard'");
//          ResultSet rss = stmt.executeQuery("select name,charmaxstamina from playerclass where name = 'Warrior'");
//          ResultSet playerstatrs = stmt.executeQuery("select name,value from stats where playerclass_id = 1");
//          ResultSet npcstatrs = stmt.executeQuery("select name,value from stats where npc_id = 1");

        //  ResultSet rs = dl.getNPCpassive;
        //  ResultSet rss = stmt.executeQuery("select name,charmaxstamina from playerclass where name = 'Warrior'");
        //  ResultSet playerstatrs = stmt.executeQuery("select name,value from stats where playerclass_id = 1");
         // ResultSet npcstatrs = stmt.executeQuery("select name,value from stats where npc_id = 1");


          //creates stats for npc created
          Stats npcStats = new Stats();
          npcStats.setStat("HP", 100);
          npcStats.setStat("Attack", 10);
          npcStats.setStat("Defense", 25);
          npcStats.setStat("Magic Power", 0);

          Stats npcStats1 = new Stats();
          npcStats1.setStat("HP", 100);
          npcStats1.setStat("Attack", 100);
          npcStats1.setStat("Defense", 25);
          npcStats1.setStat("Magic Power", 0);

          Stats npcStats2 = new Stats();
          npcStats2.setStat("HP", 2000);
          npcStats2.setStat("Attack", 100);
          npcStats2.setStat("Defense", 25);
          npcStats2.setStat("Magic Power", 0);

          System.out.println(npcStats);
          System.out.println(npcStats1);

          //creates the players stats for a selected class
          Stats playerStats = new Stats();
          playerStats.setStat("HP", 10);
          playerStats.setStat("MAXHP", 100);
          playerStats.setStat("Attack", 20);
          playerStats.setStat("Defense", 30);
          playerStats.setStat("Magic Power", 10);
          playerStats.setStat("Stanima", 100);
          playerStats.setStat("StanimaMax", 100);

          System.out.println(playerStats);

          player = new CharClass("Hero", Professions.SOLDIER, 100, playerStats, attacks, ClassTypes.WARRIOR);

       //   ResultSet playerstatrs = dl.getPlayerstats();
        //  while (playerstatrs.next()) {
         //     String statName = playerstatrs.getString("name");
          //    int statValue = playerstatrs.getInt("value");

           //   System.out.println(statName + " : " + statValue);

          //    playerStats.setStat(statName, statValue);
        //  }
          //Npc is used to create the list of enemys/passive entitys within the rpg game
       //   GaurdNPC guard = new GaurdNPC("Gaurd", "a strong warrior", false, npcStats, new HashMap<String, String>() {}, npcattacks);
          Npc shadow = new Npc("Shadow", "a ghost like shadow appears in front of you", false, npcStats1, new HashMap<String, String>() {}, npcattacks);
          Npc goblin = new Npc("Goblin", "a little green monster appears in front of you", false, npcStats2, new HashMap<String, String>() {}, npcattacks);
          Npc guard = new Npc("Guard", "A strong warrior", false, npcStats, new HashMap<String, String>(){}, npcattacks);
          System.out.println(guard);
          System.out.println(shadow);
          System.out.println(goblin);


       //   ResultSet npcstatrs = dl.getNPCstats();
       //  while (npcstatrs.next()) {
       //       npcStats.setStat(npcstatrs.getString("name"), npcstatrs.getInt("value"));
        //  }

          // Adding items to the player
          Item healthPotion = new Item("Health Potion", 5, 0.5, 50, true, false,false, 0);
          Item ironSword = new Item("Iron Sword", 1, 5.0, 100, false, true, true, 0);
          Item manaPotion = new Item("Mana Potion", 1, 0.5, 50, true, false,false, 1);
          Item goldSword = new Item("Gold Sword", 1, 5.0, 100, false, true, true, 0);
          Item strengthPotion = new Item("Strength Potion", 2, 0.5, 50, true, false,false, 1);
          Item grhealthPotion = new Item("Greater Health Potion", 1, 0.5, 50, true, false,false, 3);


          //storedItems is used to hold all the items the player possess at the beggining of the game
          List<Item> storedItems = new ArrayList<>();
          storedItems.add(healthPotion);
          storedItems.add(ironSword);
          storedItems.add(manaPotion);
          storedItems.add(goldSword);
          storedItems.add(strengthPotion);
          storedItems.add(grhealthPotion);
          //stores all items into the players inventory
          for(Item item : storedItems) {
             player.addItem(item);
          }
          // Npcs for world 1
          Npc[] npcs = new Npc[]{
                  guard,
                  shadow,
                  goblin
          };

          //Floors for world 1
          Floor[] floors = new Floor[]{
                  new Floor(npcs)
          };

          //instantiation of world 1
          World world1 = new World(player, 1, floors,false, WorldType.NORMAL);
          //CommandRunner allows the player to use the games interfaces
          CommandRunner game = new CommandRunner(player, world1.getCurrentNpc(), world1);
          game.run();
      }
      catch(ArrayStoreException exception){
          System.err.println("Error: Trying to store the wrong data type in an array");
        }
      catch(DateTimeException exception){
          System.err.println("Error: Receiving an invalid format string for a date");
        }
      catch(MissingResourceException exception){
          System.err.println("Error: Trying to access a key or resource bundle that does not exist");
      }
      catch(NullPointerException exception){
          System.err.println("Error: Trying to store a null data type in an object which can't be null");
          exception.printStackTrace();
      }
      catch(IllegalStateException exception){
          System.err.println("Error: Attempting to run an method which has been passed an ilegal or inapporpriate agrument");
      }
      catch(NumberFormatException exception){
          System.err.println("Error: Invalid number format. Please check the input.");
      }
      catch(ClassCastException exception){
          System.err.println("Error: Invalid type conversion. Ensure correct object types.");
      }
      catch(ArrayIndexOutOfBoundsException exception) {
          System.err.println("Error: Array index out of bounds. Check the array length.");
      }
      catch(Exception exception){
          System.err.println("Error: An unexpected exception occurred: " + exception.getMessage());
          exception.printStackTrace();
      }
    }
}