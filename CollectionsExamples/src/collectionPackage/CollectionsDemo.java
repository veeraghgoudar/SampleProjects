/**
 * 
 */
package collectionPackage;

import java.*;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author veeragh.goudar
 *
 */
public class CollectionsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		/*--------------------------------------Legacy Objects (Before collection framework was introduced---------------*/
		
		/*
		 * Link - http://www.studytonight.com/java/legacy-classes-and-interface.php
		 * 
		 * The following are the legacy classes defined by java.util package
		 * Dictionary
		 * HashTable
		 * Properties
		 * Stack
		 * Vector
		 * 
		 */
		

		/*---------------------------------Vector-------------------------------------------------------*/
		System.out.println("--------------------Vector----------------------------");
		
		
		Vector vec = new Vector();
		Vector vec2 = new Vector();
		vec.addElement(13);
		vec.add(30);
		//vec.sort(null);
		System.out.println(vec);
		//vec.add("emp");
		
		vec2.add(new Empl("A", 2000));
		vec2.add(new Empl("B", 1000));
		vec2.add(new Empl("C", 200));
		vec2.add(new Empl("D", 20000));
		
		System.out.println("--------------unSorted---------\n"+vec2);
		//vec2.sort(new MySalaryComp());
		System.out.println("--------------Sorted---------\n"+vec2);
	
		Enumeration en = vec2.elements();
		
		while (en.hasMoreElements()) {
			System.out.println( "Enumeration next element "+en.nextElement());
			System.out.println(en.hasMoreElements());
		}
		
		System.out.println(vec2.get(1));
		
		/*---------------------------------Hash Table-------------------------------------------------------*/
		System.out.println("--------------------Hash Table----------------------------");		
		
		Hashtable hashtable1 = new Hashtable();
		
		hashtable1.put(1, new Empl("A", 1000));
		hashtable1.put(2, new Empl("B", 100));
		hashtable1.put(3, new Empl("C", 3000));
		hashtable1.put(4, new Empl("D", 2000));
		
		System.out.println(hashtable1);
		System.out.println("SIZE hashtable ----"+hashtable1.size());
		System.out.println("KEYS hashtable ----"+hashtable1.keySet());
		System.out.println("Value of 3 ----"+hashtable1.get(1));
		
		
		Enumeration enHashTable = hashtable1.elements();
		
		while(enHashTable.hasMoreElements()){
			System.out.println( "Enumeration Hash table next element "+enHashTable.nextElement());
		}
		
		Iterator iteratorHashTable = (Iterator) hashtable1.elements();	
		String strhashtable;
		while(iteratorHashTable.hasNext()){
			//strhashtable = (String) iteratorHashTable.next();
			System.out.println("Using Iterator---"+iteratorHashTable.next());
			//System.out.println("Printing hastable using Iterator"+strhashtable);
			
		}
		/*--------------------------------------Properties-------------------------------*/
		
		System.out.println("/*--------------------------------------Properties-------------------------------*/");
	    
		Properties pr = new Properties();
	     pr.put("Java", "James Ghosling");
	     pr.put("C++", "Bjarne Stroustrup");
	     pr.put("C", "Dennis Ritchie");
	     pr.put("C#", "Microsoft Inc.");
	   
	     Set< ?> creator = pr.keySet();
	     
	     for(Object ob: creator)
	     {
	         System.out.println(ob+" was created by "+ pr.getProperty((String)ob) );
	     }
	     
	  /* Access elements of set using iterator*/   
	     Set<?> languages = pr.keySet();
	     
	     Iterator<?> i = languages.iterator();
	     String str;
	     while(i.hasNext()){
	    	 str = (String) i.next();
	    	 System.out.println("Key is --"+str+"Value is --"+pr.getProperty(str));
	     }
 		
		/*-----------------------------------LIST------------------------------------------------*/		
		// Example of a Array List
		System.out.println("---------------ARRAY LIST--------------------------------------------------------------------------");
		List arrList = new ArrayList();
		
		arrList.add("name1, 100");
		arrList.add("name2, 50");	
		arrList.add("name3");	
		arrList.add("name3");
		
		System.out.println(arrList);
		System.out.println(arrList.get(2));
		
		List arrList2 = new ArrayList();
		
		arrList2.add(20);
		arrList2.add(4);	
		arrList2.add(100);	
		arrList2.add(5);
		
		System.out.println("Un sorted array list is - "+arrList2);
		
		//arrList2.sort(null);
		Collections.sort(arrList2);
		
		System.out.println("Sorted array list is - "+arrList2);
		
		// Example of a Linked List
		System.out.println("---------------LINKED LIST------------------------------");
		List linkedList = new LinkedList();
		
		linkedList.add("linkedListname1, 100");
		linkedList.add("linkedListname2");	
		linkedList.add("linkedListname3");	
		linkedList.add("linkedListname3");	
		
		System.out.println(linkedList.size());
		System.out.println(linkedList);
		System.out.println(linkedList.get(2));
		
		//Example of sort using linked list
		List linkedList2 = new LinkedList();
		
		linkedList2.add(100);
		linkedList2.add(12);	
		linkedList2.add(5);	
		linkedList2.add(500);	
		
		System.out.println(linkedList2.size());
		System.out.println("Un Sorted list entries using default collections sort :"+linkedList2);
		
		Collections.sort(linkedList2);
		
		System.out.println("Sorted list entries using default collections sort :"+linkedList2);
		
		//Example of sort in linked list using comparator
		List list = new LinkedList<Empl>();
        list.add(new Empl("Ram",3000));
        list.add(new Empl("John",6000));
        list.add(new Empl("Crish",2000));
        list.add(new Empl("Tom",2400));
        
        Collections.sort(list,new MySalaryComp());
        System.out.println("Sorted list entries: ");
        System.out.println(list);
/*        for(Empl e:list){
            System.out.println(e);
        }*/
        
/*-----------------------------------SETS------------------------------------------------*/
        
     System.out.println("-----------------SETS---------------------");
        Set hashset =  new HashSet();
        
        hashset.add(new Empl("Ram",3000));
        hashset.add(new Empl("Veeragh",300));
        hashset.add(new Empl("John",3100));
        hashset.add(new Empl("Crish",2000));
        hashset.add(new Empl("Tom",2400));
        
        System.out.println("hashset is -----------"+hashset);
        
        //Hashsets cannot be sorted. One way of sorting is to convert them to List and sort
        List sortedListForSet = new LinkedList(hashset);
        System.out.println("Un sorted linked list is  -----------"+sortedListForSet);
        Collections.sort(sortedListForSet,new MySalaryComp());
        System.out.println("sorted linked list is  -----------"+sortedListForSet);
        
        Empl searchKey = new Empl("Veeragh",300); 
        
        int index = Collections.binarySearch(sortedListForSet, searchKey, new SearchComp());
        System.out.println("--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@----------------------------------------------------Index of the searched key: "+index);
       
        
        
        //Second way - Sort the sets by using tree set
        HashSet myHashSet = new HashSet();
        myHashSet.add(49);
        myHashSet.add(23);
        myHashSet.add(4);
        myHashSet.add(12);

        System.out.println("Un sorted HASH SET WHICH IS NOOOT  IN ORDER  -----------"+myHashSet);
        TreeSet myTreeSet = new TreeSet();
        myTreeSet.addAll(myHashSet);
        System.out.println("Tree set----"+myTreeSet); // Prints [1, 12, 23, 45]
/*        TreeSet treeSet = new TreeSet();
        System.out.println("Un sorted HASH SET is  -----------"+hashset);
        treeSet.addAll(hashset);
        System.out.println("Sorted Tree Set -----------"+treeSet);*/
        
        
        
  /*-----------------------------LinkedHashset-----------------------*/	
        
        System.out.println("/*-----------------------------------LinkedHashset------------------------------------------------*/	");        
        
        LinkedHashSet linkedList1 = new LinkedHashSet();
        
        linkedList1.add(49);
        linkedList1.add(12);
        linkedList1.add(23);
        linkedList1.add(4);

        System.out.println("Un sorted Linked  HASH SET is WHICH IS IN ORDER -----------"+linkedList1);
        TreeSet myTreeSet2 = new TreeSet();
        myTreeSet2.addAll(linkedList1);
        System.out.println("linkedList1 Tree set----"+myTreeSet2); 
        
        /*-----------------------------------Tree Sets------------------------------------------------*/	   
        
      System.out.println("  /*-----------------------------------Tree Sets------------------------------------------------*/");
      
      	TreeSet treeSets1 = new TreeSet<>();
      
      	treeSets1.add("Veeragh");
      	treeSets1.add("Ravi");
      	treeSets1.add("Laxman");
      	treeSets1.add("Ajay");
      	
      	System.out.println("Printing tree set. Always Prints in alphabateical order"+treeSets1);
      	
      	Iterator iteratorTreeSet = treeSets1.iterator();
      	String strForTreeSet;
      	
      	while(iteratorTreeSet.hasNext()){
      		System.out.println("Print each value of a Tree ---"+iteratorTreeSet.next());
      	}
      	
      	
      	
        
      	TreeSet<Empl> treeSets2 = new TreeSet(new MySalaryComp());
      			
      	treeSets2.add(new Empl("Veeragh", 3000));
      	treeSets2.add(new Empl("Ravi", 300));
      	treeSets2.add(new Empl("Ajay", 6000));
      	treeSets2.add(new Empl("Laxman", 1000));
      	
      	System.out.println("Using Comparator to sort based on salary"+treeSets2);
      	Iterator iteratorTreeSet2 = treeSets2.iterator();
      	String strForTreeSet2;
      	
      	while(iteratorTreeSet2.hasNext()){
      		System.out.println("Using Comparator to sort based on salary ---"+iteratorTreeSet2.next());
      	}
      
        /*-----------------------------------Queue------------------------------------------------*/	   
        
      System.out.println("  /*-----------------------------------Queues------------------------------------------------*/");     
      PriorityQueue queue=new PriorityQueue();  
      queue.add("Amit");  
      queue.add("Vijay");  
      queue.add("Karan");  
      queue.add("Jai");  
      queue.add("Rahul");  
      System.out.println("head:"+queue.element());  
      System.out.println("head:"+queue.peek());  
      System.out.println("iterating the queue elements:");  
      Iterator itr=queue.iterator();  
      while(itr.hasNext()){  
      System.out.println(itr.next());  
      }  
      
      queue.remove();  
      queue.poll();  
      System.out.println("after removing two elements:");  
      Iterator itr2=queue.iterator();  
      while(itr2.hasNext()){  
      System.out.println(itr2.next());  
      } 
      	
      
      
      /*-----------------------------------Using ListIterator  ONLY FOR LISTS------------------------------------------------*/	   
      
    System.out.println("  /*-----------------------------------Using ListIterator  ONLY FOR LISTS------------------------------------------------*/");    
    
    
    ArrayList< String> ar = new ArrayList< String>();
    ar.add("ab");
    ar.add("bc");
    ar.add("cd");
    ar.add("de");

    ListIterator litr = ar.listIterator();
    while(litr.hasNext()){
    	System.out.print(litr.next()+" ");
    }
    	
    System.out.println();
    
    while(litr.hasPrevious()){
    	System.out.print("Reverse Order"+litr.previous()+" ");
    }
    
    /*-----------------------------------Using For loop iterator  ONLY FOR Objects which Implements Iterator interface------------------------------------------------*/	   
  System.out.println();  
  System.out.println("  /*-----------------------------------Using For loop iterator  ONLY FOR Objects which Implements Iterator interface------------------------------------------------*/");        

    LinkedList< String> ls = new LinkedList< String>();
    ls.add("a");
    ls.add("b");
    ls.add("c");
    ls.add("d");
    
   
    for(String strForloop : ls)
    {
     System.out.print(strForloop+" ");
    }
    
    
        /*-----------------------------------MAPS------------------------------------------------*/	        
	}
}


class MySalaryComp implements Comparator<Empl>{

   @Override
   public int compare(Empl e1, Empl e2) {
       if(e1.getSalary() < e2.getSalary()){
           return -1;
       } else {
           return 1;
       }
   }
}


class SearchComp implements Comparator<Empl>{
	 
    public int compare(Empl e1, Empl e2) {
        if(e1.getSalary() == e2.getSalary()){
            return 0;
        } else {
            return -1;
        }
    }
}
class Empl{
    
   private String name;
   private int salary;
    
   public Empl(String n, int s){
       this.name = n;
       this.salary = s;
   }
    
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public int getSalary() {
       return salary;
   }
   public void setSalary(int salary) {
       this.salary = salary;
   }
   public String toString(){
       return "Name: "+this.name+"-- Salary: "+this.salary;
   }
}
