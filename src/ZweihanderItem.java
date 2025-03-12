public class ZweihanderItem extends WepondItem{

    public ZweihanderItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue, AttackTypes attackTypes, int wepondDamage) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue, attackTypes, wepondDamage);
    }

    @Override
    public void WepondActionOnEquip(CharClass character){
        character.modifyStat("Attack",5);
        character.modifyStat("Defense",32);
        character.addAttack(new Attacks(AttackTypes.RANGED, "Z-Move", 500, 1,5));
    }


    @Override
    public void WepondActionOnUnEquip(CharClass character){
        character.modifyStat("Attack",-5);
        character.modifyStat("Defense",-32);
        character.removeAttack("Z-Move");
    }
}
