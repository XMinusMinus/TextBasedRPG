import java.util.ArrayList;
import java.util.List;

public class CharClass extends Character{
    private Stats stats;
    private String[] backpack = new String[32];
    private Attacks[] attacks = new Attacks[5];
    private ClassTypes classType;
    private int charStanima;
    private int charMaxStamina;
    private List<Item> inventory;

    public CharClass(String name, Professions profession, int charMaxStamina, Stats stats, Attacks[] attacks) {

        super(name, profession, charMaxStamina, stats);
        this.inventory = new ArrayList<>();
        this.attacks = attacks;
    }

    @Override
    public String toString() {
        return super.GetName() + ", the " + super.GetProfession().toString();
    }

    public String Attack(Attacks attack, Npc target)
    {
        if(getcharStanima() >= attack.getAttackStanUsage()) {
            double damage = attack.getBaseDamage() * this.classType.getDamageMultiplier(attack.getAttackType());
            setStanima(attack.getAttackStanUsage());
            double npcCurrentHP = target.getStat("HP");
            double afterAttack = npcCurrentHP - damage;
            target.setStat("HP",afterAttack);
            //target.TakeDamage(damage, attack.getAttackType());
            return super.GetName() +" used "+ attack.toString() + " which did " + damage + " to " + target.toString();
        }
        else{
            return super.GetName() + " Does not have stamina for this move";
        }
    }

    public Attacks[] getAttacks()
    {
        return attacks;
    }

    public double getcharStanima(){
        return getStat("Stanima");
    }
    public double getcharMaxStanima(){
        return getStat("StanimaMax");
    }
    public void setStanima(int deduction){
         this.charStanima = this.charStanima - deduction;
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
}
