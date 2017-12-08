package org.springmvc.hellocontroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


// Spring MVC example without annotations
public class HelloController extends AbstractController {

	 protected ModelAndView handleRequestInternal(
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
		 
		 ModelAndView modelandview = new ModelAndView("/jsp/screens/HelloPage");
		 modelandview.addObject("WelcomeMessage","Hi User, welcome to the first Spring MVC Application");
		 
		 return modelandview;

	    }
}
	

//Spring MVC example with annotations and Path variables
/*@Controller
@RequestMapping("/screens")
public class HelloController{
	@RequestMapping("/login.do")
	public ModelAndView login(){
		
		ModelAndView model = new ModelAndView("/jsp/screens/HelloPage");
		model.addObject("WelcomeMessage","Hi User, welcome to the first Spring MVC Application");
		
		return model;
	}
	
	@RequestMapping("/{firstname}/{lastname}/logout.do")
	public ModelAndView logout(@PathVariable ("firstname") String firstName, @PathVariable ("lastname") String LastName ){
		
		ModelAndView model = new ModelAndView("/jsp/screens/HelloPage");
		model.addObject("WelcomeMessage","User "+firstName+" "+LastName+" has logged out");
		
		return model;
	}

}*/

//Spring MVC example with annotations and Path variables in a Map
/*@Controller
@RequestMapping("/screens")
public class HelloController{
	@RequestMapping("/login.do")
	public ModelAndView login(){
		
		ModelAndView model = new ModelAndView("/jsp/screens/HelloPage");
		model.addObject("WelcomeMessage","Hi User, welcome to the first Spring MVC Application");
		
		return model;
	}
	
	@RequestMapping("/{firstname}/{lastname}/logout.do")
	public ModelAndView logout(@PathVariable Map<String,String> pathVariables){
			
		String firstName = pathVariables.get("firstname");
		String LastName = pathVariables.get("lastname");
		
		ModelAndView model = new ModelAndView("/jsp/screens/HelloPage");
		model.addObject("WelcomeMessage","User "+firstName+" "+LastName+" has logged out");
		
		return model;
	}*/
