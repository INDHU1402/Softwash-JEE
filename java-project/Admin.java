import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Admin implements Serializable {
	Shop shop;
	String shopName;
	String locality;
	String slot;
	String choice1;
	String choice2;
	String choice3;
	static int count = 100;
	List shop1 = new ArrayList();
	HashMap<String,String> shops = new HashMap<String,String>();
	HashMap<String,String> time = new HashMap<String,String>();
	
	
	
    
	void Menu1() {
		System.out.println("1.Add Shops");
	    System.out.println("2.Update Timeslots");
	    System.out.println("3.Display all shops");
	    System.out.println("4.Remove shop");
	    System.out.println("5.Exit");
	}
	
	void Menu() {
		System.out.println("1.Admin Login");
	    System.out.println("2.Admin Signup");
	    System.out.println("3.User Login");
	    System.out.println("4.User Signup");
	    System.out.println("5.Exit");
	}
	
    void Display1() {
    	
		char option = '\0';
		List<String>slots = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		Menu1();
	    do
	    {   
	       	System.out.println("Enter Your Option");
	       	option = scanner.next().charAt(0);
	    	switch(option) {
	    	case '1':
	    		Scanner s1 = new Scanner(System.in);
	    		int count2 = ++count;
	    		System.out.println("=========================");
	    	    System.out.println("Enter shop name: ");
	    	    shopName = s1.next();
	    	    System.out.println("Enter locality: ");
	    	    locality = s1.next();
	    	    System.out.println("Enter available time slots: ");
	    	    slot = s1.next();
	    	    String id = String.valueOf(count2); 
	    	    shops.put(id,shopName);
	    	    time.put(id, slot);
	    	    shop = new Shop(id,shopName,locality,slot); 
	    	    shop1.add(shop);
	    	    System.out.println("Successfully added a shop");
	    	    System.out.println("==========================");
	    	    System.out.println("Shop ID is " + count2);
	    	    Menu1();
	    	    break;
	    	  
	    	case '2':
	    		System.out.println("==========================");
	    		System.out.println("enter shop Id: ");
				choice1 = scanner.next();
			    for(int i = 0;i < shop1.size();i++) {
			    	if(choice1.equals(((Shop) shop1.get(i)).getId())) {
			    		System.out.println("Time slots: ");
			    		System.out.println(((Shop) shop1.get(i)).getSlot());
			    		System.out.println("Enter time slots: ");
			    		choice2 = scanner.next();
			    		((Shop) shop1.get(i)).setSlot(choice2);
			    		System.out.println("Successfully updated ");
			    		System.out.println("Time slots: ");
			    		System.out.println(((Shop) shop1.get(i)).getSlot());
			    	}}
			    break;
	    	case '3':
	    		System.out.println("==========================");
	    		for (int i = 0; i < shop1.size() ; i++) {
					System.out.println(shop1.get(i));
				}
	    		System.out.println("==========================");
	    		Menu1();
	    		break;
	    	case '4':
	    		System.out.println("==========================");
	    		System.out.println("enter shop Id: ");
	    		choice3 = scanner.next();
	    		for(int i = 0;i <= shop1.size();i++) {
	    			if(choice3.equals(((Shop) shop1.get(i)).getId())) {
	    				shop1.remove(((Shop) shop1.get(i)));
	    				System.out.println("Successfully removed shop with ID: "+choice3);
	    				break;
	    			}
	    		}
	    		System.out.println("==========================");
	    		Menu1();
	    		break;
	    	case '5':
	    		System.out.println("Successfully logged out!!");
	    		System.out.println("==========================");
	            break;
	        default:
	    		System.out.println("Invalid option!!! Please enter the valid Option");
	    		break;
	    	}
	    }
    	while(option != '5') ;
    
    	}
}
