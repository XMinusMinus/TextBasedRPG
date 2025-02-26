import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Floor {
    Npc[] remainingMobs;

    public void AwardLoot(CharClass user)
    {

    }

    public void removeDeadMobs()
    {
        List<Npc> mobsList = new ArrayList<>(Arrays.asList(remainingMobs));
        Iterator<Npc> mobsIterator = mobsList.iterator();

        while (mobsIterator.hasNext()) {
            Npc n = mobsIterator.next();

            if (n.getStat("HP") <= 0)
            {
                System.out.println("Removing " + n.GetName());
                System.out.println(n.getStat("HP"));
                mobsIterator.remove();
                System.out.println("Removed");
            }
        }

        System.out.println("Finished with loop");

        this.remainingMobs = mobsList.toArray(new Npc[mobsList.size()]);
        System.out.println(Arrays.toString(remainingMobs));
    }

    public Npc[] getRemainingMobs() {
        return remainingMobs;
    }

    public Floor(Npc[] mobs) {
        remainingMobs = mobs;
    }

}
