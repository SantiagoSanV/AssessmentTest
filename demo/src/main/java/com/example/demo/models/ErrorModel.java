package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

public class ErrorModel extends RuntimeException {

    @Getter @Setter
    private String message;

    public ErrorModel(String message) {
        this.setMessage(message);
    }

}
