public class SmokeBombItem extends Item{
    public SmokeBombItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void UseItem(CharClass character,Npc npc){
        System.out.println(character.GetName()+ "used smoke bomb on "+npc.GetName()+" which lowered there speed by 10.");
        npc.modifyStat("Speed",-10);
        setItemAmount(-1);
    }
}
