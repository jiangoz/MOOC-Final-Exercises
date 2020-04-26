import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // main program
        Scanner reader = new Scanner(System.in);
        Airport airport = new Airport();
        UserInterface userPanel = new UserInterface(reader, airport);
        userPanel.start();
    }
}
