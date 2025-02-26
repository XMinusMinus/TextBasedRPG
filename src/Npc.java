import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class Npc {
    //region Variables
    /**
     * The name of the NPC.
     */
    private String name;
    /**
     * A basic description of the NPC.
     */
    private String description;
    /**
     * Determines whether the given NPC is considered "Passive".
     */
    private Boolean isPassive;
    /**
     * The stats the NPC has.
     * @See Stats
     */
    private Stats stats;
    /**
     * The dialogue the NPC can say.
     * <br>
     * The dialogue is stored in a HashMap, with a String key and String value.
     * <br>Ex. "introduceSelf", "Hello! I'm the NPC you're talking to!"
     * <br><br>
     * Since GetDialogueFromSubstring exists, I would recommend giving your keys
     * a specific meaning and rhythm. Ex. if you want random idle dialogue, then
     * start your key with "RandomIdle" and give it associated numbers after that
     * ("RandomIdle1", "RandomIdle2", ect.).
     * <br><br>
     * BE CAREFUL WITH WHAT YOU LOOK FOR IN KEYS! I can see this system going haywire
     * if you look for substring "Random" in a hashmap full of "RandomIdle",
     * "ContainsRandom", and a bunch of other things which might also contain the word
     * "Random".
     */
    private HashMap<String, String> dialogue;

    private Attacks[] attacks = new Attacks[5];
    //endregion

    public Npc(String name, String description, Boolean isPassive, Stats stats, HashMap<String, String> dialogue, Attacks[] attacks) {
        this.name = name;
        this.description = description;
        this.isPassive = isPassive;
        this.stats = stats;
        this.dialogue = dialogue;
        this.attacks = attacks;
    }

    //region Name Get/Sets
    /**
     * Gets the name of the NPC.
     * @return The NPCs current name.
     */
    public String GetName()
    {
        return name;
    }
    /**
     * Sets the name of the NPC.
     * @param name The new name of the NPC.
     */
    public void SetName(String name)
    {
        this.name = name;
    }
    //endregion
    //region Description Get/Sets
    /**
     * Gets the description of the NPC.
     * @return The description of the NPC.
     */
    public String GetDescription()
    {
        return description;
    }
    /**
     * Sets the description of the NPC.
     * @param description The new description of the NPC.
     */
    public void SetDescription(String description)
    {
        this.description = description;
    }
    //endregion
    //region IsPassive Get/Sets
    /**
     * Gets the value determining if the NPC is passive.
     * @return Whether the NPC is passive or not.
     */
    public Boolean GetIsPassive()
    {
        return isPassive;
    }
    /**
     * Sets if the NPC is passive or not.
     * @param isPassive Whether the NPC is passive or not.
     */
    public void SetName(Boolean isPassive)
    {
        this.isPassive = isPassive;
    }
    //endregion
    //region Stat Get/Sets
    /**
     * Gets all stats.
     * @return All stats.
     */
    public Stats GetAllStats()
    {
        return stats;
    }
    /**
     * Replaces all stats with new ones.
     * @param stats The new stats.
     */
    public void SetAllStats(Stats stats)
    {
        this.stats = stats;
    }
    /**
     * Gets a stat based on the given key input.
     * @param statName The key of the stat you wish to get.
     * @return The value of the stat.
     */
    public double GetSpecificStat(String statName)
    {
        return stats.getStat(statName);
    }
    /**
     * Sets a stat based on the given key input.
     * @param statName The key of the stat you wish to set.
     * @param value The value you wish to set the stat to.
     */
    public void SetSpecificStat(String statName, double value)
    {
        this.stats.setStat(statName, value);
    }
    //endregion
    //region Dialogue Get/Sets
    /**
     * Gets the dialogue HashMap.
     * @return The dialogue HashMap.
     */
    public double getStat(String statName) {
        return stats.getStat(statName);
    }

    public void setStat(String statName, double value) {
        stats.setStat(statName, value);
    }
    public HashMap<String, String> GetAllDialogue()
    {
        return dialogue;
    }
    /**
     * Replaces the dialogue HashMap with a new one.
     * @param dialogue The new HashMap.
     */
    public void SetAllDialogue(HashMap<String, String> dialogue)
    {
        this.dialogue = dialogue;
    }

    /**
     * Adds dialogue to the dialogue HashMap.
     * @param dialogueKey The key to the added element.
     * @param dialogueToAdd The dialogue associated with the key.
     */
    public void AddDialogue(String dialogueKey, String dialogueToAdd) {
        this.dialogue.put(dialogueKey, dialogueToAdd);
    }
    /**
     * Adds dialogue to the dialogue HashMap.
     * @param dialogueHashmap A HashMap containing any number of keys and dialogue entries.
     */
    public void AddDialogue(HashMap<String, String> dialogueHashmap) {
        for (String dialogueInstanceKey : dialogueHashmap.keySet()) {
            this.dialogue.put(dialogueInstanceKey, dialogueHashmap.get(dialogueInstanceKey));
        }
    }
    // removedialogue might be nice to have, but how would it work? requires discussion

    /**
     * Returns the dialogue associated with a given key.
     * @param key The key associated with the desired line of dialogue.
     * @return The line of dialogue.
     */
    public String GetSpecificDialogue(String key) {
        return dialogue.get(key);
    }

    /**
     * Returns all outputs associated with a key containing a given substring.
     * @param substring The substring to look for.
     * @return A List of dialogue instances whose key contains the substring input.
     */
    public List<String> GetSpecificDialogueFromSubstring(String substring) {
        List<String> output = new ArrayList<String>();
        for (String key : dialogue.keySet()) {
            if (key.contains(substring)) {
                output.add(dialogue.get(key));
            }
        }
        return output;
    }
    //endregion
    public String Attack(Attacks attack, CharClass target, Npc npc)
    {

               double damage = attack.getBaseDamage();
               double plyCurrentHP = target.getStat("HP");
               double damageCal = damage * npc.getStat("Attack") / target.getStat("Defense");
               double afterAttack = plyCurrentHP - damageCal;
               target.setStat("HP", afterAttack);
               return GetName() + " used " + attack.toString() + " which did " + damage + " to " + target.toString();

    }
    public Attacks[] getAttacks()
    {
        return attacks;
    }

    public void choseRandomAttack(CharClass target, Npc npc){
        Attacks[] attacks = getAttacks();
        Random rand = new Random();
        int index = rand.nextInt(attacks.length);
        Attack(attacks[index],target, npc);
    }

    @Override
    public String toString(){return GetName();}
}
