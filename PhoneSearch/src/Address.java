public class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public boolean contains(String keyword) {
        return this.street.contains(keyword) || this.city.contains(keyword);
    }
}
