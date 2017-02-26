package src.GUI;

import java.util.ArrayList;
import java.util.Random;

public class Reel {

	symbol obj1 = new symbol();
	symbol obj2 = new symbol();
	symbol obj3 = new symbol();
	symbol obj4 = new symbol();
	symbol obj5 = new symbol();
	symbol obj6 = new symbol();
	ArrayList<symbol> symbolArryList = new ArrayList<symbol>();

	Reel() {
		obj1.setImage("images/redseven.png", "seven");
		obj1.setValue(7);
		symbolArryList.add(obj1);

		obj2.setImage("images/bell.png", "bell");
		obj2.setValue(6);
		symbolArryList.add(obj2);

		obj3.setImage("images/watermelon.png", "watermelon");
		obj3.setValue(5);
		symbolArryList.add(obj3);

		obj4.setImage("images/plum.png", "plum");
		obj4.setValue(4);
		symbolArryList.add(obj4);

		obj5.setImage("images/lemon.png", "lemon");
		obj5.setValue(3);
		symbolArryList.add(obj5);

		obj6.setImage("images/cherry.png", "cherry");
		obj6.setValue(2);
		symbolArryList.add(obj6);
		
	}

	public Isymbol[] spin() {
		Isymbol[] arrayIsymbol = new Isymbol[6];
		for(int x =0;x<6;x++){
			int max = symbolArryList.size();
			Random rn = new Random();
			int answer = rn.nextInt(max);
			arrayIsymbol[x]= symbolArryList.remove(answer);
		}
		return arrayIsymbol;
	}

}
