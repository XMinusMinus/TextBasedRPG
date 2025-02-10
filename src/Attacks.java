public class Attacks {
    private AttackTypes attackType;
    private String attackName;
    private int baseDamage;
    private int attackStanUsage;


    public Attacks(AttackTypes attackType, String attackName, int attackStanUsage)
    {
        this.attackType = attackType;
        this.attackName = attackName;
        this.attackStanUsage = attackStanUsage;
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

}
