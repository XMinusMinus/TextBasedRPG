public class HpCrystalItem extends EquipableItems {
    public HpCrystalItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void EquipItem(CharClass character){
        character.modifyStat("MAXHP", 100);
        character.modifyStat("HP", 100);
        this.IsEquipped = true;
    }

    @Override
    public void UnequipItem(CharClass character)
    {
        character.modifyStat("MAXHP", -100);
        character.modifyStat("HP", -100);
        this.IsEquipped = false;
    }

}
