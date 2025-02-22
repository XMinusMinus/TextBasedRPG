public class WepondItem extends Item {
    private String name;
    private int amount;
    private double weight;
    private double value;
    private boolean isConsumable;
    private boolean isMainHandEquipable;
    private boolean isOffHandEquipable;
    private int rarityValue;
    private Stats stats;
    private AttackTypes attackTypes;
    private int wepondDamage;
    //Default constructor

    public WepondItem(String name, int amount, double weight, double value, boolean isConsumable,boolean isMainHandEquipable, boolean isOffHandEquipable,int rarityValue, AttackTypes attackTypes, int wepondDamage) {
        super(name,amount,weight,value,isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
        this.attackTypes = attackTypes;
        this.wepondDamage = wepondDamage;

    }
    public AttackTypes getWepondType(){
        return attackTypes;
    }
    public int getWepondDamage(){
        return wepondDamage;
    }
    public void setWepondDamage(int wepondDamage){
        this.wepondDamage = wepondDamage;
    }
    public void setWepondType(AttackTypes attackTypes){
        this.attackTypes = attackTypes;
    }
    //public Attacks WepondItemUse(Attacks attacks, int wepondDamage, Stats stats){

    //}

}
