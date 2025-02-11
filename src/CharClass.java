import java.util.List;

public class CharClass extends Character{
    private Stats stats;
    private String[] backpack = new String[32];
    private Attacks[] attacks = new Attacks[5];
    private ClassTypes classType;
    private int charStanima;
    private int charMaxStanima;
    private List<Item> inventory;

    public CharClass(String name, Professions profession, int charMaxStanima) {

        super(name, profession, charMaxStanima);
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
            //target.TakeDamage(damage, attack.getAttackType());
            return attack.toString() + " did " + damage + " to " + target.toString();
        }
        else{
            return super.GetName() + " Does not have stamina for this move";
        }
    }

    public Attacks[] getAttacks()
    {
        return attacks;
    }

    public int getcharStanima(){
        return this.charStanima;
    }
    public int getcharMaxStanima(){
        return this.charMaxStanima;
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

    public void ChooseDialogOption(int option){

    }

    public void PresentDialogOption(String dialog){

    }
}
