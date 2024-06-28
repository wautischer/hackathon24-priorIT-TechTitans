package at.techtitans.hackathon.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Employee", schema = "feedback_DB")
public class Employee {
    @Id
    @Column(name = "idEmployee", nullable = false)
    private Integer id;

    @Column(name = "Role", nullable = false, length = 45)
    private String role;

    @Column(name = "`Street Adress`", nullable = false, length = 45)
    private String streetAdress;

    @Column(name = "Apartment", length = 45)
    private String apartment;

    @Column(name = "City", nullable = false, length = 45)
    private String city;

    @Column(name = "State", nullable = false, length = 45)
    private String state;

    @Column(name = "`Postal Code`", nullable = false)
    private Integer postalCode;

    @Column(name = "Country", nullable = false, length = 45)
    private String country;

    @Column(name = "`Phone Number`", nullable = false, length = 45)
    private String phoneNumber;

    @Column(name = "Surname", nullable = false, length = 45)
    private String surname;

    @Column(name = "Firstname", nullable = false, length = 45)
    private String firstname;

    @Column(name = "Picture", nullable = false, length = 100)
    private String picture;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Projects_idProjects", nullable = false)
    private Project projectsIdprojects;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Login_idLogin", nullable = false)
    private Login loginIdlogin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStreetAdress() {
        return streetAdress;
    }

    public void setStreetAdress(String streetAdress) {
        this.streetAdress = streetAdress;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
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

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Project getProjectsIdprojects() {
        return projectsIdprojects;
    }

    public void setProjectsIdprojects(Project projectsIdprojects) {
        this.projectsIdprojects = projectsIdprojects;
    }

    public Login getLoginIdlogin() {
        return loginIdlogin;
    }

    public void setLoginIdlogin(Login loginIdlogin) {
        this.loginIdlogin = loginIdlogin;
    }

}