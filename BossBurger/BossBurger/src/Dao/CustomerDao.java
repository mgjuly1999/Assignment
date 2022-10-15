package Dao;
import java.io.*;
import java.io.FileWriter;

import java.io.IOException;
import java.text.DateFormat.Field;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import Model.Customer;
import Model.Item;
public interface  CustomerDao extends AbstractDao,ItemDao{
	
	public default Customer saveCustomer(Customer cus)
    { String data=cus.getFirstName()+","+cus.getLastName()+","+cus.getCellPhone()+","+cus.getCurrentPoint()+","+cus.getStatus();
     boolean flag=save("customer", data);
     if(flag) {
    	 System.out.println("SuccessSave");
    	  return cus;
      }else {
    	  return null;
      }
    }
	
	public default ArrayList<Customer> getAllCustomerByType(String type) throws Exception {
		    ArrayList<Customer> customers=new ArrayList<>();
		    ArrayList<String[]> dataRows=getAllData("customer");
		    for (String [] row:dataRows) {
				Customer customer=new Customer(row[0].replace("\"", ""),row[1].replace("\"", ""),row[2].replace("\"", ""),Integer.parseInt(row[3].replace("\"", "")),row[4].replace("\"", ""));
				if(row[4].trim().equals("\""+type+"\"")||row[4].trim().equals(type)) {
					customers.add(customer);
					}
				}
	        return customers;
		 }
	
	public default  void updateCustomer(String replace,int row, int col) throws IOException {
		    updateCell(replace, "customer", row, col);
		}
	
    public default Customer customerAlreadyExist(Customer cus) throws IOException {
    	String[] row=testAlreadyExist(cus.getCellPhone(),"customer",2);
    	if(null!=row) {
    		cus.setFirstName(row[0]);
    		cus.setLastName(row[1]);
    		cus.setCellPhone(row[2]);
    		cus.setCurrentPoint(Integer.parseInt(row[3].replace("\"", "")));
    		cus.setStatus(row[4]);
    		System.out.println("Customer Already Exist!");
    		return cus;
    	}
		return null;
    	
    }
    public default ArrayList<Item> redeemPointsByCustomer(Customer customer) throws Exception {
    	customer=customerAlreadyExist(customer);
    	if(customer!=null) {
    	ArrayList<Item> items=getAllItem();
    	ArrayList<Item> availableItem=new ArrayList<>();
    	for(Item item:items) {
    	if(customer.getCurrentPoint()>=item.getPoint()) {
    		availableItem.add(item);
    	}
    	}
		return availableItem;
    	}else {
    	return null;	
    	}
    }
    public default void buyItemWithPointReq(Item pointRequire,Customer customer) throws IOException {
    	int row=getRowNoByKey(customer.getCellPhone(),"customer",2);
    	System.out.println(customer.getCurrentPoint()+"-"+pointRequire.getPoint());
    	updateCustomer((customer.getCurrentPoint()-pointRequire.getPoint())+"",row,3);
    	System.out.println("Successful Process!!");
    }
}
