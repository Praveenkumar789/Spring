package com.sunsoft;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class WelcomeController {
		@RequestMapping("/login")
		public String helloWorld( @RequestParam("name") String name, Model m)
		{
		
//		    m.addAttribute("message: ", message);
		    m.addAttribute("name", name);
		    m.addAttribute("good", "Excellent");
		    if(name.isEmpty()) {
		    	return "error";
		    }
		    else {
		    return "welcome";
		    }
		}
}


