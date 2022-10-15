package Dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import Model.Customer;
import Model.Item;

public abstract interface AbstractDao{
	public default  boolean save(String type,String Data)
    {   
       PrintWriter csvWriter;
        try
        {  
            File file = new File("src\\"+type+".csv");
            if(!file.exists()){
                file = new File("src\\"+type+".csv");
            }
            csvWriter = new  PrintWriter(new FileWriter(file,true));
            csvWriter.print(Data);
            csvWriter.append('\n');
            csvWriter.close();}
	        catch (Exception e){
	        	
            e.printStackTrace();
            return false;}
		return true;
    }
	public default ArrayList<String[]> getAllData(String location) throws Exception {
		  ArrayList<String[]> dataRows=new ArrayList<>();
		  String file = "src\\"+location+".csv";
		  BufferedReader reader = null;  
		  String line = "";
		  try {
		    reader = new BufferedReader(new FileReader(file));
		    while((line = reader.readLine()) != null) {
			String[] row = line.split(",");
			dataRows.add(row);
		   }}
		  catch(Exception e) {
		   e.printStackTrace();}
		  finally {
		   try {
		    reader.close();
		   } catch (IOException e) {
		    e.printStackTrace();
		   }}
		  return dataRows;
		 }
	public default  void updateCell(String replace,String type,
		    int row, int col) throws IOException {
		File inputFile = new File("src\\"+type+".csv");
		CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
		List<String[]> csvBody = reader.readAll();
		csvBody.get(row)[col] = replace;
		reader.close();
		CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
		writer.writeAll(csvBody);
		writer.flush();
		writer.close();
		}
	
	public default String[] testAlreadyExist(String key,String type,int col) throws IOException {
		
		File inputFile = new File("src\\"+type+".csv");
		CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
		List<String[]> csvBody = reader.readAll();
		reader.close();
		for(String[] row:csvBody) {
			if(row[col].replace("\"", "").trim().equals(key)||row[col].trim().equals(key)){
				
				return row;
			}
		}
		return null;

	}
	
public default int getRowNoByKey(String key,String type,int col) throws IOException {
		
		File inputFile = new File("src\\"+type+".csv");
		CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
		List<String[]> csvBody = reader.readAll();
		reader.close();
		int count=0;
		for(String[] row:csvBody) {
			if(row[col].replace("\"", "").trim().equals(key)){
				
				return count;
			}
			count++;
		}
		return -1;

	}

}
