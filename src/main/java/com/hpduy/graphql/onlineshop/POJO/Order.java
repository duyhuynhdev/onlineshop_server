package com.hpduy.graphql.onlineshop.POJO;

import java.time.ZonedDateTime;

public class Order {
    private String id;
    private ZonedDateTime createdAt;
    private String userId;
    private String delivery_address;
    private ZonedDateTime delivery_time;
    private String note;
    private int status;
    private String invoice_url;

    public Order(String id, ZonedDateTime createdAt, String userId, String delivery_address, ZonedDateTime delivery_time, String note) {
        this.id = id;
        this.createdAt = createdAt;
        this.userId = userId;
        this.delivery_address = delivery_address;
        this.delivery_time = delivery_time;
        this.note = note;
        this.status = 0;
        this.invoice_url = "";
    }

    public Order(String id, ZonedDateTime createdAt, String userId, String delivery_address, ZonedDateTime delivery_time) {
        this.id = id;
        this.createdAt = createdAt;
        this.userId = userId;
        this.delivery_address = delivery_address;
        this.delivery_time = delivery_time;
        this.note = "";
        this.status = 0;
        this.invoice_url = "";
    }

    public String getId() {
        return id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public ZonedDateTime getDelivery_time() {
        return delivery_time;
    }

    public String getNote() {
        return note;
    }

    public int getStatus() {
        return status;
    }

    public String getInvoice_url() {
        return invoice_url;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public void setDelivery_time(ZonedDateTime delivery_time) {
        this.delivery_time = delivery_time;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setInvoice_url(String invoice_url) {
        this.invoice_url = invoice_url;
    }
}
