public abstract class PrintJob implements Chargeable {
    private String id;
    private int pages;

    //constructor
protected PrintJob(String id, int pages) {
    if (pages <= 0) {
        throw new IllegalArgumentException("Number of pages must be positive");
    }
    this.id = id;
    this.pages = pages;
    }

    //getter methods
    public String getId() {
        return id;
    }
    public int getPages() {
        return pages;
    }

    //override
    @Override 
    public abstract int calculateCharge();

    //overload
    public int calculateCharge(int copies) {
        if (copies <= 0) {
            throw new IllegalArgumentException("Number of copies must be positive");
        }
        return copies * calculateCharge();
    }

    //methods
    public String label(){
        return "Print";
    }

    public String summary(){
        return id + " | " + label() + "|" + calculateCharge();
    }
}
