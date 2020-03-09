import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person implements Comparable<Person> {

    private String name;
    private List<String> phoneNumbers;
    private Address address;

    public Person(String name) {
        this.name = name;
        this.phoneNumbers = new ArrayList<String>();
        this.address = new Address("", "");
    }

    public List<String> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public void printPhoneNumbers() {
        for (String num : phoneNumbers) {
            System.out.println(" " + num);
        }
    }

    public void printPhoneNumbersExtraSpace() {
        for (String num : phoneNumbers) {
            System.out.println("   " + num);
        }
    }

    public void addNumber(String number) {
        this.phoneNumbers.add(number);
    }

    public boolean hasNumber(String number) {
        for (String num : this.phoneNumbers) {
            if (num.equals(number)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean hasAddress() {
        return !address.getStreet().isEmpty() && !address.getCity().isEmpty();
    }

    public String getAddress() {
//        if (address.getStreet().equals("")||address.getCity().equals("")){
//            return "address unknown";
//        }
        return address.getStreet() + " " + address.getCity();
    }

    public boolean hasPhoneNumber() {
        return !this.phoneNumbers.isEmpty();
    }

    public boolean containsKeyWord(String keyword) {
        return this.name.contains(keyword) || this.address.contains(keyword);
    }


    @Override
    public int compareTo(Person person) {
        return this.name.compareTo(person.getName());
    }
}
