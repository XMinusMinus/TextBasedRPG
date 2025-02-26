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

    //region Variables
    /**
     * The name of the item.
     */
    private String name;
    /**
     * The amount of the individual item.
     * Each item has its own amount, determining how much of the itme the player is currently holding.
     */
    private int amount;
    /**
     * The rarity of the item.
     */
    private int rarityValue;
    /**
     * The weight of the item.
     * TODO: what is weight? how does it impact things? how is it used in calculations?
     */
    private double weight;
    /**
     * The value of the item.
     * TODO: what is value? how does it impact things? how is it used in calculations?
     */
    private double value;
    /**
     * If the item is consumed on use or not.
     */
    private boolean isConsumable;
    /**
     * If the item is equippable in the main hand.
     */
    private boolean isMainHandEquipable;
    /**
     * If the item is equippable in the offhand.
     */
    private boolean isOffHandEquipable;
    //endregion


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

    /**
     * Gets the item's name.
     * @return The name of the item.
     */
    public String getItemName(){return this.name;}
    /**
     * Gets the current held amount of the item.
     * @return The amount of the current held item.
     */
    public int getItemAmount() {
        return this.amount;
    }
    /**
     * Gets the weight of the item.
     * @return The item's weight.
     */
    public double getItemWeight() {
        return this.weight;
    }
    /**
     * Gets the value of the item.
     * @return The item's value.
     */
    public double getItemValue() {
        return this.value;
    }
    /**
     * Gets if the item is consumable or not.
     * @return If the item is consumable.
     */
    public boolean isItemConsumable() {
        return this.isConsumable;
    }
    /**
     * Gets the rarity of the item.
     * @return The item's rarity.
     */
    public int getRarityValue() {return this.rarityValue;}
    /**
     * Sets the rarity of the item.
     * @param rarityValue The new rarity of the item.
     */
    public void setRarityValue(int rarityValue) { this.rarityValue = rarityValue;}
    /**
     * Gets the item's main hand equippable-ness.
     * @return Whether the item is equippable in the main hand or not.
     */
    public boolean isItemMainHandEquipable() {
        return this.isMainHandEquipable;
    }
    /**
     * Gets the item's offhand equippable-ness.
     * @return Whether the item is equippable in the offhand or not.
     */
    public boolean isItemOffHandEquipable() {
        return this.isOffHandEquipable;
    }

    /**
     * This method should be called every time the item is used. Override it and
     * put in a special item effect to make items do things on use!
     * TODO: make diff use item methods for using in different contexts? ex. if not in combat, diff effect?
     */
    //@Override
    public void UseItem() {
        // use item code here!
    }
}
