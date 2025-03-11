public class World {
    private CharClass user;
    private double difficultyLevel;
    private Floor[] floors;
    private boolean isSpecial;
    private WorldType worldType;
    private int WorldNumber;
    private int currentFloorNumber = 1;
    private boolean worldPassed = false;

    //Complete the world
    public void PassWorld()
    {
        this.worldPassed = true;
        System.out.println("  ✦ ✧ ✦ WORLD CLEARED! ✦ ✧ ✦  ");
        System.out.println("══════════════════════════════");
        System.out.println(String.format("  You have conquered World #%d!  ", WorldNumber ));
        System.out.println("══════════════════════════════");
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
        System.out.println("Check Advance Floor has been ran");
        this.floors[this.currentFloorNumber-1].removeDeadMobs();
        Floor floor = this.floors[this.currentFloorNumber-1];

        Npc[] npcsLeft = floor.getRemainingMobs();
        System.out.println(npcsLeft.length);

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
     * Gets the amount of floors there are in the world
     * @return The amount of floors in a given world.
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
    }
}
