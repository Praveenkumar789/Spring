package com.controller;


import com.google.gson.Gson;
import com.model.Electricity;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bills")
public class ElectricityMeter {
	
	ArrayList<Electricity> electricbills = new ArrayList<Electricity>();
	public ElectricityMeter() {
		int cost_per_unit = 13;
		Electricity bill1 = new Electricity(23451001, "Praveen", 245 , cost_per_unit, "15-12-2020");
		Electricity bill2 = new Electricity(23451002, "Shreemay", 110 , cost_per_unit, "15-12-2020");
		Electricity bill3 = new Electricity(23451003, "Sirisha", 32 , cost_per_unit, "15-12-2020");
		Electricity bill4 = new Electricity(23451004, "Rakesh", 410 , cost_per_unit, "15-12-2020");
		Electricity bill5 = new Electricity(23451005, "Ashish", 290 , cost_per_unit, "15-12-2020");
		Electricity bill6 = new Electricity(23451006, "Rahul", 123 , cost_per_unit, "15-12-2020");
		
		
		bill1.setBillAmount(245 * cost_per_unit);
		bill2.setBillAmount(110 * cost_per_unit);
		bill3.setBillAmount(32 * cost_per_unit);
		bill4.setBillAmount(410 * cost_per_unit);
		bill5.setBillAmount(290 * cost_per_unit);
		bill6.setBillAmount(123 * cost_per_unit);
		
		this.electricbills.add(bill1);
		this.electricbills.add(bill2);
		this.electricbills.add(bill3);
		this.electricbills.add(bill4);
		this.electricbills.add(bill5);
		this.electricbills.add(bill6);
	}
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public String getElectricityBillDetails(@RequestBody String name) {
	
		
		
		System.out.print("Employee Controller is about to Return");
		
		String allbills = "";
		for(Electricity bill : this.electricbills) {
			allbills += bill.toString() + "\n\n";
		}
		return electricbills.toString();
	}
	
	
	
	@RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
	public String getElectricityBillDetails(@PathVariable int id) {
		
		
		int len = this.electricbills.size();
		
		
		System.out.println("Hello size:"+len);
		if(len > 0 && id > 0 && id <= len)
		{
			Electricity bill = this.electricbills.get(id);
			return bill.toString();
		}
		
		else {
			
			String msg = "Incorrect Employee id is entered";
			return msg;
		}
		
	}	

}
