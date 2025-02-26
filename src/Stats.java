import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
//Stats is used to hold double type values used for damage or health caculations between attacks
public class Stats {
    //stats hash map is used to hold each stat with there corrsponding value
    private List<Stat> stats;

    public Stats() {
        this.stats = new ArrayList<>();
    }

    //gets a selected stat by using the stat name
    public double getStat(String statName) {
        for(Stat stat : stats) {
            if(stat.getName().equals(statName)) {
                return stat.getValue();
            }
        }
        return 0.0;
    }

    //sets a selected stat by using the stat name
    public void setStat(String statName, double value) {
        for(Stat stat : stats) {
            if(stat.getName().equals(statName)) {
                stat.setValue(value);
                return;
            }
        }
        stats.add(new Stat(statName, value));
    }
    //modfiyStat is used to add a set of amount to a stat
    public void modifyStat(String statName, double amount) {

        for(Stat stat : stats) {
            if(stat.getName().equals(statName)) {
                stat.setValue(stat.getValue() + amount);
                return;
            }
        }
        stats.add(new Stat(statName, amount));
    }

    @Override
    public String toString() {
        return stats.toString();
    }
}
