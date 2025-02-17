import java.util.Scanner;

public class CommandRunner implements RPGInterface{
    private GUI gui;
    private CharClass player;
    private Npc npc;
    private World world;

    public CommandRunner(CharClass player, Npc npc, World world) {
        this.gui = new GUI();
        this.player = player;
        this.npc = npc;
        this.world = world;
    }

    @Override
    public void displayStats(CharClass character) {
        System.out.println(gui.DisplayCharacterStats(character));
    }

    @Override
    public void displayAttacks(CharClass character) {
        System.out.println(gui.DisplayMoveChoices(character));

        //character.Attack(gui.MakeMoveChoice(character), );

    }

    @Override
    public void displayItems(CharClass character) {
        System.out.println(gui.DisplayInventory(character));
        Item itemToUse = gui.GetItemFromInventory(character);
        if (itemToUse.isItemConsumable()) {
            // remove 1 from item total in inv
        }
        itemToUse.UseItem();
    }

    @Override
    public void displayNPCStats(Npc npc) {
        System.out.println(gui.DisplayNPCStats(npc));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Enter a command (stats, attacks, items, npcstats, exit): ");
            input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "stats":
                    displayStats(player);
                    break;
                case "attacks":
                    displayAttacks(player);
                    npc.choseRandomAttack(player);
                    gui.BattleCaculation(npc,player,world);
                    break;
                case "items":
                    displayItems(player);
                    break;
                case "npcstats":
                    displayNPCStats(npc);
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
}
