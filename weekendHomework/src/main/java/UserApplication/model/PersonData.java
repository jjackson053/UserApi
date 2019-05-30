package UserApplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
@Data
@AllArgsConstructor
@Entity
public class PersonData {
    @Id
    @GeneratedValue
    @Column(name = "PERSON_DATA_ID")
    private Long id;
    @Column(name = "PERSON_DATA_NAME")
    private String name;
    @Column(name = "PERSON_DATA_USERNAME")
    private String username;
    @Column(name = "PERSON_DATA_EMAIL")
    private String email;
//    @Column(name = "PERSON_DATA_ADDRESS")
    @Embedded
    private Address address;
    @Column(name = "PERSON_DATA_PHONE")
    private String phone;
    @Column(name = "PERSON_DATA_WEBSITE")
    private String website;
//    @Column(name = "PERSON_DATA_COMPANY")
    @Embedded
    private Company company;

    public PersonData(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}


