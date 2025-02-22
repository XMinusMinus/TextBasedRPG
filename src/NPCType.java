import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public enum NPCType {

    GOBLIN(new ArrayList<>(Arrays.asList(
            new ItemDropChance(new Item("Dagger", 1, 5, 20, false, true, true,1), 0.5),
            new ItemDropChance(new Item("Gold Tooth", 1, 0.1, 50, false, false, false,1), 0.15)
    )));
//    SKELETON,
//    ORG,
//    EVIL_WIZARD,
//    EVIL_KNIGHT,
//    EVIL_ARCHER,
//    DRAGON
    private List<ItemDropChance> lootPool;

    NPCType(List<ItemDropChance> lootPool) {
        this.lootPool = lootPool;
    }
    private List<ItemDropChance> getLootPool() {
        return this.lootPool;
    }
}
