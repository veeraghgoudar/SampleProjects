package org.musigma.mumix;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringProject {
	
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		Restaurant restaurantObj = (Restaurant) context.getBean("restaurantBean");
		
		// This will explicitly destroy all the beans from the context/ApplicationContext  
	    	((AbstractApplicationContext)context).registerShutdownHook();
		
		//Use the below line for setting greetCustomer message from spring's XML file
		//restaurantObj.greetCustomer();
		
		//Use the below line for DI
		// restaurantObj.prepareHotDrink(); //DI using constructor
		

	    coffee coffeeObject = new coffee();
	    restaurantObj.setHotDrink(coffeeObject);
	    restaurantObj.prepareHotDrink();
	    
		//Use the values of list from springs XML file
		restaurantObj.displayWaitersNames();
		
		
		
	}

}
