import java.util.ArrayList;

public class Airport {
    private ArrayList<Plane> listOfPlanes;
    private ArrayList<Flight> listOfFlights;

    public Airport(ArrayList<Plane> listOfPlanes, ArrayList<Flight> listOfFlights) {
        this.listOfFlights = listOfFlights;
        this.listOfPlanes = listOfPlanes;
    }

    public void addPlane(Plane plane) {
        this.listOfPlanes.add(plane);
    }

    public void addFlight(Flight flight) {
        this.listOfFlights.add(flight);
    }

    public void printPlanes() {
        for (Plane p : this.listOfPlanes) {
            System.out.println(p);
        }
    }

    public void printFlights() {
        for (Flight fl : this.listOfFlights) {
            System.out.println(fl);
        }
    }

    public Plane findPlane(String id) {
        for (Plane p : this.listOfPlanes) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

}
