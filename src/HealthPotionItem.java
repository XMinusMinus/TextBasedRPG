public class HealthPotionItem extends Item{

    public HealthPotionItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void UseItem(CharClass character,Npc npc){
        double playermax = character.getStat("MAXHP");
        double playercurrent = character.getStat("HP");
        double applyheal = playercurrent + 20;
        if(applyheal <= playermax){
            character.setStat("HP", applyheal);
            setItemAmount(-1);
        }
        else{
            character.setStat("HP", playermax);
            setItemAmount(-1);
        }
    }
}

