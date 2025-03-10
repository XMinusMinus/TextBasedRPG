public class RageGloveItem extends EquipableItems{
    private double attackapplied;
    public RageGloveItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void EquipItem(CharClass character){
        attackapplied = character.getStat("MAXHP") - character.getStat("HP");
        character.modifyStat("Attack",attackapplied);
    }

    @Override
    public void UnequipItem(CharClass character)
    {
        character.modifyStat("Attack",-attackapplied);
    }
}
