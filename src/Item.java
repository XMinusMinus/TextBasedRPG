import java.util.Comparator;

public class Item implements Comparable<Item>, Comparator<Item> {

    //A Comparable allows a class to define its natural ordering by implementing the compareTo() method
    //A Comparator is a separate object used to define custom ordering by implementing the compare() method
@Override
    public int compareTo(Item item) {
        return this.getRarityValue() - item.getRarityValue();
    }

@Override
    public int compare(Item item1, Item item2) {
        return item1.getRarityValue() - item2.getRarityValue();
    }
    //Basic properties
    private String name;
    private int amount;
    private int rarityValue;
    private double weight;
    private double value;
    private boolean isConsumable;
    private boolean isMainHandEquipable;
    private boolean isOffHandEquipable;


    //Default constructor
    public Item(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        this.name = name;
        this.amount = amount;
        this.rarityValue = rarityValue;
        this.weight = weight;
        this.value = value;
        this.isConsumable = isConsumable;
        this.isMainHandEquipable = isMainHandEquipable;
        this.isOffHandEquipable = isOffHandEquipable;
    }

    public int getItemAmount() {
        return this.amount;
    }

    public double getItemWeight() {
        return this.weight;
    }

    public double getItemValue() {
        return this.value;
    }

    public boolean isItemConsumable() {
        return this.isConsumable;
    }

    public int getRarityValue() {return this.rarityValue;}

    public void setRarityValue(int rarityValue) { this.rarityValue = rarityValue;}

    public boolean isItemMainHandEquipable() {
        return this.isMainHandEquipable;
    }
    public boolean isItemOffHandEquipable() {
        return this.isOffHandEquipable;
    }
    public String getItemName(){return this.name;}

    public void UseItem() {
        // use item code here!
    }
}
