import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class User extends Admin implements Serializable{
	
	String contact;
	String address;
	static int count = 100;
	static int id = 0 ;
	List<Integer>items = new ArrayList<Integer>();
	List<String>list1 = new ArrayList<String>();
	HashMap<String,Integer> dresses = new HashMap<String,Integer>();
	HashMap<String,Integer> bill = new HashMap<String,Integer>();
	
	
	 @Override
	public String toString() {
		return "Display2 [contact=" + contact + ", address=" + address + ", items=" + items + ", list1=" + list1
				+ ", dresses=" + dresses + ", bill=" + bill + "]";
	}

	void Menu1() {
		System.out.println("1.Add Shops");
	    System.out.println("2.Update Timeslots");
	    System.out.println("3.Display all shops");
	    System.out.println("4.Remove shop");
	    System.out.println("5.Exit");
	}

	void Display2() {
	    String choice ;
	    String choice1;
		System.out.println("Select Shop with Id");
		System.out.println("==========================");
		
		for (int i = 0; i < shop1.size() ; i++) {
			System.out.println(shop1.get(i));
		}
		Scanner scanner = new Scanner(System.in);
		choice = scanner.next();
		String name = null;
		String available_slot = null;
		for(int i = 0;i < shop1.size();i++) {
	    	if(choice.equals(((Shop) shop1.get(i)).getId())) {
	    		available_slot = ((Shop) shop1.get(i)).getSlot();
	    		name = ((Shop) shop1.get(i)).getShopName();
	    		}
	    	}
	    dresses.put("Pants",30);
	    dresses.put("Sarees",40);
	    dresses.put("Household",45);
	    dresses.put("Kurtas",50);
	    dresses.put("Shirts",35);
	    
	    System.out.println("Items        "+" | "+"Quantity"+"| "+"Price");
	    System.out.println("=============================================");
	    System.out.println("Pants         "+"| "+ 1+"        | "+ "30/-");
	    System.out.println("Sarees        "+"| "+ 1+"        | "+ "40/-");
	    System.out.println("Household     "+"| "+ 1+"        | "+ "45/-");
	    System.out.println("Kurtas        "+"| "+ 1+"        | "+ "50/-");
	    System.out.println("Shirts        "+"| "+ 1+"        | "+ "35/-");
	    System.out.println("--------------------------------------");
	    
	    System.out.println("Enter number of Pants -");
	    Scanner scanner4 = new Scanner(System.in);
	    int pants = scanner4 .nextInt();
	    int totalpants = pants * dresses.get("Pants");
	    items.add(totalpants);
	    bill.put("Pants",totalpants);
	    
	    System.out.println("Enter number of Sarees -");
	    Scanner scanner5 = new Scanner(System.in);
	    int sarees = scanner5 .nextInt();
	    int totalsarees = sarees * dresses.get("Sarees");
	    items.add(totalsarees);
	    bill.put("Sarees",totalsarees);
	    
	    System.out.println("Enter number of HouseholdItems -");
	    Scanner scanner6 = new Scanner(System.in);
	    int House = scanner6 .nextInt();
	    int tothouse = House * dresses.get("Household");
	    items.add(tothouse);
	    bill.put("DesignerSarees",tothouse);
	    
	    System.out.println("Enter number of Kurtas -");
	    Scanner scanner7 = new Scanner(System.in);
	    int Kur = scanner7 .nextInt();
	    int totKur = Kur * dresses.get("Kurtas");
	    items.add(totKur);
	    bill.put("Kurtas",totKur);
	    
	    System.out.println("Enter number of Shirts -");
	    Scanner scanner8 = new Scanner(System.in);
	    int Shirts = scanner8 .nextInt();
	    int totshi = Shirts * dresses.get("Shirts");
	    items.add(totshi);
	    bill.put("Shirts",totshi);
	    
	    
		
	    System.out.println("Enter address: ");
		Scanner scanner1 = new Scanner(System.in);
		address = scanner1.next();
		
		System.out.println("Enter contactNumber: ");
		Scanner scanner13 = new Scanner(System.in);
		contact = scanner13.next();
	    id  = count++;
	    System.out.println("Order confirmed");
	    System.out.println("Order-ID : "+id);
	    System.out.println("===========================");
	    System.out.println("********* Softwash *******");
	    System.out.println("Items        "+" | "+"Quantity"+"| "+"Price");
	    System.out.println("===============================================");
	    System.out.println("Pants        "+" | "+ pants+"       | "+ totalpants);
	    System.out.println("Sarees       "+" | "+ sarees+"       | "+ totalsarees);
	    System.out.println("Household    "+" | "+ House+"       | "+ tothouse);
	    System.out.println("Kurtas       "+" | "+ Kur+"       | "+ totKur);
	    System.out.println("Shirts       "+" | "+Shirts+"       | "+ totshi);
	    int count_i = 0;
	    for(int i :items) {
	    	count_i = count_i + i;
	    }
	    System.out.println("============================");
	    System.out.println("Total Bill is : " +count_i);
	    System.out.println("Your Address is : " + address);
	    System.out.println("Your Contact number : " + contact);
	    System.out.println("You ordered to : " + name);
		System.out.println("Your Timeslot is : " + available_slot );
		System.out.println("============================");
		System.out.println("Thank you for using our services ");
		File f = new File("D://Orders.txt");{
			try {
		        BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
		        bw.append("********* Softwash *******");
		        bw.newLine();
		        bw.append("Order confirmed \n");
		        bw.newLine();
		        bw.append("Items        "+" | "+"Quantity"+"| "+"Price");
			    bw.newLine();
			    bw.append("===============================================");
			    bw.newLine();
			    bw.append("Pants        "+" | "+ pants+"       | "+ totalpants);
			    bw.newLine();
			    bw.append("Sarees       "+" | "+ sarees+"       | "+ totalsarees);
			    bw.newLine();
			    bw.append("Household    "+" | "+ House+"       | "+ tothouse);
			    bw.newLine();
			    bw.append("Kurtas       "+" | "+ Kur+"       | "+ totKur);
			    bw.newLine();
			    bw.append("Shirts       "+" | "+Shirts+"       | "+ totshi);
			    bw.newLine();
		        bw.append("Total Bill is " +count_i);
		        bw.newLine();
		        bw.append("Your Address is " + address);
		        bw.newLine();
		        bw.append("Your Contact number is " + contact);
		        bw.newLine();
		        bw.append("You ordered to " + shops.get(choice));
		        bw.newLine();
		        bw.append("Your Timeslot is " + choice3);
		        bw.newLine();
		        bw.append("*******"+"  "+"The End"+"  "+"*******");
		        bw.newLine();
		        bw.close();
		        
		    } catch (IOException e) {
		    	e.printStackTrace();
		    }
			}
		}

	private void charAt(int i) {
		// TODO Auto-generated method stub
		
	}
	
	    
}
