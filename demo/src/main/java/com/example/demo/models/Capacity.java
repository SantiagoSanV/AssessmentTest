package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Capacity {

    @Getter @Setter
    private String storeNo;

    @Getter @Setter
    private Date date;

    @Getter @Setter
    private Double noOfOrdersAccepted;

    public Capacity(String storeNo, Date date, Double noOfOrdersAccepted) {
        this.storeNo = storeNo;
        this.date = date;
        this.noOfOrdersAccepted = noOfOrdersAccepted;
    }
}
