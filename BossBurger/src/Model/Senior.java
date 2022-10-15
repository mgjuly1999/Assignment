package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import Dao.CustomerDao;
import Dao.ItemDao;
import Servic.InputOutputServic;
import Servic.Utility;

public class Senior extends Customer implements CustomerDao,ItemDao {
    private HashMap<String,Integer>  pointEarned= new HashMap<String,Integer>();
	private int totalPointsEarned=0;
    public Senior() throws Exception {
		super();
		prepareEarnedPointForCustomer();
	}
		public Senior(String phone) {
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
			this.pointEarned.put(item.getName(),0);
		}else if(item.getCode()==2) {
			this.pointEarned.put(item.getName(),0);
		}else if(item.getCode()==3) {
			this.pointEarned.put(item.getName(),20);
		}else if(item.getCode()==4) {
			this.pointEarned.put(item.getName(),30);
		}
 }
}
@Override
public void editCustomer(Customer cus) throws Exception {
	ArrayList<Customer> customers=getAllCustomerByType("senior");
	for(int i=0;i<customers.size();i++) {
	Customer c=customers.get(i);
	if(cus.getCellPhone().equals(c.getCellPhone())) {
		updateCustomer(this.totalPointsEarned+cus.getCurrentPoint()+"",i+1, 3);
		}
	}
	

	
}

}
