import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CharClass extends Character{
    private Stats stats;
    private String[] backpack = new String[32];
    private Attacks[] attacks = new Attacks[10];
    private ClassTypes classType;
    private List<Item> inventory;
    private WepondItem equippedWeapon;
    private EquipableItems[] equipableItems = new EquipableItems[5];

    public CharClass(String name, Professions profession, int charMaxStamina, Stats stats, Attacks[] attacks, ClassTypes classType) {

        super(name, profession, charMaxStamina, stats);
        this.inventory = new ArrayList<>();
        this.attacks = attacks;
        this.classType = classType;
        this.equippedWeapon = null;
    }

    @Override
    public String toString() {
        return super.GetName() + ", the " + super.GetProfession().toString();
    }
    public void setEquippable(EquipableItems equippable, int slot){
        equipableItems[slot] = equippable;

    }
    public void unsetEquippable(EquipableItems item){
        for (int i = 0; i < this.equipableItems.length; i++)
        {
            if (this.equipableItems[i].equals(item))
            {
                this.equipableItems = null;
                return;
            }
        }
    }
    public EquipableItems[] getItemsEquiped(){
        return equipableItems;

    }
    public WepondItem getEquippedWeapon(){
        return this.equippedWeapon;
    }
    public void setEquippedWeapon(WepondItem weapon){
        this.equippedWeapon = weapon;
    }
    public void unequipWeapon(){
        addItem(equippedWeapon);
        this.equippedWeapon = null;
    }


    public String Attack(Attacks attack, Npc target, CharClass player)
    {
        if(getcharStamina() >= attack.getAttackStanUsage()) {
            Random random = new Random();
            if (random.nextInt(100) <= attack.getAttackAccuracy()) {
                double damage = attack.getBaseDamage() *  player.getStat("Attack")/ target.getStat("Defense");
                double damageBonus = this.classType.getDamageMultiplier(attack.getAttackType());
                setStamina(attack.getAttackStanUsage());
                double npcCurrentHP = target.getStat("HP");
                double afterAttack = npcCurrentHP - damage * damageBonus;
                target.setStat("HP",afterAttack);
                //target.TakeDamage(damage, attack.getAttackType());
                return super.GetName() +" used "+ attack.toString() + " which did " + damage + " to " + target.toString();
            }
            else {
                setStamina(attack.getAttackStanUsage());
                return super.GetName() +" used "+ attack.toString() + ", but the attack missed!";
            }
        }
        else{
            return super.GetName() + " does not have stamina for this move";
        }
    }

    public ClassTypes getClassType(){return this.classType;}

    public Attacks[] getAttacks()
    {
        return attacks;
    }

    public double getcharStamina(){
        return getStat("Stamina");
    }
    public double getcharMaxStamina(){
        return getStat("StaminaMax");
    }
    public void setStamina(int deduction)
    {
        setStat("Stamina", getcharStamina() - deduction);
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }
    public Item getItemFromInventory() {

        // currently returns first item from inventory, this is temp
        return inventory.getFirst();
    }

    public void ChooseDialogOption(int option){

    }

    public void PresentDialogOption(String dialog){

    }
    public void updateAttacks() {
        if (equippedWeapon != null) {
            Attacks[] weaponAttacks = equippedWeapon.getAttacks();
            for (int i = 0; i < weaponAttacks.length && i < attacks.length; i++) {
                if (weaponAttacks[i] != null) {
                    attacks[i] = weaponAttacks[i];
                }
            }
        }
    }

    public void clearWeaponAttacks() {
        for (int i = 0; i < attacks.length; i++) {
            attacks[i] = null;
        }
    }

}

