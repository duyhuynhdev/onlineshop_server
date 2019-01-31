package com.hpduy.graphql.onlineshop.POJO;

import com.hpduy.graphql.onlineshop.POJO.enums.EOrderStatus;

import java.time.ZonedDateTime;

public class Order {
    private String id;
    private ZonedDateTime created_at;
    private String user_id;
    private String delivery_address;
    private ZonedDateTime delivery_time;
    private String note;
    private EOrderStatus status;
    private String invoice_url;

    public Order(String id, ZonedDateTime createdAt, String userId, String delivery_address, ZonedDateTime delivery_time, EOrderStatus status, String note) {
        this.id = id;
        this.created_at = createdAt;
        this.user_id = userId;
        this.delivery_address = delivery_address;
        this.delivery_time = delivery_time;
        this.note = note;
        this.status =  status;
        this.invoice_url = "";
    }

    public Order( ZonedDateTime createdAt, String userId, String delivery_address, ZonedDateTime delivery_time, String note) {
        this.created_at = createdAt;
        this.user_id = userId;
        this.delivery_address = delivery_address;
        this.delivery_time = delivery_time;
        this.note = note;
        this.status =  EOrderStatus.ADDING;
        this.invoice_url = "";
    }

    public Order(String id, ZonedDateTime createdAt, String userId, String delivery_address, String note) {
        this.id = id;
        this.created_at = createdAt;
        this.user_id = userId;
        this.delivery_address = delivery_address;
        this.note = note;
        this.status = EOrderStatus.ADDING;
        this.invoice_url = "";
    }



    public String getId() {
        return id;
    }

    public ZonedDateTime getCreatedAt() {
        return created_at;
    }

    public String getUser_id() {
        return user_id;
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

    public  EOrderStatus getStatus() {
        return status;
    }

    public String getInvoice_url() {
        return invoice_url;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.created_at = createdAt;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public void setStatus( EOrderStatus status) {
        this.status = status;
    }

    public void setInvoice_url(String invoice_url) {
        this.invoice_url = invoice_url;
    }

    public void setId(String id) {
        this.id = id;
    }
}
