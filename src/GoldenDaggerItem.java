public class GoldenDaggerItem extends WepondItem{

    public GoldenDaggerItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue, AttackTypes attackTypes, int wepondDamage) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue, attackTypes, wepondDamage);
    }
    @Override
    public void WepondActionOnEquip(CharClass character){
        character.modifyStat("Attack",10);
        character.addAttack(new Attacks(AttackTypes.MELEE, "Golden Stab", 5, 1,5));
        character.addAttack(new Attacks(AttackTypes.MELEE, "Golden Pierce", 15,1,5));
    }

    @Override
    public void WepondActionOnUnEquip(CharClass character){
        character.modifyStat("Attack", -10);
        character.removeAttack("Golden Stab");
        character.removeAttack("Golden Pierce");
    }
    @Override
    public void WepondActionOnUse(CharClass character, Npc npc){

    }
}
