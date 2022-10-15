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
public interface  ItemDao extends AbstractDao{
	
	
	public default Item saveItem(Item item){
		
        String data=item.getName()+","+item.getPoint()+","+item.getCode();
        if(save("item",data )) {
        	return item;
        }else {
        	return null;
        }
    }
	public default ArrayList<Item> getAllItem() throws Exception {
		  ArrayList<Item> items=new ArrayList<>();
		  ArrayList<String[]> rowDatas=getAllData("item");
		  for(String[] row:rowDatas) {
			Item item=new Item(row[0],Integer.parseInt(row[1]),Integer.parseInt(row[2]));
			items.add(item);
		  }
		  return items;
		 }
	
	public default  void updateItem(String replace,
		    int row, int col) throws IOException {
            updateCell(replace,"item", row, col);
		}
	

}
