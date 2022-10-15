package Conroller;

import java.io.IOException;

import Model.Student;
import Servic.InputOutputServic;

public class BugerApp implements processController {
    public  void processBossBuger() throws Exception {
    	int num=0;
		do {
			num=typesOfAllProcess();
			
			  switch(num) {
			  case 1:
				  toBuyItem();
			    break;
			  case 2:
				showAllDataController();
			    break;
			  case 3:
				  registrarionController();
			   break;
			  case 4:
				  redeemPointsForFreeItem();
			    break;
			  default:
			}}while((num>0)&&(num<5));

    }
	public static void main(String[] args) throws Exception {
		BugerApp bg=new BugerApp();
		bg.processBossBuger();
	}

}
