import java.util.Scanner;

public interface RPGInterface {
    void displayStats(CharClass character);
    void displayAttacks(CharClass character);
    void displayItems(CharClass character);
    void displayNPCStats(Npc npc);
}