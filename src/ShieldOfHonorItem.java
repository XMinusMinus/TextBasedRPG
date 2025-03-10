public class ShieldOfHonorItem extends WepondItem{

    public ShieldOfHonorItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue, AttackTypes attackTypes, int wepondDamage) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue, attackTypes, wepondDamage);
    }
    @Override
    public void WepondActionOnEquip(CharClass character){
        character.setStat("Defense", 24);
        character.setStat("Attack", 12);
        Attacks[] attacks = new Attacks[]{
                new Attacks(AttackTypes.RANGED, "Shield Throw", 30, 1),
                new Attacks(AttackTypes.MELEE, "Shield Bash", 15,1)
        };
        setAttacks(attacks);
        character.updateAttacks();
    }
    @Override
    public void WepondActionOnUnEquip(CharClass character){
        character.setStat("Defense", -24);
        character.setStat("Attack", -12);
        character.clearWeaponAttacks();
    }
}
