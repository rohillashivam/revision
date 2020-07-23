package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoElementSumEqualRest {

	public static void main(String[] args) {
		int[] arr = {2, 11, 5, 1, 4, 7};
		if(printTwoElements(arr)) {
			System.out.println("elements exists");
		} else {
			System.out.println("element doesn't exists");
		}
		//int[] arrNew 
	}

	private static boolean printTwoElements(int[] arr) {
		int sum=0;
		for(int i=0; i<arr.length; i++) 
			sum += arr[i];
		
		if(sum % 2 != 0)
			return false;
		sum = sum >> 1;
		Map<Integer, Integer> dataMap = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			int sumVal = sum-arr[i];
			if(dataMap.containsKey(sumVal)) {
				System.out.println("elements :: "+arr[i]+", "+sumVal);
				return true;
			}
			int val=0;
			if(dataMap.containsKey(arr[i]))
				val = dataMap.get(arr[i]);
			val++;
			dataMap.put(arr[i], val);
		}
		return false;
	}
}
