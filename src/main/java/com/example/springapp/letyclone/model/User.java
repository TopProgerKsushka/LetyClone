package com.example.springapp.letyclone.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lc_user")
public class User {
    public User() {}
    public User(String username, String password, Double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 100 characters")
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    Set<Item> orderedItems;

    @Column(nullable = false)
    Double balance;

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public double getBalance() { return balance; }
    public Set<Item> getOrderedItems() { return orderedItems; }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
