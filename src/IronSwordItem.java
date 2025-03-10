public class IronSwordItem extends WepondItem{

    public IronSwordItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue, AttackTypes attackTypes, int wepondDamage) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue, attackTypes, wepondDamage);
    }
    @Override
    public void WepondActionOnEquip(CharClass character){
        character.modifyStat("Attack",20);
        Attacks[] attacks = new Attacks[]{
                new Attacks(AttackTypes.MELEE, "Iron Sword Swipe", 10, 1),
                new Attacks(AttackTypes.MELEE, "Iron Sword Blow", 11,1)
        };
        setAttacks(attacks);
        character.updateAttacks();
      //  character.setStat("Attack", 60);
    }
    @Override
    public void WepondActionOnUnEquip(CharClass character){

        character.modifyStat("Attack",-20);
        character.clearWeaponAttacks();
    }
    @Override
    public void WepondActionOnUse(CharClass character, Npc npc){

    }
}
