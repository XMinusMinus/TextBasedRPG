import java.util.*;

public class GUI {

    //Display moves in output
    public String DisplayMoveChoices(CharClass character)
    {
        Attacks[] attacks = character.getAttacks();

        String displayMessage = "[-------------AVAILABLE ATTACKS-------------]\n";
        for (int i = 0; i < attacks.length; i++)
        {
            displayMessage += "\n" + (i + 1) + ". " + attacks[i].getAttackName()+": Power "+ attacks[i].getBaseDamage() + ", Stamina " + attacks[i].getAttackStanUsage() + ", Accuracy " + attacks[i].getAttackAccuracy();
        }

        displayMessage += "\n You have " + character.getcharStamina() + " Stamina.";
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
        System.out.println("Battle calculation started.");
        System.out.println(npc.GetIsPassive());
        System.out.println(npc.getStat("HP"));
        if(npc.GetIsPassive() == true){
            System.out.println(npc.GetName()+": Has let you pass to the next floor.");
            world.CheckAdvanceFloor();
        }
        else if(npc.GetIsPassive() == false && npc.getStat("HP") <= 0){
            System.out.println(npc.GetName()+": Has been slain.");
            world.CheckAdvanceFloor();
        }
        else if(character.getStat("HP") <= 0){
            System.out.println("You blacked out!");
            character.setStat("HP", character.getStat("MAXHP"));
            System.exit(0);
         //   world.GameLossFloorReset();
        }

    }

    //Display damages dealt
    public String DisplayDamageDealt(Npc target, double damageDealt, CharClass character)
    {
        String displayMessage = "[-------------DAMAGE DEALT-------------]\n";

        float damageDealtRounded = Math.round(damageDealt);
        String mainInfo = String.format("%s took %f damage!", target.GetName(), damageDealtRounded);
        displayMessage += "\n" + mainInfo;

        displayMessage += "\n[^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^]";

        return displayMessage;
    }

    //Display character stats
    public String DisplayCharacterStats(CharClass character) {
        return "[-------------PLAYER STATS-------------]\n" +
                "Name: " + character.GetName() + "\n" +
                "Profession: " + character.GetProfession() + "\n" +
                "Stamina: " + Math.round(character.getcharStamina()) + "/" + Math.round(character.getcharMaxStamina()) + "\n" +
                "HP: " + Math.round(character.getStat("HP")) + "\n" +
                "Attack: " + Math.round(character.getStat("Attack")) + "\n" +
                "Defense: " + Math.round(character.getStat("Defense")) + "\n" +
                "[^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^]";
    }



    public String DisplayInventory(CharClass character) {
        List<Item> items = character.getInventory();


        StringBuilder displayMessage = new StringBuilder("[-------------INVENTORY-------------]\n");

        if (items.isEmpty()) {
            displayMessage.append("Inventory is empty.");
        } else {
            //Sorts items by rarity value
            items.sort(Comparator.comparingInt(p -> p.getRarityValue()));

            Collections.sort(items);
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
            System.out.println("Sorry, that item doesn't exist.");
            MakeMoveChoice(character);
        }
        // subtract input by 1 to account for how items are shown
        input = input - 1;

        return items.get(input);
    }

    public int GetEquipItemSlot(CharClass character, EquipableItems item){
        EquipableItems[] slots = character.getItemsEquiped();
        Scanner scanner = new Scanner(System.in);

        System.out.println(this.DisplayEquippedItems(slots));

        System.out.println("Please enter a empty slot for " + item.getItemName() + " to be equipped");

        int input = scanner.nextInt() - 1;

        try
        {
            if (slots[input] == null)
            {
                return input;
            }
            else
            {
                System.out.println("Please enter a slot that is empty.");
                return GetEquipItemSlot(character, item);
            }
        }
        catch (Exception e)
        {
            System.out.println("Please enter a valid number.");
            return GetEquipItemSlot(character, item);
        }
    }

    public boolean GetEquipWeaponChoice(String ItemName) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you wish to equip " + ItemName + "(Y/N)");
        String input = scanner.next().toUpperCase();
        boolean equipItem = false;

        // validate input
        // if its less than 1 or more than the item length, call them out and retry
        if (!input.equals("Y") && !input.equals("N")) {
            System.out.println("Sorry, that is not a choice.");
            GetEquipWeaponChoice(ItemName);
        }
        else
        {
            if (input.equals("Y"))
            {
                equipItem = true;
            }
        }

        return equipItem;
    }

    public String DisplayEquippedItems(EquipableItems[] slots)
    {
        String slotText = "";

        for (int i = 0; i < slots.length; i++)
        {
            if (slots[i] == null)
            {
                slotText += "Slot " + (i + 1) + ": Empty\n";
            }
            else
            {
                slotText += "Slot " + (i + 1) + ": " + slots[i].getItemName() + "\n";
            }
        }

        return "[-------------Item Slots-------------]\n" +
                slotText +
                "[^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^]";
    }

    public String DisplayNPCStats(Npc npc) {
        return "[-------------NPC STATS-------------]\n" +
                "Name: " + npc.GetName() + "\n" +
                "Description: " + npc.GetDescription() + "\n" +
                "HP: " + Math.round(npc.getStat("HP")) + "\n" +
                "Attack: " + Math.round(npc.getStat("Attack")) + "\n" +
                "Defense: " + Math.round(npc.getStat("Defense")) + "\n" +
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
