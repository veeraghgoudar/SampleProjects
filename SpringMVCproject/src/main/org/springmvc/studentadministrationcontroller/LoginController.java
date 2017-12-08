package org.springmvc.studentadministrationcontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
		@RequestMapping("/login.do")
		public ModelAndView login(){
			
			ModelAndView model = new ModelAndView("/jsp/screens/Login");
			model.addObject("WelcomeMessage","Hi User, welcome to the first Spring MVC Application");
			
			return model;
		}
		
		@RequestMapping("/logout.do/{firstname}/{lastname}")
		public ModelAndView logout(@PathVariable Map<String,String> pathVariables){
				
			String firstName = pathVariables.get("firstname");
			String LastName = pathVariables.get("lastname");
			
			ModelAndView model = new ModelAndView("/jsp/screens/HelloPage");
			model.addObject("WelcomeMessage","User "+firstName+" "+LastName+" has logged out");
			
			return model;
		}


}
