public class Item {
    //Basic properties
    private String name;
    private int amount;
    private double weight;
    private double value;
    private boolean isConsumable;
    private boolean isMainHandEquipable;
    private boolean isOffHandEquipable;

    //Default constructor
    public Item(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable) {
        this.name = name;
        this.amount = amount;
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
