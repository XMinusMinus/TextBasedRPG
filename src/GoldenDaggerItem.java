public class GoldenDaggerItem extends WepondItem{

    public GoldenDaggerItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue, AttackTypes attackTypes, int wepondDamage) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue, attackTypes, wepondDamage);
    }
    @Override
    public void WepondActionOnEquip(CharClass character){
        character.modifyStat("Attack",10);
        Attacks[] attacks = new Attacks[]{
                new Attacks(AttackTypes.MELEE, "Golden Stab", 5, 1),
                new Attacks(AttackTypes.MELEE, "Golden Pierce", 15,1)
        };
        setAttacks(attacks);
        character.updateAttacks();
    }
    @Override
    public void WepondActionOnUnEquip(CharClass character){
        character.modifyStat("Attack", -10);
        character.clearWeaponAttacks();
    }
    @Override
    public void WepondActionOnUse(CharClass character, Npc npc){

    }
}
