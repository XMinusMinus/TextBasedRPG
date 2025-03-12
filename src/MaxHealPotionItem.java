public class MaxHealPotionItem extends Item{
    public MaxHealPotionItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void UseItem(CharClass character,Npc npc){
        double playermax = character.getStat("MAXHP");
        double playercurrent = character.getStat("HP");
        double applyheal = character.getStat("MAXHP");
        character.setStat("HP", applyheal);
        setItemAmount(-1);
    }
}
