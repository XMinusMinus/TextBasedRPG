public class BowItem extends WepondItem{

    public BowItem(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue, AttackTypes attackTypes, int wepondDamage) {
        super(name, amount, weight, value, isConsumable, isMainHandEquipable, isOffHandEquipable, rarityValue, attackTypes, wepondDamage);
    }
    @Override
    public void WepondActionOnEquip(CharClass character){
        character.modifyStat("Attack",10);
        character.addAttack(new Attacks(AttackTypes.RANGED, "Normal Shot", 15, 70,5));
        character.addAttack(new Attacks(AttackTypes.RANGED, "Super Shot", 25,50,10));
    }

    @Override
    public void WepondActionOnUnEquip(CharClass character){
        character.modifyStat("Attack",-10);
        character.removeAttack("Normal Shot");
        character.removeAttack("Super Shot");
    }
    @Override
    public void WepondActionOnUse(CharClass character, Npc npc){

    }
}
