package Model;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import Dao.CustomerDao;
import Dao.ItemDao;
import Servic.InputOutputServic;
import Servic.Utility;

public class Student extends Customer implements CustomerDao,ItemDao{
    private HashMap<String,Integer>  pointEarned= new HashMap<String,Integer>();
	private int totalPointsEarned=0;
    public Student() throws Exception {
		super();
		prepareEarnedPointForCustomer();
	}
		public Student(String phone) {
		super(phone);}
	
@Override
public int calculatePointForBuyItems(List<Item> items) throws Exception {
	int[] points=new int[3];
	for(Item f:items) {
	if(f.getCode()==1) {
		points[0]+=1;
	}else if(f.getCode()==2) {
		points[1]+=1;
	}else if(f.getCode()==3) {
		points[2]+=1;
	}}
	int smallest=Utility.smallest(points);
	if(smallest!=0) {
		this.totalPointsEarned+=20*smallest;
		points[0]-=smallest;
		points[1]-=smallest;
		points[2]-=smallest;
		this.totalPointsEarned+=points[0]*this.pointEarned.get("Fries");
		this.totalPointsEarned+=points[1]*this.pointEarned.get("SoftDrink");
		this.totalPointsEarned+=points[2]*this.pointEarned.get("SandWich");
		}
    System.out.println("<<You get ("+this.totalPointsEarned+") Points Earned>>");	
    return this.totalPointsEarned;
}

@Override
public void prepareEarnedPointForCustomer() throws Exception {
 ArrayList<Item> items=getAllItem();
		 for(Item item:items) {
	    if(item.getCode()==1) {
			this.pointEarned.put(item.getName(),3);
		}else if(item.getCode()==2) {
			this.pointEarned.put(item.getName(),1);
		}else if(item.getCode()==3) {
			this.pointEarned.put(item.getName(),15);
		}else if(item.getCode()==4) {
			this.pointEarned.put(item.getName(),20);
		}
 }
}
@Override
public void editCustomer(Customer cus) throws Exception {
	ArrayList<Customer> customers=getAllCustomerByType("student");
	for(int i=0;i<customers.size();i++) {
	Customer c=customers.get(i);
	//System.out.println(cus.getCellPhone()+"=="+c.getCellPhone());
	if(cus.getCellPhone().equals(c.getCellPhone())) {
		cus=customerAlreadyExist(cus);
	//	System.out.println("Arrive="+this.totalPointsEarned+"+"+cus.getCurrentPoint());
	//	System.out.println("row="+i);
		updateCustomer((this.totalPointsEarned+cus.getCurrentPoint())+"",i+1, 3);
	
		}
	}
	

	
}

}


      
	

	
	

	


