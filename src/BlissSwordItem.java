public class BlissSwordItem extends WepondItem{

    public BlissSwordItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue, AttackTypes attackTypes, int wepondDamage) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue, attackTypes, wepondDamage);
    }
    @Override
    public void WepondActionOnEquip(CharClass character){
        character.modifyStat("Attack",220);
        character.addAttack(new Attacks(AttackTypes.MELEE, "Blissful Attack", 220, 90,5));
        character.addAttack(new Attacks(AttackTypes.MELEE, "Yin & Yang Fang", 500,40,10));
        character.addAttack(new Attacks(AttackTypes.MELEE, "Enlightenment", 5000,20,40));
    }

    @Override
    public void WepondActionOnUnEquip(CharClass character){
        character.modifyStat("Attack",-220);
        character.removeAttack("Blissful Attack");
        character.removeAttack("Yin & Yang Fang");
        character.removeAttack("Enlightenment");
    }
    @Override
    public void WepondActionOnUse(CharClass character, Npc npc){

    }
}
