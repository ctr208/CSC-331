package test1;

import java.util.ArrayList;

public class Bag {
	ArrayList<String> bag = new ArrayList<>();
	private static int newBagNum = 1;
	private int bagNum;
	
	public Bag() {
		this.bagNum = newBagNum;
		newBagNum ++;
	}
	
	public String toString() {
		if(bag.size()==0) {
			return "Bag "+ bagNum + " contents:";
		}if (bag.size()==1) {
			return "Bag "+ bagNum + " contents:" + bag.get(0);
		}if (bag.size()==2) {
			return "Bag "+ bagNum + " contents:" + bag.get(0) +" " +bag.get(1);
		}if (bag.size() == 3) {
			return "Bag "+ bagNum + " contents:" + bag.get(0) +" " +bag.get(1)+" "+ bag.get(2);
		}if (bag.size() == 4) {
			return "Bag "+ bagNum + " contents:" + bag.get(0) +" " +bag.get(1)+" "+ bag.get(2) +" "+bag.get(3);
		}if (bag.size() == 5) {
			return "Bag "+ bagNum + " contents:" + bag.get(0) +" " +bag.get(1)+" "+ bag.get(2) +" "+bag.get(3) +" "+ bag.get(4);
		}if(bag.size()==6) {
			return "Bag "+ bagNum + " contents:" + bag.get(0) +" " +bag.get(1)+" "+ bag.get(2) +" "+bag.get(3) +" "+ bag.get(4)+" "+ bag.get(5);
		}if(bag.size()==7) {
			return "Bag "+ bagNum + " contents:" + bag.get(0) +" " +bag.get(1)+" "+ bag.get(2) +" "+bag.get(3) +" "+ bag.get(4)+" "+ bag.get(5)+" "+bag.get(6);
		}
		return null;
		
	}
	
	public int count(String item) {
		int count = 0;
		int itemCount = 0;
		while (count < bag.size()) {
			if (item == bag.get(count)) {
				itemCount++;
				count++;
			}
			count++;

		}
		return itemCount;
	}
	
	public void addTo(String item) {
		bag.add(item);
	}
	

}
