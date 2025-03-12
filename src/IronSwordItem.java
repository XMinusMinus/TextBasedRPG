public class IronSwordItem extends WepondItem{

    public IronSwordItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue, AttackTypes attackTypes, int wepondDamage) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue, attackTypes, wepondDamage);
    }
    @Override
    public void WepondActionOnEquip(CharClass character){
        character.modifyStat("Attack",20);
        character.addAttack(new Attacks(AttackTypes.MELEE, "Iron Sword Swipe", 10, 1,5));
        character.addAttack(new Attacks(AttackTypes.MELEE, "Iron Sword Blow", 11,1,5));
    }

    @Override
    public void WepondActionOnUnEquip(CharClass character){
        character.modifyStat("Attack",-20);
        character.removeAttack("Iron Sword Swipe");
        character.removeAttack("Iron Sword Blow");
    }
    @Override
    public void WepondActionOnUse(CharClass character, Npc npc){

    }
}
