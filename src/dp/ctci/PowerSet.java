package dp.ctci;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PowerSet {

	public static void main(String[] args) {
		int k=3;
		Set<List<Integer>> powerSet = buildPowerSet(k);
		printPowerSet(powerSet);
		powerSetByRec(k);
	}

	private static void powerSetByRec(int k) {
		int size = ((Double)Math.pow(2, k)).intValue();
		
		Set<List<Integer>> powerSet = new LinkedHashSet<>();
		buildPowerSetRec(size, powerSet);
	}

	private static void buildPowerSetRec(int size, Set<List<Integer>> powerSet) {
		if(size == 0) {
			powerSet.add(new ArrayList<Integer>());
			return;
		}
	}

	private static Set<List<Integer>> buildPowerSet(int k) {
		Double size = Math.pow(2, k);
		int intSize = size.intValue();
		Set<List<Integer>> dataSet = new LinkedHashSet<>();
		for(int i=0; i<intSize; i++) {
			List<Integer> dataList = new ArrayList<>();
			String binString = Integer.toBinaryString(i);
			if(binString.equals("0")) {
				dataSet.add(dataList);
				continue;
			}
			for(int j=0; j<binString.length(); j++) {
				if(binString.charAt(j) == '1') {
					dataList.add(binString.length() - j);
				}
			}
			dataSet.add(dataList);
			
		}
		return dataSet;
	}

	private static void printPowerSet(Set<List<Integer>> dataSet) {
		for (List<Integer> list : dataSet) {
			if(list == null || list.isEmpty()) {
				System.out.println("{}");
				continue;
			}
			for (Integer data : list) {
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}
}
