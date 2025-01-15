package com.example.springstuff.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "passenger")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Size(min = 2, max = 20, message = "First name cannot be shorter than 2 or longer than 20")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Size(min = 2, max = 20, message = "Last name cannot be shorter than 2 or longer than 20")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Size(min = 2, max = 50, message = "Email address cannot be shorter than 2 or longer than 50")
    @Column(name = "email_address")
    private String emailAddress;

    @Size(min = 2, max = 100, message = "Password cannot be shorter than 2 or longer than 100")
    @Column(name = "user_password")
    private String userPassword;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings;

    public Passenger() {
    }

    public Passenger(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Passenger(String firstName, String lastName, String emailAddress, String userPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.userPassword = userPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
