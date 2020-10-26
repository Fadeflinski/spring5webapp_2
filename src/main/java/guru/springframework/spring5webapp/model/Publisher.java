package guru.springframework.spring5webapp.model;

import javax.persistence.*;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pPublisher;
    private String name;
    private String addressLine1;
    private String city;
    private String state;
    private String zip;

    public Publisher() {
    }

    public Publisher(String name, String addressLine1, String city, String state, String zip) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setpPublisher(Long pPublisher) {
        this.pPublisher = pPublisher;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "pPublisher=" + pPublisher +
                ", name='" + name + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return pPublisher != null ? pPublisher.equals(publisher.pPublisher) : publisher.pPublisher == null;
    }

    @Override
    public int hashCode() {
        return pPublisher != null ? pPublisher.hashCode() : 0;
    }
}
