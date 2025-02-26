class Stat {
    private String name;
    private double value;

    public Stat(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void modifyValue(double amount) {
        this.value += amount;
    }

    @Override
    public String toString() {
        return name + ": " + value;
    }
}