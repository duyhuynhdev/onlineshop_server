package com.hpduy.graphql.onlineshop.POJO;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private int discount;
    private int amount;
    private String category_id;
    private String currency;
    private List<String> images;


    public Product(String id, String name, String category_id) {
        this.id = id;
        this.name = name;
        this.description = "";
        this.price = 0;
        this.discount = 0;
        this.amount = 0;
        this.category_id= category_id;
        this.currency = "USD";
        this.images = new ArrayList<>();
    }
    public Product(String id, String name, double price, int amount, String category_id) {
        this.id = id;
        this.name = name;
        this.description = "";
        this.price = price;
        this.discount = 0;
        this.amount = amount;
        this.category_id = category_id;
        this.currency = "USD";
        this.images = new ArrayList<>();
    }

    public Product(String id, String name, String description, double price, int discount, int amount, String category_id, String currency) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.amount = amount;
        this.category_id = category_id;
        this.currency = currency;
        this.images = new ArrayList<>();
    }
    public Product(String name, String description, double price, int discount, int amount, String category_id, String currency) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.amount = amount;
        this.category_id = category_id;
        this.currency = currency;
        this.images = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public int getAmount() {
        return amount;
    }

    public String getCategoryId() {
        return category_id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCategoryId(String category_id) {
        this.category_id = category_id;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
