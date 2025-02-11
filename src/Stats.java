import java.util.HashMap;
import java.util.Map;

public class Stats {
    private HashMap<String, Double> stats;

    public Stats() {
        this.stats = new HashMap<>();
    }

    public double getStat(String statName) {
        return stats.getOrDefault(statName, 0.0);
    }

    public void setStat(String statName, double value) {
        stats.put(statName, value);
    }

    public void modifyStat(String statName, double amount) {
        stats.put(statName, getStat(statName) + amount);
    }

    @Override
    public String toString() {
        return stats.toString();
    }

}
