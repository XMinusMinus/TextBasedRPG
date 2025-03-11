
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.DateTimeException;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RPGRunner  {
    public final static Logger log = LogManager.getLogger(RPGRunner.class.getName());

    public static void main(String[] args) {
      try {
          //CharClass player = null;
          CharClass player = loadCharacter();
          Function<String,Integer> f1 = String::length;

          Stats playerSt = new Stats();

          //Consumer Usage
          BiConsumer<String, Integer> setStats = (k, v) -> playerSt.setStat(k, v);

          setStats.accept("HP", 100);
          setStats.accept("MAXHP", 100);
          setStats.accept("Attack", 20);
          setStats.accept("Defense", 30);
          setStats.accept("Magic Power", 10);
          setStats.accept("Stamina", 100);
          setStats.accept("StaminaMax", 100);

          Attacks[] attack = new Attacks[]{
                  new Attacks(AttackTypes.RANGED, "Potion Throw", 10, 1,10),
                  new Attacks(AttackTypes.RANGED, "Knife Throw", 11,1,5),
                  new Attacks(AttackTypes.RANGED, "Slingshot", 12, 1,10),
                  new Attacks(AttackTypes.RANGED, "Rock Throw", 13, 1,5),
                  new Attacks(AttackTypes.RANGED, "Spear Throw", 500, 1,5)
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

          //npcattacks is used to hold all the npcs attacks
          Attacks[] npcattacks = new Attacks[]{
                  new Attacks(AttackTypes.RANGED, "Potion Throw", 10, 1,5),
                  new Attacks(AttackTypes.RANGED, "Knife Throw", 11,1,5),
                  new Attacks(AttackTypes.RANGED, "Slingshot", 12, 1,5),
                  new Attacks(AttackTypes.RANGED, "Rock Throw", 13, 1,5),
                  new Attacks(AttackTypes.RANGED, "Spear Throw", 13, 1,5)
          };
       //   DatabaseLoad dl = new DatabaseLoad();

         // dl.main(args);
          //cretes a new player class to be used within the main runner


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

          //creates the players stats for a selected class
          Stats playerStats = new Stats();
          playerStats.setStat("HP", 100);
          playerStats.setStat("MAXHP", 100);
          playerStats.setStat("Attack", 20);
          playerStats.setStat("Defense", 30);
          playerStats.setStat("Magic Power", 10);
          playerStats.setStat("Stamina", 100);
          playerStats.setStat("StaminaMax", 100);

          //creates stats for npc created
          Stats npcStatsW2 = new Stats();
          npcStatsW2.setStat("HP", 100);
          npcStatsW2.setStat("Attack", 10);
          npcStatsW2.setStat("Defense", 25);
          npcStatsW2.setStat("Magic Power", 0);

          Stats npcStats1W2 = new Stats();
          npcStats1W2.setStat("HP", 100);
          npcStats1W2.setStat("Attack", 100);
          npcStats1W2.setStat("Defense", 25);
          npcStats1W2.setStat("Magic Power", 0);

          Stats npcStats2W2 = new Stats();
          npcStats2W2.setStat("HP", 2000);
          npcStats2W2.setStat("Attack", 100);
          npcStats2W2.setStat("Defense", 25);
          npcStats2W2.setStat("Magic Power", 0);

          //attacks is used to hold all of the players attacks
          Attacks[] attacks = new Attacks[]{
                  new Attacks(AttackTypes.RANGED, "Potion Throw", 10, 1,5),
                  new Attacks(AttackTypes.RANGED, "Knife Throw", 11,1,5),
                  new Attacks(AttackTypes.RANGED, "Slingshot", 12, 1,5),
                  new Attacks(AttackTypes.RANGED, "Rock Throw", 13, 1,5),
                  new Attacks(AttackTypes.RANGED, "Spear Throw", 500, 1,5)
          };

         // System.out.println(playerStats);

        //  player = new CharClass("Hero", Professions.SOLDIER, 100, playerStats, attacks, ClassTypes.WARRIOR);

          // Adding items to the player
          Item healthPotion = new HealthPotionItem("Health Potion", 5, 0.5, 50, true, false,false, 0);
          Item ironSword = new IronSwordItem("Iron Sword", 1, 5.0, 100, false, true, true, 0,AttackTypes.MELEE,20);
          Item golddagger = new GoldenDaggerItem("Gold Dagger", 1, 0.5, 50, false, false,false, 1,AttackTypes.MELEE,20);
          Item sheild = new ShieldOfHonorItem("Sheild of Honor", 1, 5.0, 100, false, true, true, 0,AttackTypes.MELEE,20);
          Item staminaPotion = new StaminaPotionItem("Stamina Potion", 2, 0.5, 50, true, false,false, 1);
          Item defenseCrystal = new DefenseCrystalEquippable("Defense Crystal", 1, 0.5, 50, false, false,false, 3);
          Item zweihander = new ZweihanderItem("Zweihander", 1, 5.0, 100, false, true, true, 0,AttackTypes.MELEE,20);
          Item evilpotion = new EvilElixerItem("Evil Potion", 2, 0.5, 50, true, false,false, 1);
          Item ragegloves = new RageGloveItem("Rage Gloves", 1, 0.5, 50, false, false,false, 3);
          Item attackCrystal = new AttackCrystalItem("Attack Crystal", 1, 0.5, 50, false, false,false, 3);



          //storedItems is used to hold all the items the player possess at the beggining of the game
          List<Item> storedItems = new ArrayList<>();
          storedItems.add(healthPotion);
          storedItems.add(ironSword);
          storedItems.add(golddagger);
          storedItems.add(sheild);
          storedItems.add(staminaPotion);
          storedItems.add(defenseCrystal);
          storedItems.add(zweihander);
          storedItems.add(evilpotion);
          storedItems.add(ragegloves);
          storedItems.add(attackCrystal);
          //stores all items into the players inventory
          //for(Item item : storedItems) {
           //   player.addItem(item);
          //}

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

          Npc shadowW2 = new Npc("ShadowW2", "a ghost like shadow appears in front of you", false, npcStats1W2, new HashMap<String, String>() {}, npcattacks);
          Npc goblinW2 = new Npc("GoblinW2", "a little green monster appears in front of you", false, npcStats2W2, new HashMap<String, String>() {}, npcattacks);
          Npc guardW2 = new Npc("GuardW2", "A strong warrior", false, npcStatsW2, new HashMap<String, String>(){}, npcattacks);


       //   ResultSet npcstatrs = dl.getNPCstats();
       //  while (npcstatrs.next()) {
       //       npcStats.setStat(npcstatrs.getString("name"), npcstatrs.getInt("value"));
        //  }


          // Npcs for world 1
          Npc[] npcs = new Npc[]{
                  guard,
                  shadow,
                  goblin
          };

          Npc[] npcsW2 = new Npc[]{
                  guardW2,
                  shadowW2,
                  goblinW2
          };

          //Floors for world 1
          Floor[] floors = new Floor[]{
                  new Floor(npcs)
          };

          Floor[] floorsW2 = new Floor[]{
                  new Floor(npcsW2)
          };

          //instantiation of world 1
          World world1 = new World(player, 1, floors,false, WorldType.NORMAL, 1);
          //CommandRunner allows the player to use the games interfaces

          World world2 = new World(player, 1, floorsW2, false, WorldType.NORMAL, 2);

          World[] worlds = new World[]{
                  world1,
                  world2
          };

          CommandRunner game = new CommandRunner(player, world1.getCurrentNpc(), worlds);
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
    public static CharClass loadCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to load a character file (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        //runs the defualt character if no character was selected
        if (!response.equals("yes")) {
            System.out.println("No character file was loaded.");
            return null;
        }
        String currentDirectory = new File("").getAbsolutePath();

        File charactersFolder = new File(currentDirectory + File.separator + "src"+File.separator+"Characters");
       System.out.println(charactersFolder);

       //runs an error if character folder does not exist
        if (!charactersFolder.exists() || !charactersFolder.isDirectory()) {
            System.out.println("Error: 'Characters' folder not found.");
            return null;
        }

        // Get all character files
        File[] characterFiles = charactersFolder.listFiles((dir, name) -> name.endsWith(".txt"));

        // Check if there are any character files
        if (characterFiles == null || characterFiles.length == 0) {
            System.out.println("No character files found in the 'Characters' folder.");
            return null;
        }

        // Display available character files
        System.out.println("Available characters:");
        for (File file : characterFiles) {
            System.out.println("- " + file.getName().replace(".txt", "")); // Show name without .txt
        }

        // Ask user to enter the character name
        System.out.print("Enter the name of the character you want to load: ");
        String characterName = scanner.nextLine().trim();

        // Find the corresponding file
        File selectedFile = null;
        for (File file : characterFiles) {
            if (file.getName().equalsIgnoreCase(characterName + ".txt")) {
                selectedFile = file;
                break;
            }
        }

        // Handle case where no matching file is found
        if (selectedFile == null) {
            System.out.println("Error: Character file not found.");
            return null;
        }

        System.out.println("Loading character from: " + selectedFile.getName());

        try {
            CharClass player = parseCharacterFile(selectedFile);
            System.out.println("Character loaded successfully: " + player.GetName());
            return player;
        } catch (IOException e) {
            System.err.println("Error loading character file: " + e.getMessage());
            return null;
        }
    }

    //reads the character file informaiton
    private static CharClass parseCharacterFile(File file) throws IOException{
     List<String> lines = Files.readAllLines(file.toPath());
     Stats playerStats = new Stats();
     List<Attacks> attacks = new ArrayList<>();
     List<Item> storedItems = new ArrayList<>();

     String name = "Hero";
     Professions professions = Professions.SOLDIER;
     ClassTypes classTypes = ClassTypes.WARRIOR;
     boolean readingAttacks = false;
     boolean readingItems = false;

     for(String line : lines){
         line = line.trim();
         if(line.isEmpty());
         //if and else if are used to read each line if values exist in them
         if(line.startsWith("Name:")){
             name = line.split(":")[1].trim();
         }
         else if (line.startsWith("Profession:")) {
             professions = Professions.valueOf(line.split(":")[1].trim().toUpperCase());
         }
         else if (line.startsWith("Class:")) {
             classTypes = ClassTypes.valueOf(line.split(":")[1].trim().toUpperCase());
         }
         else if (line.startsWith("HP:")) {
             playerStats.setStat("HP", Integer.parseInt(line.split(":")[1].trim()));
         } else if (line.startsWith("MAXHP:")) {
             playerStats.setStat("MAXHP", Integer.parseInt(line.split(":")[1].trim()));
         } else if (line.startsWith("Attack:")) {
             playerStats.setStat("Attack", Integer.parseInt(line.split(":")[1].trim()));
         } else if (line.startsWith("Defense:")) {
             playerStats.setStat("Defense", Integer.parseInt(line.split(":")[1].trim()));
         } else if (line.startsWith("Magic Power:")) {
             playerStats.setStat("Magic Power", Integer.parseInt(line.split(":")[1].trim()));
         } else if (line.startsWith("Stamina:")) {
             playerStats.setStat("Stamina", Integer.parseInt(line.split(":")[1].trim()));
         } else if (line.startsWith("StaminaMax:")) {
             playerStats.setStat("StaminaMax", Integer.parseInt(line.split(":")[1].trim()));
         } else if (line.equalsIgnoreCase("Attacks:")) {
             readingAttacks = true;
             readingItems = false;
         } else if (line.equalsIgnoreCase("Items:")) {
             readingAttacks = false;
             readingItems = true;
         } else if (readingAttacks) {
             String[] parts = line.split(",");
             if (parts.length == 4) {
                 String attackName = parts[0].trim();
                 AttackTypes type = AttackTypes.valueOf(parts[1].trim().toUpperCase());
                 int damage = Integer.parseInt(parts[2].trim());
                 int cooldown = Integer.parseInt(parts[3].trim());
                 attacks.add(new Attacks(type, attackName, damage, cooldown,5));
             }
         } else if (readingItems) {
             String[] parts = line.split(",");
             if (parts.length == 2) {
                 String itemName = parts[0].trim();
                 int amount = Integer.parseInt(parts[1].trim());

                 Item item = getItemByName(itemName, amount);
                 if (item != null) {
                     storedItems.add(item);
                 }
             }
         }
     }
        CharClass player = new CharClass(name, professions, ((int) playerStats.getStat("StaminaMax")), playerStats, attacks.toArray(new Attacks[0]), classTypes);
        for(Item item : storedItems){
            player.addItem(item);
        }
     return player;
    }
    //gets items that are made by the name and amount set of the item
    private static Item getItemByName(String name, int amount){
        switch (name.toLowerCase()) {
            case "health potion":
                return new HealthPotionItem(name, amount, 0.5, 50, true, false, false, 0);
            case "iron sword":
                return new IronSwordItem(name, amount, 5.0, 100, false, true, true, 0, AttackTypes.MELEE, 20);
            case "shield of honor":
                return new ShieldOfHonorItem(name, amount, 5.0, 100, false, true, true, 0, AttackTypes.MELEE, 20);
            case "stamina potion":
                return new StaminaPotionItem(name, amount, 0.5, 50, true, false, false, 1);
            default:
                System.out.println("Unknown item: " + name);
                return null;
        }
    }
}