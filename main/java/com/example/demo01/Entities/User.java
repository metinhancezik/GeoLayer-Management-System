package com.example.demo01.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_Data")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @Column(name = "userfirstname")
    private String userFirstName;

    @Column(name = "userlastname")
    private String userLastName;

    @Column(name = "username")
    private String username;

    @Column(name = "userpassword")
    private String userPassword;



    @Column(name = "usermail")
    private String userMail;


    @Column(name = "userrole")
    private String role;

    @Column(name="status")
    private String status;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("user"));
        return authorities;
    }

    public String getFirstName() {
        return this.userFirstName;
    }

    public String getLastName() {
        return this.userLastName;
    }

    public String getEmail() {
        return this.userMail;
    }
    public String getPassword() {
        return this.userPassword;
    }

    public String getRole() {
        return this.role;
    }

    public Long getId() {
        return userid;
    }

    public void setId(Long id) {
        this.userid = id;
    }

    public boolean isEnabled() {
        return "active".equalsIgnoreCase(this.status);
    }

    }
