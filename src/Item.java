public class Item {
    //Basic properties
    private String name;
    private int amount;
    private double weight;
    private double value;
    private boolean isConsumable;

    //Default constructor
    public Item(String name, int amount, double weight, double value, boolean isConsumable) {
        this.name = name;
        this.amount = amount;
        this.weight = weight;
        this.value = value;
        this.isConsumable = isConsumable;
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
}
