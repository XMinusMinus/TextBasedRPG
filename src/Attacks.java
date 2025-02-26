public class Attacks {
    /**
     * The attack type of the attack.
     */
    private AttackTypes attackType;
    /**
     * The name of the attack.
     */
    private String attackName;
    /**
     * The base damage the attack has.
     */
    private int baseDamage;
    /**
     * The amount of stamina an attack uses.
     */
    private int attackStanUsage;
    /**
     * The accuracy of the attack.
     * TODO: how does accuracy impact damage forumla?
     */
    private double attackAccuracy;


    public Attacks(AttackTypes attackType, String attackName, int baseDamage, double attackAccuracy)
    {
        this.attackType = attackType;
        this.attackName = attackName;
        this.baseDamage = baseDamage;
        this.attackAccuracy = attackAccuracy;
    }
    /**
     * Gets the base damage of the attack.
     * @return The base damage of the attack.
     */
    public int getBaseDamage()
    {
        return this.baseDamage;
    }
    /**
     * Gets the damage type that the attack is.
     * @return The attack's damage type.
     */
    public AttackTypes getAttackType()
    {
        return this.attackType;
    }
    /**
     * Gets the amount of stamina the attack uses.
     * @return The amount of stamina the attack uses.
     */
    public int getAttackStanUsage(){
        return this.attackStanUsage;
    }
    /**
     * Gets the name of the attack.
     * @return The name of the attack.
     */
    public String getAttackName()
    {
        return this.attackName;
    }

    @Override
    public String toString(){return getAttackName();}
    /**
     * Gets the chance for the attack to land.
     * @return The accuracy of the attack.
     */
    public double getAttackAccuracy() {return this.attackAccuracy;}

}
