package com.sunsoft;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

	@RequestMapping("/login")
	public ModelAndView helloWorld(HttpServletRequest req, HttpServletResponse res)
	{
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		if(password.equals("admin")) {
			String msg = "Welcome" + name + "!!";
			return new ModelAndView("hellopage", "msg", msg);
		}
		else
		{
			return new ModelAndView("errorpage", "msg", "Incorrect Credentials Entered please try again");
		}
	}
}
