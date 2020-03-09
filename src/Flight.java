public class Flight {
    private Plane plane;
    private String departure;
    private String destination;

    public Flight(Plane plane, String depart, String dest) {
        this.plane = plane;
        this.departure = depart;
        this.destination = dest;
    }

    public String toString() {
        return this.plane + " (" + this.departure + "-" + this.destination + ")";
    }
}
