package Model;
import java.util.List;
public class Customer {
private String firstName;
private String lastName;
private String cellPhone;
private String status;
private int index;
private int currentPoint;
public Customer() {
	super();
}

public Customer( String cellPhone) {
	super();
	this.cellPhone = cellPhone;
}
public Customer(String firstName, String lastName, String cellPhone, int currentPoint,String status) {
	super();
	this.status=status;
	this.firstName = firstName;
	this.lastName = lastName;
	this.cellPhone = cellPhone;
	this.currentPoint = currentPoint;
}

public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getCellPhone() {
	return cellPhone;
}
public void setCellPhone(String cellPhone) {
	this.cellPhone = cellPhone;
} 
public int getCurrentPoint() {
	return currentPoint;
}
public void setCurrentPoint(int currentPoint) {
	this.currentPoint = currentPoint;
}


public int calculatePointForBuyItems(List<Item> items) throws Exception   {
	return currentPoint;
	
}
public void prepareEarnedPointForCustomer() throws Exception {

}
public void editCustomer(Customer customer) throws Exception {
	
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public int getIndex() {
	return index;
}

public void setIndex(int index) {
	this.index = index;
}


}
