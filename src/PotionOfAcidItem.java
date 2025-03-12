public class PotionOfAcidItem extends Item{
    public PotionOfAcidItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void UseItem(CharClass character,Npc npc){
        System.out.println(character.GetName()+ "used the potion of acid on "+npc.GetName()+" which lowered there attack and defense by 10.");
        npc.modifyStat("Attack",-10);
        npc.modifyStat("Defense",-10);
        setItemAmount(-1);
    }
}
