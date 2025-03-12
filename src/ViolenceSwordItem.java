public class ViolenceSwordItem extends WepondItem{

    public ViolenceSwordItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue, AttackTypes attackTypes, int wepondDamage) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue, attackTypes, wepondDamage);
    }
    @Override
    public void WepondActionOnEquip(CharClass character){
        character.modifyStat("Attack",40);
        character.addAttack(new Attacks(AttackTypes.MELEE, "Violence Slash", 40, 90,5));
        character.addAttack(new Attacks(AttackTypes.MELEE, "Violence Plunge", 100,40,10));
    }

    @Override
    public void WepondActionOnUnEquip(CharClass character){
        character.modifyStat("Attack",-40);
        character.removeAttack("Violence Slash");
        character.removeAttack("Violence Plunge");
    }
    @Override
    public void WepondActionOnUse(CharClass character, Npc npc){

    }
}
