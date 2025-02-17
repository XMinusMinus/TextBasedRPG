public class Floor {
    Npc[] remainingMobs;

    public void AwardLoot(CharClass user)
    {

    }

    public Npc[] getRemainingMobs() {
        return remainingMobs;
    }

    public Floor(Npc[] mobs) {
        remainingMobs = mobs;
    }

}
