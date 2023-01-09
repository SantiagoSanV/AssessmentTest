package com.example.demo.models;

import com.example.demo.DemoApplication;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Order {

    @Getter @Setter
    private String orderId;

    @Getter @Setter
    private String productId;

    @Getter @Setter
    private Date createDate;

    @Getter @Setter
    private Double quantity;

    public Order(String orderId, String productId, String createDate, Double quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.createDate = DemoApplication.parseDate(createDate);
        this.quantity = quantity;
    }
}
