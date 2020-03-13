package lab3;

import java.util.*;

public class Knapsack {
	private int capacity;

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Knapsack(int capacity) {
		super();
		this.capacity = capacity;
	}
	private List<Item> items = new ArrayList<>();
	
    public void addItem(Item item) {
    	 items.add(item);
    	 }

	public void problem() {
		int currentweight = 0, totalValue=0;
		double maxValue = 0, itemWeight=0;
		String itemName = null, bigName = null;
		List<String> names = new ArrayList<>();
		while(currentweight<capacity) {
			maxValue=0;
			for(Item item: items) {
				if(item.getValue()>maxValue && (names.contains(item.getName()) || names.isEmpty())) {
					maxValue = item.getValue();
					itemWeight = item.getWeight();
					itemName = item.getName();
					}
				
			}
			totalValue += maxValue;
			currentweight += itemWeight;
			names.add(itemName);
			System.out.println(itemName);
		}
		System.out.println(totalValue);
		
	}
}
