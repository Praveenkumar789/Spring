package verify_name;

import com.google.gson.Gson;

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
public class NameController {
	

	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String getUserDetails(@RequestParam ("firstname") String firstname, @RequestParam("lastname") String lastname) {

		System.out.println("Name Controller is about to Return");
		
	 String fullname = firstname +" " +lastname ;
	 return "Hello " + firstname + " As per our records your full name is : " + fullname;
	}
	
}
