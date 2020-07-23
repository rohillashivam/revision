package arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubArrayWithEqual01 {

	public static void main(String[] args) {
		int arr[] = {1, 0, 1, 1, 1, 0, 0};
		SubArrayWithEqual01 sawe = new SubArrayWithEqual01();
		sawe.findSubArrayWithEqual01(arr);
	}

	private void findSubArrayWithEqual01(int[] arr) {
		Map<Integer, List<Integer>> mapList = new HashMap<>();
		int prefixSum= 0, maxLength = 1;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) 
				arr[i] = -1;
			prefixSum += arr[i];
			List<Integer> indexList = null;
			if(mapList.containsKey(prefixSum)) {
				indexList = mapList.get(prefixSum);
				int currLength = i - indexList.get(0);
				maxLength = Math.max(maxLength, currLength);
			} else {
				indexList = new LinkedList<>();
			}
			indexList.add(i);
			mapList.put(prefixSum, indexList);
		}
		System.out.println("max length :: "+maxLength);
	}
	
	
}
