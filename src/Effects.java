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
}
