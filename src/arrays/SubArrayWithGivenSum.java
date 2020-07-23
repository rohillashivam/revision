package arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		int[] arr = { 1, 4, 20, 3, 10, 5 };
		findArrSum(arr, 33);

		arr = new int[] { 10, 2, -2, -20, 10 };
		findArrSum(arr, -10);

		arr = new int[] { -10, 0, 2, -2, -20, 10 };
		findArrSum(arr, 20);
	}

	private static void findArrSum(int[] arr, int sum) {
		Map<Integer, Integer> arraySumMap = new HashMap<>();
		int currSum = 0, startIndex = 0, endIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			currSum += arr[i];

			if (currSum - sum == 0) {
				endIndex = i;
				break;
			}

			if (arraySumMap.containsKey(currSum - sum)) {
				startIndex = arraySumMap.get(currSum - sum);
				startIndex++;
				endIndex = i;
				break;
			}
			arraySumMap.put(currSum, i);
		}
		if (endIndex != -1) {
			System.out.println("start index :: " + startIndex + " endIndex :: " + endIndex);
		} else {
			System.out.println("NOT FOUND");
		}
	}
}
