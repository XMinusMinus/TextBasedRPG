public class StatAllCrystalItem extends EquipableItems{
    public StatAllCrystalItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void EquipItem(CharClass character){
        character.modifyStat("MAXHP", 200);
        character.modifyStat("HP", 200);
        character.modifyStat("Attack", 20);
        character.modifyStat("Defense", 20);
        character.modifyStat("Speed", 20);
        character.modifyStat("StaminaMax", 100);
        character.modifyStat("Stamina", 100);
        this.IsEquipped = true;
    }

    @Override
    public void UnequipItem(CharClass character)
    {
        character.modifyStat("MAXHP", -200);
        character.modifyStat("HP", -200);
        character.modifyStat("Attack", -20);
        character.modifyStat("Defense", -20);
        character.modifyStat("Speed", -20);
        character.modifyStat("MAXHP", -200);
        character.modifyStat("HP", -200);
        character.modifyStat("StaminaMax", -100);
        character.modifyStat("Stamina", -100);
        this.IsEquipped = false;
    }
}
