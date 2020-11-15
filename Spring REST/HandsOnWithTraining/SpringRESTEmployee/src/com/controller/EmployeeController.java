package com.controller;


import com.google.gson.Gson;
import com.model.Employee;

import java.util.HashMap;
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
@RequestMapping("/payroll")
public class EmployeeController {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getEmployeeDetails(@PathVariable int id) {
		
		HashMap<Integer, Employee> hml = new HashMap<Integer, Employee>();
		hml.put(1, new Employee(1, "Praveen",55000, 3500, 2000,200));
		hml.put(2, new Employee(2,"Shreemay",59000, 3500, 2000,200));
		hml.put(3, new Employee(3,"Sirisha",65000, 3500, 2000,200));
		
		Employee emp=null;
		if(hml.containsKey(id))
		{
			emp = hml.get(id);
		}
		emp.setGross_sal(emp.getBasic() + emp.getHra() + emp.getAllowance());
		emp.setFinal_deductions((int) (emp.getDeductions() + (emp.getGross_sal()*0.2)));
		emp.setGross_sal(emp.getGross_sal() - emp.getFinal_deductions());
		System.out.print("Employee Controller is about to Return");
		return emp.toString();
	}
	
	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody String name)
	{
		System.out.println(name);
		return new ResponseEntity(HttpStatus.CREATED);
		
	}
	

}
