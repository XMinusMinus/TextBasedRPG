
import java.util.List;
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

    //Display damages dealt
    public String DisplayDamageDealt(Npc target, double damageDealt)
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
