package praveen.controller;


import com.google.gson.Gson;
import praveen.model.UserDetails;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {
	
	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String getUserDetails(@RequestParam ("id") int id, @RequestParam("ppwd") String pwd) {
		
		HashMap<Integer, UserDetails> hml = new HashMap<Integer, UserDetails>();
		hml.put(1, new UserDetails(1, "Praveen",""));
		hml.put(2, new UserDetails(2,"Shreemay",""));
		hml.put(3, new UserDetails(3,"Sirisha",""));
		
		
		UserDetails user=null;
		if(hml.containsKey(id))
		{
			user = hml.get(id);
		
			int userid = user.getId();
			String userpwd = user.getPassword();
			if(id == userid && pwd == userpwd) {
				return user.toString();
			}
		
		System.out.print("Employee Controller is about to Return");
		return user.toString();
		}
		else
		{
			return "Id is not found";
		}
	}
	
//	
//	@RequestMapping(value = "/display", method = RequestMethod.POST)
//	public ResponseEntity<String> createUser(@RequestBody String name)
//	{
//		System.out.println(name);
//		return new ResponseEntity(HttpStatus.CREATED);
//		
//	}
//	

}
