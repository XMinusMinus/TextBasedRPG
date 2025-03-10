public class EvilElixerItem extends Item{

    public EvilElixerItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue);
    }

    @Override
    public void UseItem(CharClass character, Npc npc){
        double playerMaxHealth = character.getStat("HP");
        double applyHarm = playerMaxHealth - 20;
        character.setStat("MAXHP", applyHarm);
        double playerAttack = character.getStat("Attack");
        double applyDamageUp = playerAttack + 20;
        character.setStat("Attack", applyDamageUp);
        setItemAmount(-1);
    }
}