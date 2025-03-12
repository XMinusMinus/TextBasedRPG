public class MaxStaminaPotionItem extends Item{
    public MaxStaminaPotionItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void UseItem(CharClass character,Npc npc){
        double playermax = character.getStat("StaminaMax");
        double playercurrent = character.getStat("Stamina");
        double applystamina = character.getStat("StaminaMax");;
        character.setStat("Stamina", applystamina);
        setItemAmount(-1);
    }
}
