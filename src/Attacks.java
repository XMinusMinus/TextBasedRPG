public class Attacks {
    private AttackTypes attackType;
    private String attackName;
    private int baseDamage;
    private int attackStanUsage;
    private double attackAccuracy;


    public Attacks(AttackTypes attackType, String attackName, int baseDamage, double attackAccuracy)
    {
        this.attackType = attackType;
        this.attackName = attackName;
        this.baseDamage = baseDamage;
        this.attackAccuracy = attackAccuracy;
    }

    public int getBaseDamage()
    {
        return this.baseDamage;
    }

    public AttackTypes getAttackType()
    {
        return this.attackType;
    }

    public int getAttackStanUsage(){
        return this.attackStanUsage;
    }

    public String getAttackName()
    {
        return this.attackName;
    }

    @Override
    public String toString(){return getAttackName();}

    public int getAttackBaseDamage() {return this.baseDamage;}

    public double getAttackAccuracy() {return this.attackAccuracy;}

}
