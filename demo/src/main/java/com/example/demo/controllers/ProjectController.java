package com.example.demo.controllers;

import com.example.demo.DemoApplication;
import com.example.demo.models.ErrorModel;
import com.example.demo.models.Order;
import com.example.demo.models.OutputQ3;
import com.example.demo.models.Supply;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProjectController {

    @PostMapping(value = "updateSupply")
    public Supply updateSupply(@RequestBody Supply inputQ1) {

        // Init output
        String inputProductId = inputQ1.getProductId();
        Date inputTimeStamp= inputQ1.getUpdateTimeStamp();
        Double inputQty = inputQ1.getQuantity();
        Supply outputQ1 = new Supply(inputProductId, "", inputQty.intValue());
        outputQ1.setUpdateTimeStamp(inputTimeStamp);
        outputQ1.setStatus("Out Of Sync Update");

        // Stream use
        DemoApplication.supplyList.stream()
            .filter(supply -> supply.getProductId().equals(inputProductId))
            .filter(supply -> supply.getUpdateTimeStamp().getTime() - inputTimeStamp.getTime() < 0)
            .forEach(supply -> {
                outputQ1.setStatus("Updated");
                outputQ1.setQuantity(inputQty + supply.getQuantity());
            });

        // Response
        return outputQ1;
    }

    @PostMapping(value = "getOrderStats")
    public OutputQ3 getOrderStats(@RequestParam String statName) {

        // Stream use
        List<Order> outputOrderList =new ArrayList<>();
        if (statName.equals("MAX_SALE")) {
            outputOrderList = DemoApplication.orderList.stream()
                .sorted(Comparator.comparingDouble(Order::getQuantity).reversed())
                .collect(Collectors.toList());

        } else if (statName.equals("MIN_SALE")){
            outputOrderList = DemoApplication.orderList.stream()
                .sorted(Comparator.comparingDouble(Order::getQuantity))
                .collect(Collectors.toList());
        }

        OutputQ3 outputQ3 = new OutputQ3("", outputOrderList);

        // Response
        return outputQ3;
    }


    @ExceptionHandler
    public String handleQ1Error(ErrorModel exception) {
        return exception.getMessage();
    }
}
