public class ShieldOfHonorItem extends WepondItem{

    public ShieldOfHonorItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue, AttackTypes attackTypes, int wepondDamage) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue, attackTypes, wepondDamage);
    }
    @Override
    public void WepondActionOnEquip(CharClass character){
        character.modifyStat("Attack",5);
        character.modifyStat("Defense",32);
        character.addAttack(new Attacks(AttackTypes.RANGED, "Shield Throw", 30, 1,5));
        character.addAttack(new Attacks(AttackTypes.MELEE, "Shield Bash", 15,1,5));
    }

    @Override
    public void WepondActionOnUnEquip(CharClass character){
        character.setStat("Defense", -24);
        character.setStat("Attack", -12);
        character.removeAttack("Shield Throw");
        character.removeAttack("Shield Bash");
    }
}
