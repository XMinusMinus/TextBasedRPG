public class BombItem extends Item{
    public BombItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void UseItem(CharClass character,Npc npc){
        System.out.println(character.GetName()+ "used bomb on "+npc.GetName()+" which dealt 300 damage.");
        npc.modifyStat("HP",-300);
        setItemAmount(-1);
    }
}
