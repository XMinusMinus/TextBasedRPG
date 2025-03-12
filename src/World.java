import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    private CharClass user;
    private double difficultyLevel;
    private Floor[] floors;
    private boolean isSpecial;
    private WorldType worldType;
    private int WorldNumber;
    private int currentFloorNumber = 1;
    private boolean worldPassed = false;
    private List<Item> WorldEndingLootPool = new ArrayList<>();

    //Complete the world
    public void PassWorld()
    {
        this.worldPassed = true;
        System.out.println("  ✦ ✧ ✦ WORLD CLEARED! ✦ ✧ ✦  ");
        System.out.println("══════════════════════════════");
        System.out.println(String.format("  You have conquered World #%d!  ", WorldNumber ));
        System.out.println("══════════════════════════════");
        AwardWorldPassItems();
    }

    private void AwardWorldPassItems() {
        Random rand = new Random();

        int randomIndex = rand.nextInt(WorldEndingLootPool.size());

        Item randomItem = WorldEndingLootPool.get(randomIndex);

        user.addItem(randomItem);

        System.out.println("Congratulations! You've received a " + randomItem.getItemName() + " for conquering the world!");
    }

    /**
     * Moves the player to the next level of the floor.
     * <br>
     * This is called in CheckAdvanceFloor, which is typically called at the end of a floor.
     */
    public void AdvanceFloor()
    {
        this.currentFloorNumber++;
        System.out.println("PASSED FLOOR");

        if (this.floors.length < currentFloorNumber)
        {
            System.out.println("PASSED WORLD");
            PassWorld();
        }
    }

    public boolean IsPassed()
    {
        return this.worldPassed;
    }

    public int getWorldNumber()
    {
        return this.WorldNumber;
    }

    /**
     * TODO: document when complete
     * <br>
     * This is called when you defeat an enemy guarding the door to the next floor, or pass by a passive NPC nearby to it.
     */
    public void CheckAdvanceFloor()
    {
        this.floors[this.currentFloorNumber-1].removeDeadMobs();
        Floor floor = this.floors[this.currentFloorNumber-1];

        Npc[] npcsLeft = floor.getRemainingMobs();

        for (Npc npc : npcsLeft)
        {
            if (npc.GetIsPassive() == false)
            {
                return;
            }
        }

        System.out.println("Test Message_4");
        this.AdvanceFloor();
        System.out.println("Test Message_5");
    }

    /**
     * Resets the current floor.
     * <br>
     * This is called whenever the Player blacks out in battle.
     */
    public void GameLossFloorReset()
    {
        this.currentFloorNumber--;
    }

    //region Gets
    /**
     * Gets the current Player.
     * @return The current Player.
     */
    public CharClass getUser(){
        return this.user;
    }
    /**
     * Gets the difficulty level of the current world.
     * @return The difficulty level of the current world.
     */
    public double getDifficultyLevel(){
        return this.difficultyLevel;
    }
    /**
     * Gets the 1 of floors there are in the world
     * @return The 1 of floors in a given world.
     */
    public int getFloorNumber(){return this.floors.length;}
    /**
     * Gets the number of the current floor the Player is on.
     * @return The number of the floor the Player is on.
     */
    public int getCurrentFloorNumber(){
        return this.currentFloorNumber;
    }
    /**
     * Gets the current floor's remaining NPCs.
     * @return Each NPC remaining in the floor, in the form of an array.
     */
    public Npc[] getCurrentFloorNpcs(){
        return this.floors[this.currentFloorNumber - 1].getRemainingMobs();
    }

    public Npc getCurrentNpc()
    {
        Npc[] remainingNpcs = getCurrentFloorNpcs();
        Npc currentNPC = null;
        System.out.println("Getting current NPC");

        for (Npc n : remainingNpcs)
        {
            if (n.getStat("HP") > 0)
            {
                currentNPC = n;
                break;
            }
        }

        return currentNPC;
    }

    /**
     * Gets whether the world is special or not
     * @return Whether the world is special or not.
     */
    public boolean isSpecial(){
        return this.isSpecial;
    }
    /**
     * Gets the type of world it is.
     * @return The type of world.
     */
    public WorldType getWorldType(){
        return this.worldType;
    }
    //endregion

    // constructor
    public World(CharClass user, double difficultyLevel, Floor[] floors, boolean isSpecial, WorldType worldType, int worldNumber){
        this.user = user;
        this.difficultyLevel = difficultyLevel;
        this.floors = floors;
        this.isSpecial = isSpecial;
        this.worldType = worldType;
        this.WorldNumber = worldNumber;
        
        WorldEndingLootPool.add(new HealthPotionItem("Health Potion", 1, 0.5, 50, true, false, false, 0));
        WorldEndingLootPool.add(new IronSwordItem("Iron Sword", 1, 5.0, 100, false, true, true, 0, AttackTypes.MELEE, 20));
        WorldEndingLootPool.add(new ShieldOfHonorItem("Shield of Honor", 1, 5.0, 100, false, true, true, 0, AttackTypes.MELEE, 20));
        WorldEndingLootPool.add(new StaminaPotionItem("Stamina Potion", 1, 0.5, 50, true, false, false, 1));
        WorldEndingLootPool.add(new GoldenDaggerItem("Gold Dagger", 1, 0.5, 50, false, true, true, 1, AttackTypes.MELEE, 20));
        WorldEndingLootPool.add(new ViolenceSwordItem("Sword of Violence", 1, 5, 50, false, true, true, 2, AttackTypes.MELEE, 100));
        WorldEndingLootPool.add(new VoidSwordItem("Sword of The Void", 1, 5, 150, false, true, true, 3, AttackTypes.MELEE, 200));
        WorldEndingLootPool.add(new VengeanceSwordItem("Sword of Vengeance", 1, 5, 550, false, true, true, 4, AttackTypes.MELEE, 400));
        WorldEndingLootPool.add(new BlissSwordItem("Sword of Bliss", 1, 5, 1050, false, true, true, 5, AttackTypes.MELEE, 600));
        WorldEndingLootPool.add(new BowItem("Long Bow", 1, 10, 100, false, true, false, 1, AttackTypes.RANGED, 20));
        WorldEndingLootPool.add(new BowItem("Short Bow", 1, 5, 100, false, true, false, 1, AttackTypes.RANGED, 15));
        WorldEndingLootPool.add(new DefenseCrystalEquippable("Defense Crystal", 1, 0.5, 50, false, false, false, 3));
        WorldEndingLootPool.add(new ZweihanderItem("Zweihander", 1, 5.0, 100, false, true, true, 0, AttackTypes.MELEE, 20));
        WorldEndingLootPool.add(new EvilElixerItem("Evil Potion", 1, 0.5, 50, true, false, false, 1));
        WorldEndingLootPool.add(new RageGloveItem("Rage Gloves", 1, 0.5, 50, false, false, false, 3));
        WorldEndingLootPool.add(new AttackCrystalItem("Attack Crystal", 1, 0.5, 50, false, false, false, 3));
        WorldEndingLootPool.add(new SpeedCrystalItem("Speed Crystal", 1, 0.5, 50, false, false, false, 3));
        WorldEndingLootPool.add(new HpCrystalItem("HP Crystal", 1, 0.5, 50, false, false, false, 3));
        WorldEndingLootPool.add(new HpCrystalItem("Stamina Crystal", 1, 0.5, 50, false, false, false, 3));
        WorldEndingLootPool.add(new StatAllCrystalItem("Statall Crystal", 1, 0.5, 50, false, false, false, 3));
        WorldEndingLootPool.add(new MaxHealPotionItem("Maxheal Potion", 1, 0.5, 50, false, false, false, 3));
        WorldEndingLootPool.add(new MaxStaminaPotionItem("Maxstamina Potion", 1, 0.5, 50, false, false, false, 3));
        WorldEndingLootPool.add(new SmokeBombItem("Smoke Bomb", 1, 0.5, 50, false, false, false, 3));
        WorldEndingLootPool.add(new BombItem("Bomb", 1, 0.5, 50, false, false, false, 3));
        WorldEndingLootPool.add(new PotionOfAcidItem("Potion of Acid", 1, 0.5, 50, false, false, false, 3));
        WorldEndingLootPool.add(new PureDivinityItem("Pure Divinity", 1, 0.5, 50, false, false, false, 3));
    }
}
