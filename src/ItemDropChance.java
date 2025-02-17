import java.util.Random;

public class ItemDropChance {
    private Item item;
    private double dropRate;

    public ItemDropChance(Item item, double dropRate) {
        this.item = item;
        this.dropRate = dropRate;
    }

    public double getDropRate()
    {
        return this.dropRate;
    }

    public boolean shouldDrop()
    {
        return new Random().nextDouble() < dropRate;
    }
}
