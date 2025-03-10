public class EquipableItems extends Item{

    public boolean IsEquipped = false;

    public EquipableItems(String name, int amount, double weight, double value, boolean isConsumable, boolean isMainHandEquipable, boolean isOffHandEquipable, int rarityValue){
        super(name,amount,weight,value,isConsumable,isMainHandEquipable,isOffHandEquipable,rarityValue);
    }

    public void EquipItem(CharClass character){
    }
    public void UnequipItem(CharClass character){
    }
    public void EquipableActionWhenActive(CharClass character, Npc npc){

    }


}
