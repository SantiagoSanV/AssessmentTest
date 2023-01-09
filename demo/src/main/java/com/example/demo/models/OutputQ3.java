package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class OutputQ3 {

    @Getter @Setter
    private String productId;

    @Getter @Setter
    private List<Order> orderList;

    public OutputQ3(String productId) {
        this.productId = productId;
    }
}
