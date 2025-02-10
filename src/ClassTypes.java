import java.util.EnumMap;
import java.util.Map;

public enum ClassTypes {
    //Melee | Magic | Ranged multipliers
    ARCHER(1.3, 0.9, 0.8),
    MAGE(1.0, 1.5, 0.7),
    WARRIOR(0.8, 1.0, 1.2);

    private final Map<AttackTypes, Double> attackMultipliers;

    ClassTypes(double meleeMultiplier, double magicMultiplier, double rangedMultiplier){
        attackMultipliers = new EnumMap<>(AttackTypes.class);
        attackMultipliers.put(AttackTypes.MELEE, meleeMultiplier);
        attackMultipliers.put(AttackTypes.MAGIC, magicMultiplier);
        attackMultipliers.put(AttackTypes.RANGED, rangedMultiplier);
    }

    public double getDamageMultiplier(AttackTypes attackType){
        return attackMultipliers.getOrDefault(attackType, 1.0);
    }
}
