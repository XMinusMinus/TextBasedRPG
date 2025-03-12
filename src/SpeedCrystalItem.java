public class SpeedCrystalItem extends EquipableItems{
    public SpeedCrystalItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void EquipItem(CharClass character){
        character.modifyStat("Speed", 10);
        this.IsEquipped = true;
    }

    @Override
    public void UnequipItem(CharClass character)
    {
        character.modifyStat("Speed", -10);
        this.IsEquipped = false;
    }

}
