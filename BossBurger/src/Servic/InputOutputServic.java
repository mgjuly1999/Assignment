package Servic;

import java.io.IOException;
import java.text.DateFormat.Field;
import java.util.ArrayList;
import Dao.CustomerDao;
import Dao.ItemDao;
import Model.Adult;
import Model.Customer;
import Model.Item;
import Model.Senior;
import Model.Student;

public interface InputOutputServic {
	public default Customer prepareForInputCustomer(Customer customer) throws IOException {
		 if(customer.getCellPhone()==null) {
			 System.out.println("Enter Phone No:");
			 customer.setCellPhone(Utility.br.readLine()); 
		 }
		 System.out.println("Enter User First Name");
		 customer.setFirstName(Utility.br.readLine());
		 System.out.println("Enter User Last Name");
		 customer.setLastName(Utility.br.readLine());
		 customer.setCurrentPoint(50);
		 System.out.println("Enter Status(Student,Senior,Adult)");
		 customer.setStatus(Utility.br.readLine().toLowerCase());
 		 return customer;
	}
	public default Item prepareForInputItem() throws IOException {
		 Item item=new Item();
		 System.out.println("Enter Item Name");
		 item.setName(Utility.br.readLine());
		 System.out.println("Enter Point");
		 item.setPoint(Integer.parseInt(Utility.br.readLine()));
		 System.out.println("Enter Code");
		 item.setCode(Integer.parseInt(Utility.br.readLine()));
		 return item;
	}
	
	public default ArrayList<Customer> displayAllCustomer(ArrayList<Customer> customers) throws Exception {
		int count=1;
		    System.out.printf("%-20s","(No)");
		    System.out.printf("%-20s","|Name");
			System.out.printf("%-20s","|Phone");
			System.out.printf("%-20s","|Points");
			System.out.printf("%-20s","|Status");
			System.out.print("\n");
			for (Customer c:customers){
			    System.out.printf("%-20s","|("+count+")");
			    System.out.printf("%-20s","|"+c.getFirstName()+c.getLastName());
				System.out.printf("%-20s","|"+c.getCellPhone().substring(2));
				System.out.printf("%-20s","|"+c.getCurrentPoint());
				System.out.printf("%-20s","|"+c.getStatus());
				System.out.println();
				count++;
			    }
	return customers;}
	
		
		public default void displayAllItem(ArrayList<Item> items) throws Exception {
		     int count=1;
		     System.out.printf("%-20s","|(No)");
				System.out.printf("%-20s","|Name");
				System.out.printf("%-20s","|PointReq");
				System.out.println();
			 for (Item item:items) {
			    System.out.printf("%-20s","|("+count+")");
				System.out.printf("%-20s","|"+item.getName());
				System.out.printf("%-20s","|"+item.getPoint());
				System.out.println();
				count++;
		}
		}
		
	public default int inputTypeOfRegistration() throws Exception {
		int choice=0;
		System.out.println("<<<<<ChoosePro>>>>>");
		System.out.println("(1)Registration Customer");
		System.out.println("(2)Registration Item");
		System.out.println("(3)Registration PointRequire");
		System.out.println("(4)Exit");
		return choice=Integer.parseInt(Utility.br.readLine());
	}
	
	public default int inputTypeOfShowAllData() throws Exception {
		int choice=0;
		System.out.println("<<<<<ChoosePro>>>>");
		System.out.println("(1)Show All Customers Data");
		System.out.println("(2)Show All Item Data");
		System.out.println("(3)Exit");
		return choice=Integer.parseInt(Utility.br.readLine());
		
		}
	 
		public default int typesOfAllProcess() throws NumberFormatException, IOException {
			System.out.println("<<<<<ChooseTypeOfProcess>>>>");
			System.out.println("(1)To Buy Item");
			System.out.println("(2)For Show Data");
			System.out.println("(3)Registration");
			System.out.println("(4)Redeem points for a free item");
			System.out.println("(5)Add and edit customer information.");
			System.out.println("(6)Exit");
			int choice=Integer.parseInt(Utility.br.readLine());
			if(choice>=1&&choice<=6) {
				return choice;}
			else {
				System.out.println("<<<<<Please Correct Input>>>>");
				typesOfAllProcess();
			}
			return 0;
		}
		
		public default Customer prepareCustomerWithPhoneNo() throws IOException {
			System.out.println("Enter phone number");
			String phone=Utility.br.readLine();
			Customer customer=new Customer("66"+phone);
			return customer;
			
		}
		public default Item prepareInputForFreeItem(ArrayList<Item> items) throws NumberFormatException, IOException {
			if(items.size()!=0) {
				System.out.println("<<Choose Item To Buy with Point>>");
		        System.out.printf("%-10s","|(No)");
				System.out.printf("%-10s","|Item Name");
				System.out.printf("%-10s","|PointReq");
				System.out.println();
			int count=1;
			for(Item pq:items) {
				System.out.printf("%-10s","|("+count+")");
				System.out.printf("%-10s","|"+pq.getName());
				System.out.printf("%-10s","|"+pq.getPoint());
				System.out.println();
				count++;
			}
			return items.get(Integer.parseInt(Utility.br.readLine())-1);
			}else {
			return null;
			}
		
		}
		
}
