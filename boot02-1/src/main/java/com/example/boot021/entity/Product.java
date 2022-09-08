package com.example.boot021.entity;

/**
 * @author Freg
 * @time 2022/9/7  15:14
 */
public class Product {
    private Integer id;
    private String title;
    private Double price;
    private Integer num;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Product(Integer id, String title, Double price, Integer num) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.num = num;
    }
}
