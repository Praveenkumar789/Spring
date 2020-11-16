package com.sunsoft;

import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {

	@RequestMapping("/login")
	public ModelAndView helloWorld(HttpServletRequest req, HttpServletResponse res, ModelMap model)
	{
		String name = req.getParameter("name");
//		String password = req.getParameter("password");
		String id = req.getParameter("id");
		String hra = req.getParameter("hra");
		String da = req.getParameter("da");
		String tax = req.getParameter("tax");
		String deductions = req.getParameter("deductions");
		
		System.out.println("Id is :"+id);
		if(id != null && id.equals("123")) {
			String msg = "Welcome" + name + "!!" +"Your Gross Salary .."+11111111+",Net Salary is "+1000000;
			
			model.addAttribute("id", id);
			
			model.addAttribute("name", "Praveen kumar");
			model.addAttribute("deductions", 200);
			// Also pass details
			return new ModelAndView("detailspage", "msg", msg);
		}
		else
		{
			return new ModelAndView("errorpage", "msg", "Incorrect Credentials Entered please try again");
		}
	}
}
