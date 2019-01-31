package com.hpduy.graphql.onlineshop.POJO;

public class OrderItem {
    private String id;
    private String product_id;
    private int amount;
    private double price;
    private String order_id;

    public OrderItem(String id, String product_id, int amount, double price, String order_id) {
        this.id = id;
        this.product_id = product_id;
        this.amount = amount;
        this.price = price;
        this.order_id = order_id;
    }
    public OrderItem( String product_id, int amount, double price, String order_id) {
        this.product_id = product_id;
        this.amount = amount;
        this.price = price;
        this.order_id = order_id;
    }

    public String getId() {
        return id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
}
