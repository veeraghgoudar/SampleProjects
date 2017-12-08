package org.springmvc.studentadministrationcontroller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// Example of post and get methods
/*@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admissionForm.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm(){

		ModelAndView model = new ModelAndView("/jsp/screens/AdmissionForm");
		return model;
	}

	@RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value="studentName", defaultValue="Default Name") String name, @RequestParam("studentHobby") String hobby ){

		ModelAndView model = new ModelAndView("/jsp/screens/AdmissionSuccess");
		model.addObject("msg","Details submitted by you: Name: "+name+", Hobby : "+hobby);

		return model;
	}


}
 */

/*@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admissionForm.html", method = RequestMethod.POST)
	public ModelAndView getAdmissionForm(@RequestParam(value="username") String userName, @RequestParam("password") String password ){

		//Checking for username and password
		if((userName.equalsIgnoreCase("veeragh")) && (password.equalsIgnoreCase("veeragh"))){
			ModelAndView model = new ModelAndView("/jsp/screens/AdmissionForm");
			return model;
		}
		return null;
	}

	@RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value="studentName", defaultValue="Default Name") String name, @RequestParam("studentHobby") String hobby ){

		ModelAndView model = new ModelAndView("/jsp/screens/AdmissionSuccess");
		model.addObject("msg","Details submitted by you: Name: "+name+", Hobby : "+hobby);

		return model;
	}
}*/


// Example of binding data without using ModelAttribute. Also, send object back to JSP
/*@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admissionForm.html", method = RequestMethod.POST)
	public ModelAndView getAdmissionForm(@RequestParam(value="username") String userName, @RequestParam("password") String password ){

		//Checking for username and password
		if((userName.equalsIgnoreCase("veeragh")) && (password.equalsIgnoreCase("veeragh"))){
			ModelAndView model = new ModelAndView("/jsp/screens/AdmissionForm");
			return model;
		}
		return null;
	}

	@RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value="studentName", defaultValue="Default Name") String name, 
			@RequestParam("studentHobby") String hobby ){

		Student student1 = new Student();
		student1.setStudentHobby(hobby);
		student1.setStudentName(name);

		ModelAndView model = new ModelAndView("/jsp/screens/AdmissionSuccess");
		model.addObject("headerMessage","Collge Name ");
		model.addObject("studentInfo",student1);
		return model;
	}
}
 */

/* Using ModelAttribute for extracting request parameters, bind them to model and sending them back to view
 * Also, has an example of using @ModelAttribute annotation on a method
 */
/*
@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admissionForm.html", method = RequestMethod.POST)
	public ModelAndView getAdmissionForm(@RequestParam(value="username") String userName, @RequestParam("password") String password ){
		//Checking for username and password
		if((userName.equalsIgnoreCase("veeragh")) && (password.equalsIgnoreCase("veeragh"))){
			ModelAndView model = new ModelAndView("/jsp/screens/AdmissionForm");
			return model;
		}
		ModelAndView model = new ModelAndView("/jsp/screens/Login");
		model.addObject("validationMessage","Invalid Username and Password");
		return model;
	}

	@RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("studentInfo") Student student1 ){

		ModelAndView model = new ModelAndView("/jsp/screens/AdmissionSuccess");
		model.addObject("headerMessage","College Name ");
		return model;
	}
	 The ModelAttribute annotation here returns this model attribute called 'headerMessage' to the view
 *  whenever any of this controller methods are invoked
 *  This attribute could be used any of the jsp page or view
	@ModelAttribute
	public void addingCommonHeader(Model commonHeaderModel){
		commonHeaderModel.addAttribute("headerMessage","MVC Demo Tutorial");
	}
}
 */


// Handling Binding errors and using custom defined type like new class. 
// Example of initBinder annotation and WebDataBinder

@Controller
public class StudentAdmissionController {

	@RequestMapping(value="/admissionForm.html", method = RequestMethod.POST)
	public ModelAndView getAdmissionForm(@RequestParam(value="username") String userName, @RequestParam("password") String password ){
		//Checking for username and password
		if((userName.equalsIgnoreCase("veeragh")) && (password.equalsIgnoreCase("veeragh"))){
			ModelAndView model = new ModelAndView("/jsp/screens/AdmissionForm");
			return model;
		}
		ModelAndView model = new ModelAndView("/jsp/screens/Login");
		model.addObject("validationMessage","Invalid Username and Password");
		return model;
	}

	@RequestMapping(value="/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("studentInfo") Student student1, BindingResult result ){

		if(result.hasErrors()){
			// If binding error occurs then return the same form
			ModelAndView model = new ModelAndView("/jsp/screens/AdmissionForm");
			return model;
		}

		ModelAndView model = new ModelAndView("/jsp/screens/AdmissionSuccess");
		return model;
	}

	@ModelAttribute
	public void addingCommonHeader(Model commonHeaderModel){
		commonHeaderModel.addAttribute("headerMessage","MVC Demo Tutorial");
	}

	@InitBinder
	public void initBinderExample(WebDataBinder binder){
		binder.setDisallowedFields("studentMobile");
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy****MM****dd");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));*/

		//Setting custom property editor. Validate for Mr or Ms name
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());


	}


}