package greedy.misc;

import java.util.ArrayList;
import java.util.List;

public class KnapSack {

	public static void main(String[] args) {
		int val[] = new int[] { 100, 60, 120 };
		int wt[] = new int[] { 20, 10, 30 };
		int weight = 50;

		int knapsackValue = knapsack01Utils(val, wt, weight, false);
		System.out.println("value :: "+knapsackValue);
		
		int fractionalKnapsackValue = knapsack01Utils(val, wt, weight, true);
		System.out.println("fractional value :: "+fractionalKnapsackValue);
		
		System.out.println("------------------------------------");
		int[] wtNew = {10, 40, 20, 30}; 
        int[] valNew = {60, 40, 100, 120};
        
        weight = 60;
        knapsackValue = knapsack01Utils(valNew, wtNew, weight, false);
		System.out.println("value :: "+knapsackValue);
		
		fractionalKnapsackValue = knapsack01Utils(valNew, wtNew, weight, true);
		System.out.println("fractional value :: "+fractionalKnapsackValue);
	}

	private static int knapsack01Utils(int[] val, int[] wt, int weight, boolean fractional) {
		List<Item> itemList = buildItems(wt, val);
		if (itemList == null || itemList.isEmpty())
			return 0;

		if(!fractional) {
			itemList.sort((item2, item1) -> item2.getValue().compareTo(item1.getValue()));
			return knapsack01(itemList, weight, itemList.size() - 1);
		} else { 
			itemList.sort((item2, item1) -> item1.getCost().compareTo(item2.getCost()));
			return (int)fractionalKnapsack(itemList, weight);
		}
	}

	private static double fractionalKnapsack(List<Item> itemList, int weight) {
		double value = 0;
		for (Item item : itemList) {
			if(weight - item.getWeight() >= 0) {
				value += item.getValue();
				weight -= item.getWeight();
				if(weight == 0)
					break;
			} else {
				double cost = item.getCost() * weight;
				value += cost;
				break;
			}
		}
		return value;
	}

	private static int knapsack01(List<Item> itemList, int weight, int index) {
		if (index <= 0 || weight <=0)
			return 0;
		Item item = itemList.get(index);
		
		if(weight - item.getWeight() < 0)
			return 0;
		
		if (weight - item.getWeight() == 0) {
			return Math.max(item.getValue(), knapsack01(itemList, weight, index - 1));
		}

		return Math.max(knapsack01(itemList, weight, index - 1),
				item.getValue() + knapsack01(itemList, weight - item.getWeight(), index - 1));
	}

	private static List<Item> buildItems(int[] wt, int[] val) {
		List<Item> itemList = new ArrayList<>();
		if (wt == null && val == null)
			return itemList;

		for (int i = 0; i < val.length; i++) {
			itemList.add(new Item(wt[i], val[i]));
		}
		return itemList;
	}
}

final class Item {
	private Integer weight;
	private	Integer value;
	private Double cost;

	public Item(Integer weight, Integer value) {
		super();
		this.weight = weight;
		this.value = value;
		this.cost = (double)value /(double) weight;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getValue() {
		return value;
	}
	
	public Double getCost() {
		return cost;
	}

}
