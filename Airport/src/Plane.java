//represents an Airplane
public class Plane {
    private String id;
    private int capacity;

    public Plane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public String toString() {
        return this.id + " (" + this.capacity + " ppl)";
    }

    public String getId() {
        return this.id;
    }
}
