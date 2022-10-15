package Model;

public class Item {
private String name;
private int point;
private int code;
public Item() {
	super();
}
public Item(String name, int point) {
	super();
	this.name = name;
	this.point = point;

}
public Item(String name, int point,int code) {
	super();
	this.name = name;
	this.point = point;
	this.code=code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPoint() {
	return point;
}
public void setPoint(int point) {
	this.point = point;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
}
