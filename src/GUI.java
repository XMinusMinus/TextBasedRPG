
import java.util.List;
import java.util.Scanner;
public class GUI {

    //Display moves in output
    public String DisplayMoveChoices(CharClass character)
    {
        Attacks[] attacks = character.getAttacks();

        String displayMessage = "[-------------AVAILABLE ATTACKS-------------]\n";
        for (int i = 0; i < attacks.length; i++)
        {
            displayMessage += "\n" + (i + 1) + ". " + attacks[i].getAttackName();
        }

        displayMessage += "\n[^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^]";

        return displayMessage;
    }

    // call this after DisplayMoveChoices
    public Attacks MakeMoveChoice(CharClass character)
    {
        Attacks[] attacks = character.getAttacks();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose an attack.");
        System.out.println("Input the number of the attack you wish to use.");
        int input = scanner.nextInt();

        // validate input
        // if its less than 1 or more than the attack length, call them out and retry
        if (input > attacks.length || input < 1) {
            System.out.println("Sorry, that attack doesn't exist.");
            MakeMoveChoice(character);
        }
        // subtract input by 1 to account for how attacks are shown
        input = input - 1;

        return attacks[input];
    }
    public void BattleCaculation(Npc npc, CharClass character, World world){
        if(npc.GetIsPassive() == true){
            System.out.println(npc.GetName()+": Has let you pass to the next floor.");
            world.AdvanceFloor();
        }
        else if(npc.GetIsPassive() == false && npc.getStat("HP") <= 0){
            System.out.println(npc.GetName()+": Has been slain.");
            world.AdvanceFloor();
        }
        else if(character.getStat("HP") <= 0){
            System.out.println("You Blacked out!");
            character.setStat("HP", character.getStat("MAXHP"));
            world.GameLossFloorReset();
        }

    }

    //Display damages dealt
    public String DisplayDamageDealt(Npc target, double damageDealt, CharClass character)
    {
        String displayMessage = "[-------------DAMAGE DEALT-------------]\n";

        String mainInfo = String.format("%s took %f damage!", target.GetName(), damageDealt);
        displayMessage += "\n" + mainInfo;

        displayMessage += "\n[^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^]";

        return displayMessage;
    }

    //Display character stats
    public String DisplayCharacterStats(CharClass character) {
        return "[-------------PLAYER STATS-------------]\n" +
                "Name: " + character.GetName() + "\n" +
                "Profession: " + character.GetProfession() + "\n" +
                "Stamina: " + character.getcharStanima() + "/" + character.getcharMaxStanima() + "\n" +
                "HP: " + character.getStat("HP") + "\n" +
                "Attack: " + character.getStat("Attack") + "\n" +
                "Defense: " + character.getStat("Defense") + "\n" +
                "[^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^]";
    }

    public String DisplayInventory(CharClass character) {
        List<Item> items = character.getInventory();
        StringBuilder displayMessage = new StringBuilder("[-------------INVENTORY-------------]\n");

        if (items.isEmpty()) {
            displayMessage.append("Inventory is empty.");
        } else {
            for (Item item : items) {
                displayMessage.append("\n- ").append(item.getItemAmount()).append("x ").append(item.getItemName());
            }
        }

        displayMessage.append("\n[^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^]");
        return displayMessage.toString();
    }

    public Item GetItemFromInventory(CharClass character) {
        List<Item> items = character.getInventory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please choose an item.");
        System.out.println("Input the number of the item you wish to use.");
        int input = scanner.nextInt();

        // validate input
        // if its less than 1 or more than the item length, call them out and retry
        if (input > items.size() || input < 1) {
            System.out.println("Sorry, that attack doesn't exist.");
            MakeMoveChoice(character);
        }
        // subtract input by 1 to account for how items are shown
        input = input - 1;

        return items.get(input);
    }

    public String DisplayNPCStats(Npc npc) {
        return "[-------------NPC STATS-------------]\n" +
                "Name: " + npc.GetName() + "\n" +
                "Description: " + npc.GetDescription() + "\n" +
                "HP: " + npc.getStat("HP") + "\n" +
                "Attack: " + npc.getStat("Attack") + "\n" +
                "Defense: " + npc.getStat("Defense") + "\n" +
                "[^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^]";
    }

    public void displayItems(CharClass character) {
        System.out.println("Inventory:");
        List<Item> inventory = character.getInventory();
        if (inventory.isEmpty()) {
            System.out.println(" - No items in inventory.");
        } else {
            for (Item item : inventory) {
                System.out.println(" - " + item.getItemName() + " (Amount: " + item.getItemAmount() + ")");
            }
        }
    }


}
