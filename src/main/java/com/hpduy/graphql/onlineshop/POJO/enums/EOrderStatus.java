package com.hpduy.graphql.onlineshop.POJO.enums;

import java.util.Arrays;

public enum EOrderStatus {
    ADDING(0, "Adding"),
    RECEIVED(1, "Received"),
    PREPARING(2, "Prepared"),
    SHIPPED(3, "Shipped"),
    DELIVERED(4, "Delivered");

    private final int code;
    private final String name;

    EOrderStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static EOrderStatus findByCode(int code){
        return Arrays.stream(values()).filter(e -> e.code == code)
                .findFirst()
                .orElse(null);
    }

    public static EOrderStatus findByName(int name){
        return Arrays.stream(values()).filter(e -> e.name.equals(name))
                .findFirst()
                .orElse(null);
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
