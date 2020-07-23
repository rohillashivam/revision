package arrays;

import java.util.HashSet;
import java.util.Set;

public class TripletWithZeroSum {

	public static void main(String[] args) {
		int[] arr= {0, -1, 2, -3, 1};
		printTripletWithZeroSum(arr);
	}

	private static void printTripletWithZeroSum(int[] arr) {
		Set<Integer> dataSet = new HashSet<>();
		for(int i=0; i<arr.length; i++) {
			if(dataSet.size() > 0)
				dataSet.clear();
			for(int j=0; j<arr.length; j++) {
				if(i == j) {
					dataSet.add(arr[j]);
					continue;
				}
				int indexSum = -(arr[i]+arr[j]);
				if(dataSet.contains((indexSum))) {
					System.out.println("indexes :: "+arr[i]+" , "+arr[j]+" "+indexSum);
				}
				dataSet.add(arr[j]);
			}
		}
	}
}
