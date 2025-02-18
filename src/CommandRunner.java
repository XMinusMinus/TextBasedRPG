import java.util.Scanner;

public class CommandRunner implements RPGInterface{
    private GUI gui;
    private CharClass player;
    private Npc npc;
    private World world;
    private ClassTypes classType;

    public CommandRunner(CharClass player, Npc npc, World world) {
        this.gui = new GUI();
        this.player = player;
        this.npc = npc;
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
        System.out.println(character.Attack( plyAttack, npc));
        System.out.println(npc.Attack(plyAttack,character));
        gui.BattleCaculation(npc,character,world);



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
                    displayAttacks(player,npc,world);
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
