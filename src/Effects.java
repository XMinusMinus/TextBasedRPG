import java.util.*;

public class Effects {

    private String effectName;
    private String effectDescrip;
    private int effectDamage;
    private int effectHeal;
    private int effectTime;

    public Effects(String effectName,String effectDescrip,int effectDamage,int effectHeal,int effectTime) {
        this.effectName = effectName;
        this.effectDescrip = effectDescrip;
        this.effectDamage = effectDamage;
        this.effectHeal = effectHeal;
        this.effectTime = effectTime;
    }

    public String getEffectName() {
        return effectName;
    }

    public String getEffectDescrip() {
        return effectDescrip;
    }

    public int getEffectDamage() {
        return effectDamage;
    }

    public int getEffectHeal() {
        return effectHeal;
    }

    public int getEffectTime() {
        return effectTime;
    }

    public void applyEffect(HashMap<Effects, CharClass> activeEffects) {
        List<Map.Entry<Effects,CharClass>> sortedEffects = new ArrayList<>(activeEffects.entrySet());
        sortedEffects.sort((getEffect1,getEffect2) -> Integer.compare(getEffect2.getKey().getEffectDamage(),getEffect1.getKey().getEffectDamage()));
        LinkedHashMap<Effects, CharClass> effects = new LinkedHashMap<>();
        for (Map.Entry<Effects, CharClass> entry : sortedEffects) {
            effects.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Effects, CharClass> entry : effects.entrySet()) {
            System.out.println(entry.getKey().getEffectName() + " Damage Done " + entry.getKey().getEffectDamage() );
        }
    }
}
