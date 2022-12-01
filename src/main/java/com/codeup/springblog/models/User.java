package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


//    Unique = true does not let duplicates
    @Column(nullable = false, length = 80)
    private String email;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false)
    private String  password;

//    This is for the relationship exercise
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;

//    Getters and setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    Constructors


    public User() {
    }


    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }


    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }







}
