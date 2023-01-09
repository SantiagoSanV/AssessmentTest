package com.example.demo;

import com.example.demo.models.Availability;
import com.example.demo.models.Capacity;
import com.example.demo.models.Order;
import com.example.demo.models.Supply;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	// Question 1
	public static List<Supply> supplyList = new ArrayList<Supply>();

	// Question 2
	public static List<Availability> availabilityList = new ArrayList<Availability>();
	public static List<Capacity> capacityList = new ArrayList<Capacity>();

	// Question 2
	public static List<Order> orderList = new ArrayList<Order>();

	public static void main(String[] args) {
		// Hardcoded supply and demand list
		supplyList.add(new Supply("Product1","2021-03-16T08:53:48.616Z",10));
		supplyList.add(new Supply ("Product2","2021-03-16T08:59:48.616Z",5));
		supplyList.add(new Supply ("Product3","2021-03-16T09:10:48.616Z",30));
		supplyList.add(new Supply ("Product4","2021-03-16T09:10:48.616Z",20));

		// Hardcoded availability and capacity list

		// Hardcoded availability and capacity list
		orderList.add(new Order("Order1", "Product1", "2021-03-16", 10.0));
		orderList.add(new Order("Order2", "Product2", "2021-03-19", 5.0));
		orderList.add(new Order("Order3", "Product3", "2021-03-16", 30.0));
		orderList.add(new Order("Order4", "Product4", "2021-03-20", 20.0));
		orderList.add(new Order("Order5", "Product5", "2021-03-16", 20.0));

		SpringApplication.run(DemoApplication.class, args);

	}

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

}
