import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
//Stats is used to hold double type values used for damage or health caculations between attacks
public class Stats {
    //stats hash map is used to hold each stat with there corrsponding value
    private HashMap<String, Double> stats;

    public Stats() {
        this.stats = new HashMap<>();
    }
    //gets a selected stat by using the stat name
    public double getStat(String statName) {
        return stats.getOrDefault(statName, 0.0);
    }
    //sets a selected stat by using the stat name
    public void setStat(String statName, double value) {
        stats.put(statName, value);
    }
    //modfiyStat is used to add a set of amount to a stat
    public void modifyStat(String statName, double amount) {
        stats.put(statName, getStat(statName) + amount);
    }

    @Override
    public String toString() {
        return stats.toString();
    }

}
