package com.example.boot02.entity;

/**
 * @author Freg
 * @time 2022/9/7  10:41
 */
public class Product {
    //包装类可以有NULL值,更适合使用在数据库中
    private Integer id;
    private String title;
    private Double price;
    private Integer num;

    public Product() {
    }


    public Product(Integer id, String title, Double price, Integer num) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.num = num;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
