package Conroller;

import java.io.IOException;
import java.util.ArrayList;

import Dao.CustomerDao;
import Dao.ItemDao;
import Model.Adult;
import Model.Customer;
import Model.Item;
import Model.Senior;
import Model.Student;
import Servic.InputOutputServic;
import Servic.Utility;

public interface processController extends InputOutputServic,CustomerDao,ItemDao{
	
	public default void registrarionController() throws Exception{
		int choice=0;
		do {
		    choice=inputTypeOfRegistration(); 
		    if(choice==1){
		    Customer cus=new Customer();
			cus=prepareForInputCustomer(cus);
			saveCustomer(cus);
			}else if(choice==2){
				saveItem(prepareForInputItem());
			}else if(choice==3){
			    saveItem(prepareForInputItem());
			}else if(choice!=4) {
			System.out.println("<<<<<Please Correct Input>>>>");}
		}while(choice!=4);}
	
	
	
	public default void showAllDataController() throws Exception{
		int choice=0;
		do {choice=inputTypeOfShowAllData();
		if(choice==1){
			System.out.println("Select Customer Type(Student,Senior,Adult)");
		    String type=Utility.br.readLine().trim().toLowerCase();
		    getAllCustomerByType(type);
		    displayAllCustomer( getAllCustomerByType(type));
		}else if(choice==2){
			displayAllItem(getAllItem());
		}else if(choice!=3){
			System.out.println("Please Enter Correct Input!!");
		}
		}while(choice!=3);}
	
	
	public default void toBuyItem() throws Exception{
		 Customer cuph=prepareCustomerWithPhoneNo();
	     Customer customer=customerAlreadyExist(cuph);
		if(customer==null){
			customer=prepareForInputCustomer(cuph);
			saveCustomer(customer);}
		    ArrayList<Item> items=getUserChoices();
		if(customer.getStatus().equals("student")){
		    Student student=new Student();
		    customer.setCurrentPoint(customer.getCurrentPoint()+student.calculatePointForBuyItems(items));
		    student.editCustomer(customer);
		}else if(customer.getStatus().equals("adult")){
			Adult adult=new Adult();
			customer.setCurrentPoint(customer.getCurrentPoint()+adult.calculatePointForBuyItems(items));
			adult.editCustomer(customer);
		}else if(customer.getStatus().equals("senior")){
			Senior senior=new Senior();
			customer.setCurrentPoint(customer.getCurrentPoint()+senior.calculatePointForBuyItems(items));
			senior.editCustomer(customer);}
	     }
	
	public default ArrayList<Item> getUserChoices() throws Exception{
		int choice=0;
		ArrayList<Item> items=null;
		ArrayList<Item> itemsChoice=new ArrayList<>();
		do{
			System.out.println("<<<<Choose Item For Buy>>>>");
			items=getAllItem();
			displayAllItem(items);
			System.out.println("("+(items.size()+1)+")Exist For Buy Item");
		    choice=Integer.parseInt(Utility.br.readLine());
		    if(choice<=(items.size()-1)&&choice>=1){
		    itemsChoice.add(items.get(choice-1));}
		}while(choice<(items.size()+1)&&choice>=1);
		return itemsChoice;	
	}
	public default void itemRegisterController() throws IOException{
		 saveItem(prepareForInputItem());
	}
	
	public default void redeemPointsForFreeItem() throws IOException, Exception {
		   Customer customer=prepareCustomerWithPhoneNo();
           ArrayList<Item> pointRequires=redeemPointsByCustomer(customer);
           if(pointRequires!=null) {
           Item pointRequire=prepareInputForFreeItem(pointRequires);
           if(pointRequire!=null) {
        	  buyItemWithPointReq(pointRequire,customer); 
           }else {
           System.out.println("You Don't Have Enough Point!!");
           }
           }else {
           System.out.println("Account Don't Exist!!!");
           }
	}
	
	}
