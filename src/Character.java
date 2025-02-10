public abstract class Character {
    private String name;
    private Professions profession;
    private Stats stats;

    public Character(String name, Professions professions, int charMaxStanima){
        this.name = name;
        this.profession = professions;
        this.stats = new Stats() {};
    }
    public double getStats(String statName) {
        return stats.getStat(statName);
    }

    public String GetName()
    {
        return name;
    }

    public Professions GetProfession()
    {
        return profession;
    }



}
