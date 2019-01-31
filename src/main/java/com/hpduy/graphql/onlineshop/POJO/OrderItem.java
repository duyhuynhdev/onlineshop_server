package com.hpduy.graphql.onlineshop.POJO;

public class OrderItem {
    private int id;
    private String product_id;
    private int amount;
    private float price;

    public OrderItem(int id, String product_id, int amount, float price) {
        this.id = id;
        this.product_id = product_id;
        this.amount = amount;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public int getAmount() {
        return amount;
    }

    public float getPrice() {
        return price;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
