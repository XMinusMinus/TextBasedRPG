import java.util.HashMap;
import java.util.Map;

public abstract class Stats {
private final Map<String, Double> stats = new HashMap<>();

public void setStat(String statName, double value ) {
 stats.put(statName, value);
}
public double getStat(String statName) {
    return stats.get(statName);
}
public boolean hasStat(String statName){
    return stats.containsKey(statName);
}

}
