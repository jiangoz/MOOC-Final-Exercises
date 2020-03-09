import java.util.*;

public class Program {
    private Map<String, Person> personNameList;
    private Scanner reader;

    public Program(Scanner reader) {
        this.reader = reader;
        this.personNameList = new HashMap<String, Person>();
    }

    public void start() {
        System.out.println("phone search\n" +
                "available operations:\n" +
                " 1 add a number\n" +
                " 2 search for a number\n" +
                " 3 search for a person by phone number\n" +
                " 4 add an address\n" +
                " 5 search for personal information\n" +
                " 6 delete personal information\n" +
                " 7 filtered listing\n" +
                " x quit\n");

        while (true) {
            System.out.print("command: ");
            String cmd = reader.nextLine();
            if (cmd.equals("x")) {
                return;
            } else if (cmd.equals("1")) {
                op1();
            } else if (cmd.equals("2")) {
                op2();
            } else if (cmd.equals("3")) {
                op3();
            } else if (cmd.equals("4")) {
                op4();
            } else if (cmd.equals("5")) {
                op5();
            } else if (cmd.equals("6")) {
                op6();
            } else if (cmd.equals("7")) {
                op7();
            }

        }
    }

    public void op7() {
        System.out.print("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        List<Person> founded = new ArrayList<Person>();

        for (Person p : personNameList.values()) {
            if (p.containsKeyWord(keyword)) {
                founded.add(p);
            }
        }
        if (founded.isEmpty()) {
            System.out.println(" keyword not found");
            return;
        }
        //Collections.sort(founded,new SortPersonByName());  -- THIS WORKS TOO
        //founded.sort(new SortPersonByName());  --THIS WORKS TOO
        Collections.sort(founded);

        for (Person p : founded) {
            System.out.println(" " + p.getName());
            if (p.hasAddress()) {
                System.out.println("  address: " + p.getAddress());
            } else {
                System.out.println("  address unknown");
            }
            if (p.hasPhoneNumber()) {
                System.out.println("  phone numbers:");
                p.printPhoneNumbersExtraSpace();
            } else {
                System.out.println("  phone number not found\n");
            }
        }

        System.out.println();

    }

    public void op6() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        this.personNameList.remove(name);
    }

    public void op5() {
        System.out.print("whose information: ");
        String name = reader.nextLine();
        if (this.personNameList.containsKey(name)) {
            Person foundPerson = this.personNameList.get(name);
            if (foundPerson.hasAddress()) {
                System.out.println("  address: " + foundPerson.getAddress());
            } else {
                System.out.println("  address unknown");
            }
            if (foundPerson.hasPhoneNumber()) {
                System.out.println("  phone numbers:");
                foundPerson.printPhoneNumbersExtraSpace();
            } else {
                System.out.println("  phone number not found");
            }
        } else {
            System.out.println("  not found");
        }
        System.out.println();
    }

    public void op4() {
        System.out.print("whose address: ");
        String name = reader.nextLine();
        System.out.print("street: ");
        String street = reader.nextLine();
        System.out.print("city: ");
        String city = reader.nextLine();

        if (!this.personNameList.containsKey(name)) {
            personNameList.put(name, new Person(name));
        }
        personNameList.get(name).setAddress(new Address(street, city));
        System.out.println();
    }

    public void op1() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();

        if (!this.personNameList.containsKey(name)) {
            this.personNameList.put(name, new Person(name));
        }
        personNameList.get(name).addNumber(number);
        System.out.println();
    }

    public void op2() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        if (!this.personNameList.containsKey(name)) {
            System.out.println("  not found");
        } else {
            this.personNameList.get(name).printPhoneNumbers();
        }
        System.out.println();
    }

    public void op3() {
        System.out.print("number: ");
        String number = reader.nextLine();
        for (Person p : personNameList.values()) {
            if (p.hasNumber(number)) {
                System.out.println(" " + p.getName() + "\n");
                return;
            }
        }
        System.out.println(" not found\n");
    }
}
