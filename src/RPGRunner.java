import java.time.DateTimeException;
import java.time.Instant;
import java.util.MissingResourceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RPGRunner  {

    public final static Logger log = LogManager.getLogger(RPGRunner.class.getName());
    public static void main(String[] args) {
      try {
          Attacks[] attacks = new Attacks[]{
                  new Attacks(AttackTypes.RANGED, "Potion Throw", 10, 1),
                  new Attacks(AttackTypes.RANGED, "Knife Throw", 11,1),
                  new Attacks(AttackTypes.RANGED, "Slingshot", 12, 1),
                  new Attacks(AttackTypes.RANGED, "Rock Throw", 13, 1),
                  new Attacks(AttackTypes.RANGED, "Spear Throw", 14, 1)
          };
          Attacks[] npcattacks = new Attacks[]{
                  new Attacks(AttackTypes.RANGED, "Potion Throw", 10, 1),
                  new Attacks(AttackTypes.RANGED, "Knife Throw", 11,1),
                  new Attacks(AttackTypes.RANGED, "Slingshot", 12, 1),
                  new Attacks(AttackTypes.RANGED, "Rock Throw", 13, 1),
                  new Attacks(AttackTypes.RANGED, "Spear Throw", 14, 1)
          };

          CharClass player;
          Stats npcStats = new Stats();
          npcStats.setStat("HP", 100);
          npcStats.setStat("Attack", 10);
          npcStats.setStat("Defense", 25);
          npcStats.setStat("Magic Power", 0);
          Stats playerStats = new Stats();
          playerStats.setStat("HP", 100);
          playerStats.setStat("MAXHP", 100);
          playerStats.setStat("Attack", 20);
          playerStats.setStat("Defense", 30);
          playerStats.setStat("Magic Power", 10);
          playerStats.setStat("Stanima", 100);
          playerStats.setStat("StanimaMax", 100);
          player = new CharClass("Hero", Professions.POTION_MAKER, 100, playerStats, attacks);
          Npc guard = new Npc("Guard", "A strong warrior", false, npcStats, new HashMap<String, String>(){}, npcattacks);

          // Adding items to the player
          Item healthPotion = new Item("Health Potion", 1, 0.5, 50, true, false,false);
          Item ironSword = new Item("Iron Sword", 1, 5.0, 100, false, true, true);
          player.addItem(healthPotion);
          player.addItem(ironSword);

          // Npcs for world 1
          Npc[] npcs = new Npc[]{
                  guard
          };

          //Floors for world 1
          Floor[] floors = new Floor[]{
                  new Floor(npcs)
          };

          //instantiation of world 1
          World world1 = new World(player, 1, floors,false, WorldType.NORMAL);

          CommandRunner game = new CommandRunner(player, guard, world1);
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
      }
    }
}