package fr.didi.classesOneToOneSansTableAssociation;


import javax.persistence.*;

@Entity
@Table(name ="T_UserInformations")
public class UserInformations {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInformations;
    private String address;
    private String city;
    private String email;
    private int phoneNumber;

    public UserInformations() {
    }

    public UserInformations(int idInformations, String address, String city, String email, int phoneNumber) {
        this.idInformations = idInformations;
        this.address = address;
        this.city = city;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getIdInformations() {
        return idInformations;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setIdInformations(int idInformations) {
        this.idInformations = idInformations;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return " " + this.address + " " +
                " " + this.city + " " + this.email + " " + this.idInformations ;
    }
}
