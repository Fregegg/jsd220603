package com.example.boot06.entity;

/**
 * @author Freg
 * @time 2022/9/9  10:44
 */

public class Product {
    private int id;
    private String title;
    private double price;
    private int num;

    public Product(String title, double price, int num) {
        this.title = title;
        this.price = price;
        this.num = num;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
