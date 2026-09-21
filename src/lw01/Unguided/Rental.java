package lw01.Unguided;
public abstract class Rental implements Chargeable {
    private String id;
    private int days;

    protected Rental(String id, int days) {
        if (days > 30) {
            throw new IllegalArgumentException("Number of days must be between 1 and 30");
        }
        this.id = id;
        this.days = days;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }
    
    @Override 
    public abstract int calculateCharge();

    //overload
    public int calculateCharge(int units) {
        if (units > 10) {
            throw new IllegalArgumentException("Number of units must be between 1 and 10");
        }
        return units * calculateCharge();
    }

    public String label(){
        return "Rental";
    }

    public String summary(){
        return id + " | " + label() + "|" + calculateCharge();
    }
}
