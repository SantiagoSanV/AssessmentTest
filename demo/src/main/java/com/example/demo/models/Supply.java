package com.example.demo.models;

import com.example.demo.DemoApplication;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Supply {

    @Setter @Getter
    private String productId;

    @Setter @Getter
    private Date updateTimeStamp;

    @Setter @Getter
    private Double quantity;

    @Setter @Getter
    private String status;

    public Supply(String productId, String updateTimeStamp, Integer quantity) {
        this.productId = productId;
        this.updateTimeStamp = DemoApplication.parseDate(updateTimeStamp);
        this.quantity = quantity.doubleValue();
    }
}
