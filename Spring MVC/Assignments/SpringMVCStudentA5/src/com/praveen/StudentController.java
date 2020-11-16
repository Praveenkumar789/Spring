package com.praveen;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class StudentController {
	private ArrayList<Student> students=new ArrayList();	
	@RequestMapping("/read")
	public String readController(Model m) {
		m.addAttribute("students",students);
		return "read";
	}
	@RequestMapping("/create")
	public String createController(HttpServletRequest req,HttpServletResponse res,Model m) {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String branch=req.getParameter("branch");
		String address=req.getParameter("address");
		Student stu=new Student();
		stu.setId(Integer.parseInt(id));
		stu.setBranch(branch);
		stu.setAddress(address);
		stu.setName(name);
		students.add(stu);
		return "redirect:read";
	}
	@RequestMapping("/update")
	public String updateController(HttpServletRequest req,HttpServletResponse res,Model m) {
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String branch=req.getParameter("branch");
		String address=req.getParameter("address");
		for( Student a : students) { 
			if (a.getId()==Integer.parseInt(id)) {
				a.setName(name);
				a.setBranch(branch);
				a.setAddress(address);
			}
		}
		return "redirect:read";
	}
	@RequestMapping("/delete")
	public String deleteController(HttpServletRequest request,HttpServletResponse response,Model m) {
		String id=request.getParameter("id");
		Iterator<Student> itr = students.iterator();
		while (itr.hasNext()) {
		    Student stu = itr.next();
		    if (stu.getId()==Integer.parseInt(id)) {
		       itr.remove();
		    }
		}
		return "redirect:read";
	}
	@RequestMapping("/display")
	public String showController(Model m) {
		m.addAttribute("students",students);
		return "display";
	}
}
