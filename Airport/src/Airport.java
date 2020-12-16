import java.util.ArrayList;

//represents Airport 
public class Airport {
    private ArrayList<Plane> listOfPlanes;
    private ArrayList<Flight> listOfFlights;

    public Airport() {
        this.listOfFlights = new ArrayList<Flight>();
        this.listOfPlanes = new ArrayList<Plane>();
    }

    //adds an airplane
    public void addPlane(Plane plane) {
        this.listOfPlanes.add(plane);
    }

    //adds a flight
    public void addFlight(Flight flight) {
        this.listOfFlights.add(flight);
    }

    //print the list of planes
    public void printPlanes() {
        for (Plane p : this.listOfPlanes) {
            System.out.println(p);
        }
    }

    //print the list of flights
    public void printFlights() {
        for (Flight fl : this.listOfFlights) {
            System.out.println(fl);
        }
    }

    //given an ID, finds the plane
    public Plane findPlane(String id) {
        for (Plane p : this.listOfPlanes) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

}
