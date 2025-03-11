import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CommandRunner implements RPGInterface {
    private GUI gui;
    private CharClass player;
    private World[] worlds;
    private ClassTypes classType;

    public CommandRunner(CharClass player, Npc npc, World[] worlds) {
        this.gui = new GUI();
        this.player = player;
        this.worlds = worlds;
    }

    private World getCurrentWorld()
    {
        for (World world : worlds)
        {
            if (!world.IsPassed())
            {
                System.out.println("This world is World #" + world.getWorldNumber());
                return world;
            }
        }

        System.out.println("Congratulations! You have completed all the worlds!");
        System.exit(0);
        return worlds[0];
    }

    @Override
    public void displayStats(CharClass character) {
        System.out.println(gui.DisplayCharacterStats(character));
    }

    @Override
    public void displayAttacks(CharClass character, Npc npc, World world) {
        System.out.println(gui.DisplayMoveChoices(character));
        Attacks plyAttack = gui.MakeMoveChoice(character);
        System.out.println(character.Attack(plyAttack, npc, character));
        System.out.println(npc.Attack(plyAttack, character, npc));
        // gui.BattleCaculation(npc,character,world);
    }

    @Override
    public void displayItems(CharClass character, Npc npc) {
        System.out.println(gui.DisplayInventory(character));
        Item itemToUse = gui.GetItemFromInventory(character);

        System.out.println(itemToUse instanceof EquipableItems);

        if (itemToUse.isItemConsumable()) {
            // remove 1 from item total in inv
            itemToUse.UseItem(character,npc);
        }
        else if (itemToUse.isItemMainHandEquipable() || itemToUse.isItemOffHandEquipable())
        {
            if (itemToUse instanceof WepondItem)
            {
                if (gui.GetEquipWeaponChoice(itemToUse.getItemName()))
                {
                    WepondItem weapon = (WepondItem) itemToUse;
                    weapon.WepondActionOnEquip(character);
                    character.setEquippedWeapon(weapon);
                    System.out.println(character.getEquippedWeapon().getItemName());
                    System.out.println("This is the weapon: " + character.getEquippedWeapon().getItemName());
                }
            }
        }
        else if (itemToUse instanceof EquipableItems)
        {
            EquipableItems item = (EquipableItems) itemToUse;
            int slot = gui.GetEquipItemSlot(character, item);
            if (item.IsEquipped)
            {
                item.UnequipItem(character);
                character.unsetEquippable(item);
            }
            item.EquipItem(character);
            character.setEquippable(item, slot);
        }
    }

    @Override
    public void displayNPCStats(Npc npc) {
        System.out.println(gui.DisplayNPCStats(npc));
    }

    public void run() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> saveCharacterOnExit(player, player.GetName())));
        Scanner scanner = new Scanner(System.in);
        String input;
        List<String> commands = Arrays.asList("stats", "attacks", "items", "npcstats", "exit","savefile","charinfo");

        while (true) {
            System.out.println("Enter a command (stats, attacks, items, npcstats, exit): ");
            input = scanner.nextLine().toLowerCase();

            BiPredicate<String, String> isSimilar = (userInput, command) -> {
                return command.startsWith(userInput);
            };

            Map<String, Integer> matchScores = new HashMap<>();
            for (String command : commands) {
                if (isSimilar.test(input, command)) {
                    matchScores.put(command, getMatchScore(input, command));
                }
            }

            if (matchScores.isEmpty()) {
                System.out.println("Invalid command. Try again.");
                continue;
            }

            // Sort by best match
            List<Map.Entry<String, Integer>> sortedMatches = new ArrayList<>(matchScores.entrySet());
            sortedMatches.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

            // If there's a tie, display only the tied options
            if (sortedMatches.size() > 1 && sortedMatches.get(0).getValue().equals(sortedMatches.get(1).getValue())) {
                System.out.println("Multiple possible commands: " + sortedMatches.stream().map(Map.Entry::getKey).toList());
                continue;
            }

            // Execute the best-matched command
            String bestMatch = sortedMatches.get(0).getKey();

            World currentWorld = getCurrentWorld();
            System.out.println("Current World Number: " + currentWorld.getWorldNumber());
            Npc currentNpc = currentWorld.getCurrentNpc();

            switch (bestMatch) {
                case "stats":
                    displayStats(player);
                    break;
                case "attacks":
                    displayAttacks(player, currentNpc, currentWorld);
                    currentNpc.choseRandomAttack(player, currentNpc);
                    System.out.println("Battle Calculation started.");
                    gui.BattleCaculation(currentNpc, player, currentWorld);
                    break;
                case "items":
                    displayItems(player,currentNpc);
                    break;
                case "npcstats":
                    displayNPCStats(currentNpc);
                    break;
                case "savefile":
                    saveCharacterFile(player);
                    break;
                case "charinfo":
                    listAllFilesWithSize();
                    listSubdirectoryContents();
                    printFileContents("Hero.txt");

                    break;
                case "exit":
                    System.out.println("Exiting game...");
                    scanner.close();
                    // Runtime.getRuntime().addShutdownHook(new Thread(() -> saveCharacterOnExit(player, player.GetName())));
                    return;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }

    private static int getMatchScore(String input, String command) {
        int score = 0;
        Function<String,Integer> length = String::length;
        for (int i = 0; i < length.apply(input); i++) {
            if (i < command.length() && input.charAt(i) == command.charAt(i)) {
                score++;
            }
        }
        return score;
    }
    public static void saveCharacterOnExit(CharClass player, String characterName) {
        if (player == null || characterName == null || characterName.isEmpty()) {
            System.out.println("No character to save.");
            return;
        }

        String currentDirectory = new File("").getAbsolutePath();
        File characterFile = new File(currentDirectory + File.separator + "src"+File.separator+"Characters"+ File.separator + characterName + ".txt");

        try (FileWriter writer = new FileWriter(characterFile)) {

            writer.write("Name: " + player.GetName() + "\n");
            writer.write("Class: " + player.getClassType() + "\n");
            writer.write("HP: " + ((int) player.getStat("HP")) + "\n");
            writer.write("MAXHP: " + ((int) player.getStat("MAXHP")) + "\n");
            writer.write("Attack: " + ((int) player.getStat("Attack")) + "\n");
            writer.write("Defense: " + ((int) player.getStat("Defense")) + "\n");
            writer.write("Magic Power: " + ((int) player.getStat("Magic Power")) + "\n");
            writer.write("Stamina: " + ((int) player.getcharStamina()) + "\n");
            writer.write("StaminaMax: " + ((int) player.getcharMaxStamina()) + "\n\n");

            writer.write("Attacks:\n");
            for (Attacks attack : player.getAttacks()) {
                if (attack != null) {
                    writer.write(attack.getAttackName() + ", " + attack.getAttackType() + ", " +
                            attack.getBaseDamage() + ", " + ((int) attack.getAttackAccuracy()) + "\n");
                }
            }

            writer.write("\nItems:\n");
            List<Item> inventory = player.getInventory();
            for (Item item : inventory) {
                writer.write(item.getItemName() + ", " + item.getItemAmount() + "\n");
            }

            System.out.println("Character saved successfully!");

        } catch (IOException e) {
            System.err.println("Error saving character file: " + e.getMessage());
        }
    }

    public static void saveCharacterFile(CharClass player) {
        if (player == null) {
            System.out.println("No character to save.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the full file path where you want to save the character file: ");
        String directoryPath = scanner.nextLine().trim();

        if (directoryPath.isEmpty()) {
            System.out.println("Invalid file path.");
            return;
        }

        // Ensure the directory exists
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String characterName = player.GetName();
        File characterFile = new File(directoryPath + File.separator + characterName + ".txt");
        System.out.println(characterFile);
        try (FileWriter writer = new FileWriter(characterFile)) {
            writer.write("Name: " + characterName + "\n");
            writer.write("Class: " + player.getClassType() + "\n");
            writer.write("HP: " + ((int) player.getStat("HP")) + "\n");
            writer.write("MAXHP: " + ((int) player.getStat("MAXHP")) + "\n");
            writer.write("Attack: " + ((int) player.getStat("Attack")) + "\n");
            writer.write("Defense: " + ((int) player.getStat("Defense")) + "\n");
            writer.write("Magic Power: " + ((int) player.getStat("Magic Power")) + "\n");
            writer.write("Stamina: " + ((int) player.getcharStamina()) + "\n");
            writer.write("StaminaMax: " + ((int) player.getcharMaxStamina()) + "\n\n");

            writer.write("Attacks:\n");
            for (Attacks attack : player.getAttacks()) {
                if (attack != null) {
                    writer.write(attack.getAttackName() + ", " + attack.getAttackType() + ", " +
                            attack.getBaseDamage() + ", " + ((int) attack.getAttackAccuracy()) + "\n");
                }
            }

            writer.write("\nItems:\n");
            List<Item> inventory = player.getInventory();
            for (Item item : inventory) {
                writer.write(item.getItemName() + ", " + item.getItemAmount() + "\n");
            }

            System.out.println("Character saved successfully at: " + characterFile.getAbsolutePath());

            // Get and print the file size
            long fileSize = characterFile.getAbsolutePath().length();
            System.out.println("File size: " + fileSize + " bytes");

        } catch (IOException e) {
            System.err.println("Error saving character file: " + e.getMessage());
        }
    }


    public static void listAllFilesWithSize() {
        String directoryPath = new File("").getAbsolutePath() + File.separator + "src" + File.separator + "Characters";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Files in directory:");
            File[] files = directory.listFiles((file) -> file.isFile());
            if (files != null) {
                for (File file : files) {
                    System.out.println("File: " + file.getName() + " | Size: " + file.length() + " bytes");
                }
            } else {
                System.out.println("No files found.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }


    public static void listSubdirectoryContents() {
        String directoryPath = new File("").getAbsolutePath() + File.separator + "src" + File.separator + "Characters";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("\nContents of '" + directory.getName() + "' directory:");
            File[] contents = directory.listFiles();
            if (contents != null) {
                for (File file : contents) {
                    System.out.println((file.isDirectory() ? "[DIR] " : "[FILE] ") + file.getName());
                }
            } else {
                System.out.println("No contents found.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }


    public static void printFileContents(String fileName) {
        String filePath = new File("").getAbsolutePath() + File.separator + "src" + File.separator + "Characters" + File.separator + fileName;

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("File '" + fileName + "' not found.");
            return;
        }

        System.out.println("\nContents of file: " + fileName);
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }


}
