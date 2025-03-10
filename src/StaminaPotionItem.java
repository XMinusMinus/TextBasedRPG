public class StaminaPotionItem extends Item{

    public StaminaPotionItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void UseItem(CharClass character, Npc npc){
        double playermax = character.getStat("StanimaMax");
        double playercurrent = character.getStat("Stanima");
        double applystamina = playercurrent + 20;
        if(applystamina <= playermax){
            character.setStat("Stanima", applystamina);
            setItemAmount(-1);
        }
        else{
            character.setStat("Stanima", playermax);
            setItemAmount(-1);
        }
    }
}
