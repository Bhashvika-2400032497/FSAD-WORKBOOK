package com.klu.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    private String pname;
    private double price;
    private int quantity;
    private String description;

    public Product() {}

    public Product(String pname, double price, int quantity, String description) {
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public int getPid() { return pid; }
    public String getPname() { return pname; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getDescription() { return description; }
}

