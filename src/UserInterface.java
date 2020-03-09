import java.util.Scanner;

public class UserInterface {
    Scanner reader;
    private Airport airport;

    public UserInterface(Scanner reader, Airport port) {
        this.reader = reader;
        this.airport = port;
    }

    public void start() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println();
        while (true) {
            System.out.println("Choose operation:\n" +
                    "[1] Add airplane\n" +
                    "[2] Add flight\n" +
                    "[x] Exit");
            String cmd = this.reader.nextLine();
            if (cmd.equals("x")) {
                servicePart();
                break;
            } else if (cmd.equals("1")) {
                System.out.println("Give plane ID:");
                String id = this.reader.nextLine();
                System.out.println("Give plane capacity:");
                int cap = Integer.parseInt(this.reader.nextLine());
                this.airport.addPlane(new Plane(id, cap));
            } else if (cmd.equals("2")) {
                System.out.println("Give plane ID:");
                String id = this.reader.nextLine();
                System.out.println("Give departure airport code:");
                String depCode = this.reader.nextLine();
                System.out.println("Give destination airport code:");
                String destCode = this.reader.nextLine();
                Plane planeFound = this.airport.findPlane(id);
                this.airport.addFlight(new Flight(planeFound, depCode, destCode));
            }
        }
    }

    private void servicePart() {
        System.out.println();
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println();
        while (true) {
            System.out.println("Choose operation:\n" +
                    "[1] Print planes\n" +
                    "[2] Print flights\n" +
                    "[3] Print plane info\n" +
                    "[x] Quit");
            String cmd = this.reader.nextLine();
            if (cmd.equals("x")) {
                break;
            } else if (cmd.equals("1")) {
                this.airport.printPlanes();
            } else if (cmd.equals("2")) {
                this.airport.printFlights();
            } else if (cmd.equals("3")) {
                System.out.println("Give plane ID:");
                String id = this.reader.nextLine();
                Plane planeFound = airport.findPlane(id);
                System.out.println(planeFound);
            }
        }
    }
}
