public class PureDivinityItem extends Item{
    public PureDivinityItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void UseItem(CharClass character,Npc npc){
        System.out.println(character.GetName()+ "used Pure Divinity which increased there attack, defense and speed by 5 points.");
        character.modifyStat("Speed",5);
        character.modifyStat("Attack",5);
        character.modifyStat("Defense",5);
        setItemAmount(-1);
    }
}
