import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class LaundryException1 extends Exception{
	public String toString() {
		return "Invalid User";
	}
}


class Customer extends User implements Serializable{
	private String userName;
	private String password;
	private String cpassword;
	private String contactNumber;
	private String address;
	

	File CP_file = new File("D://Admin.txt");
	File CP_file1 = new File("D://User.txt");
	
	HashMap<Integer,String> shops = new HashMap<Integer,String>();
	HashMap<String,String> time = new HashMap<String,String>();
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
		
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", password=" + password + ", cpassword=" + cpassword + ", contactNumber="
				+ contactNumber + ", address=" + address + ", CP_file=" + CP_file + ", CP_file1=" + CP_file1
				+ ", shops=" + shops + ", time=" + time + "]";
	}
	
}

public class Softwash extends User{
	
	Scanner scan = new Scanner(System.in);
	File CP_file = new File("D://Admin.txt");
	File CP_file1 = new File("D://User.txt");
	
	
	public Customer readObject1(ObjectInputStream is) {
		Customer object = null;
		try {
			object = (Customer)is.readObject();
			return object;
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		return object;
	}
	
	@SuppressWarnings("unchecked")
	
	
	

	public boolean signIn1(File CP_file) {
		try {
			FileInputStream fis = new FileInputStream(CP_file);
			ObjectInputStream is = new ObjectInputStream(fis);
			List<Customer> list;
			
			list = (ArrayList<Customer>)is.readObject();
			int i = 1;
			
			
			Customer customer = new Customer();
			System.out.print("Enter UserName  : ");
			String userName = scan.next();
			System.out.print("Enter Password : ");		
			String password = scan.next();
			
	
			
			
			for(Customer customer1 : list) {
				if(customer1.getUserName().equals(userName) && customer1.getPassword().equals(password)) {
					return true;
		    }

			}
			is.close();
			fis.close();
		}
		catch (Exception ex) {
			System.out.println(ex);
		}
		
		return false;
	}
	


	public void register1(File CP_file) {	
		List<Customer> list = new ArrayList<Customer>();
		
		Customer customer = new Customer();
		System.out.print("Enter UserName  : ");
		customer.setUserName(scan.next());
		System.out.print("Enter Address  : ");
		customer.setAddress(scan.next());
		System.out.print("Enter contactNumber  : ");
		customer.setContactNumber(scan.next());
		System.out.print("Enter Password : ");		
		customer.setPassword(scan.next());
		System.out.print("Enter to confirm Password : ");		
		customer.setCpassword(scan.next());
		
		FileInputStream fis;
		ObjectInputStream is;

		FileOutputStream fos;
		ObjectOutputStream os;
		
		 if((customer.getCpassword()).equals(customer.getPassword())) {
		
		try {			
			fis = new FileInputStream(CP_file);
			is = new ObjectInputStream(fis);			
			list = (ArrayList<Customer>)is.readObject();	
			is.close();
			fis.close();
		}
		catch (Exception e) { 
			
		}
		
		try {
			fos = new FileOutputStream(CP_file);
			os = new ObjectOutputStream(fos);
			
			list.add(customer);
			os.writeObject(list);
			os.close();
			fos.close();
		}
		catch (Exception ex) {			
		}
		
		System.out.println("Customer Registered Successfully!!! \n");
	}
		 else {
				try {
					throw new LaundryException1();
				}
				catch (LaundryException1 e) {
					e.printStackTrace();
				
			}
			}
	}
	public void mainMenu() {
		Softwash login = new Softwash();
		int choice = 0;
				
		System.out.println("Select Your Choice");
		System.out.println("==================");
			
		System.out.println("1. Admin Login");
		System.out.println("2. Admin SignUp");
		System.out.println("3. User Login");
		System.out.println("4. User SignUp");
		System.out.println("5. Exit \n");
			
		System.out.print("Enter Your Choice : ");
		choice = scan.nextInt();
		System.out.println();
			
		if(choice == 1) {
			if(login.signIn1(CP_file)) {
				System.out.println("Login successful \n");
				Display1();
				mainMenu();
				
			}
			else {
				System.out.println("Login Failed!!!\n");
				mainMenu();
			}
		}
		
		else if(choice == 2) {
			login.register1(CP_file);	
			mainMenu();
		}	
		else if(choice == 3) {
			if(login.signIn1(CP_file1)) {
				System.out.println("Login successful \n");
				Display2();
				mainMenu();
				//Display2();
				//Write your project code
			}
		    else {
						System.out.println("Login Failed!!!\n");
						mainMenu();
			}
				
			}
	    else if(choice == 4) {
				login.register1(CP_file1);	
				mainMenu();
			}	
		  
		else if(choice == 5) {
			System.out.println("Application Terminated!!");
		}
		else {
			mainMenu();
		}
	}
	
	public static void main(String[] args) {
	        Softwash obj = new Softwash();
		obj.mainMenu();
	}
}





