package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

public class Availability {

    @Getter @Setter
    private String storeNo;

    @Getter @Setter
    private String productId;

    @Getter @Setter
    private Double availQty;

    public Availability(String storeNo, String productId, Double availQty) {
        this.storeNo = storeNo;
        this.productId = productId;
        this.availQty = availQty;
    }
}
