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
        System.out.println(String.format("  You have conquered World #%d!  ", WorldNumber));
        System.out.println("══════════════════════════════");
    }

    //Increases the floor level
    public void AdvanceFloor()
    {
        this.currentFloorNumber++;

        if (this.floors.length < currentFloorNumber)
        {
            PassWorld();
        }
    }
    public void GameLossFloorReset()
    {
        this.currentFloorNumber--;
    }

    //Gets the current user
    public CharClass getUser(){
        return this.user;
    }

    //Gets the world's difficulty level
    public double getDifficultyLevel(){
        return this.difficultyLevel;
    }

    //Gets the amount of floors there are on the world
    public int getFloorNumber(){
        return this.floors.length;
    }

    //Gets the amount of floors there are on the world
    public int getCurrentFloorNumber(){
        return this.currentFloorNumber;
    }

    //Returns the current floor's remaining npcs
    public Npc[] getCurrentFloorNpcs(){
        return this.floors[this.currentFloorNumber - 1].getRemainingMobs();
    }

    //Gets whether the world is special or not
    public boolean isSpecial(){
        return this.isSpecial;
    }

    //Gets the type of world it is
    public WorldType getWorldType(){
        return this.worldType;
    }

    //
    public World(CharClass user, double difficultyLevel, Floor[] floors, boolean isSpecial, WorldType worldType){
        this.user = user;
        this.difficultyLevel = difficultyLevel;
        this.floors = floors;
        this.isSpecial = isSpecial;
        this.worldType = worldType;
    }
}
