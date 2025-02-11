import java.util.Scanner;

public class CommandRunner implements RPGInterface{
    private GUI gui;
    private CharClass player;
    private Npc npc;

    public CommandRunner(CharClass player, Npc npc) {
        this.gui = new GUI();
        this.player = player;
        this.npc = npc;
    }

    @Override
    public void displayStats(CharClass character) {
        System.out.println(gui.DisplayCharacterStats(character));
    }

    @Override
    public void displayAttacks(CharClass character) {
        System.out.println(gui.DisplayMoveChoices(character));
    }

    @Override
    public void displayItems(CharClass character) {
        System.out.println(gui.DisplayInventory(character));
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
