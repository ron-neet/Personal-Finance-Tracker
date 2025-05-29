package com.ronitCodes.Personal.Finance.Tracker.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private double amount;

    public Expenses(){

    }

    public Expenses(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
