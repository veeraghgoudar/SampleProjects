package org.musigma.mumix;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/*
 //Example of setting value/property from XML file of Spring
public class Restaurant {
	
	String welcomeNote;
	

	public String getWelcomeNote() {
		return welcomeNote;
	}


	public void setWelcomeNote(String welcomeNote) {
		this.welcomeNote = welcomeNote;
	}


	public void greetCustomer(){
		//System.out.println("Welcome to First Spring Project");
		System.out.println(welcomeNote);
	}
}*/


/*
 //Example of Dependency Injection through Constructor
 
public class Restaurant{
	// This is DI using Constructor
	//Interface
	IHotDrink hotDrink;
	
	/*If you observe here, i am not initializing tea object any where.
	  However, at Run time spring framework will create a Tea object first and call
	  the 'Restaurant' constructor to pass the value of tea object as an argument
	*/
/*
	// This is constructor.
	 Restaurant(IHotDrink hotDrink) {
		 // Here the restaurant class will initialize the value of hotDrink with Tea object
		 	 this.hotDrink = hotDrink;
	}
	 
	 public void prepareHotDrink() {
		 
		 hotDrink.prepareHotDrink();
		 
		
	}
	
}
*/


//Example of Dependency Injection through Setter
/*
public class Restaurant{
	//Interface
	IHotDrink hotDrink;
	
	// This is setter method.
	 public void setHotDrink(IHotDrink hotDrink) {
		 	 this.hotDrink = hotDrink;
	}
	 
	 public void prepareHotDrink() {
		 
		 hotDrink.prepareHotDrink();
		 
		
	}
	
} */

// Example of displaying list values from XML file
// Example of calling init and destroy methods through xml configuration and annotations
/*
    public class Restaurant{
 
		private List restaurantWaitersList;

		public void setRestaurantWaitersList(List restaurantWaitersList) {
			this.restaurantWaitersList = restaurantWaitersList;
		}
		
		public void displayWaitersNames(){
			System.out.println("All the waiters working in the Restaurant : " +restaurantWaitersList);
		}
		
		@PostConstruct
		public void init(){
			System.out.println("Initiating Restaurant Bean");
		}
		
		@PreDestroy
		public void destroy(){
			System.out.println("Destroying Restaurant Bean");
		}
		
}
*/

// Example of calling init and destroy methods using initialzingBean and DisposableBean interfaces

public class Restaurant implements InitializingBean, DisposableBean{
	 
	private List restaurantWaitersList;
	//Interface
		IHotDrink hotDrink;
	// This is setter method.
	public void setHotDrink(IHotDrink hotDrink) {
		this.hotDrink = hotDrink;
	}
	
	 public void prepareHotDrink() {
			 hotDrink.prepareHotDrink();
		}

	public void setRestaurantWaitersList(List restaurantWaitersList) {
		this.restaurantWaitersList = restaurantWaitersList;
	}
	
	public void displayWaitersNames(){
		System.out.println("All the waiters working in the Restaurant : " +restaurantWaitersList);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("This method is called once the Restaurant bean initialized through InitializingBean interface");
		
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("This method is called once the Restaurant bean is destroyed through DisposableBean interface");
		
	}
	
	
}





















