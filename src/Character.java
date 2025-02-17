import java.util.ArrayList;
import java.util.List;
public abstract class Character {
    private String name;
    private Professions profession;
    private Stats stats;
    private List<Item> inventory;

    public Character(String name, Professions professions, int charMaxStanima, Stats stats){
        this.name = name;
        this.profession = professions;
        this.stats = stats;
        this.inventory = new ArrayList<>();
    }

    public String GetName()
    {
        return name;
    }

    public Professions GetProfession()
    {
        return profession;
    }

    public double getStat(String statName) {
        return stats.getStat(statName);
    }

    public void setStat(String statName, double value) {
        stats.setStat(statName, value);
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public void equipItem(Item item) {}

    public List<Item> getInventory() {
        return inventory;
    }

}
