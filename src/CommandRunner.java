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

public class CommandRunner implements RPGInterface {
    private GUI gui;
    private CharClass player;
    private World world;
    private ClassTypes classType;

    public CommandRunner(CharClass player, Npc npc, World world) {
        this.gui = new GUI();
        this.player = player;
        this.world = world;
        this.classType = classType;
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
        Scanner scanner = new Scanner(System.in);
        String input;
        List<String> commands = Arrays.asList("stats", "attacks", "items", "npcstats", "exit");

        while (true) {
            System.out.println("Enter a command (stats, attacks, items, npcstats, exit): ");
            input = scanner.nextLine().toLowerCase();

            Supplier<Npc> currentNpc = world::getCurrentNpc;
            System.out.println("CURRENT NPC: " + currentNpc.get().GetName());

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
            switch (bestMatch) {
                case "stats":
                    displayStats(player);
                    break;
                case "attacks":
                    displayAttacks(player, currentNpc.get(), world);
                    currentNpc.get().choseRandomAttack(player, currentNpc.get());
                    gui.BattleCaculation(currentNpc.get(), player, world);
                    break;
                case "items":
                    displayItems(player,currentNpc.get());
                    break;
                case "npcstats":
                    displayNPCStats(currentNpc.get());
                    break;
                case "exit":
                    System.out.println("Exiting game...");
                    scanner.close();
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

}
