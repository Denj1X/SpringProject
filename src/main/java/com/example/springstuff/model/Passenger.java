package com.example.springstuff.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "passenger")
@AllArgsConstructor
@NoArgsConstructor
public class Passenger implements UserDetails {
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

    @Size(min = 2, max = 20, message = "Role cannot be shorter than 2 or longer than 100")
    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Directly use the role string to create authorities
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public String getUsername() {
        return emailAddress;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
