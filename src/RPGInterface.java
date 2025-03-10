public interface RPGInterface {
    void displayStats(CharClass character);
    void displayAttacks(CharClass character, Npc npc, World world);
    void displayItems(CharClass character, Npc npc);
    void displayNPCStats(Npc npc);
}