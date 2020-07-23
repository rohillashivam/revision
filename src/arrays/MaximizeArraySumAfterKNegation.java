package arrays;

import java.util.Arrays;

public class MaximizeArraySumAfterKNegation {

	public static void main(String[] args) {
		int arr[] = { -2, 0, 5, -1, 2 };
		int k = 4;
		System.out.println(maximizeArraySum(arr, k));
	}

	/**
	 * 1. sort the array 
	 * 2. if index 0 found than set k = 0;
	 * 3. negate the index from start till k becomes 0
	 * 
	 */
	private static int maximizeArraySum(int[] arr, int k) {
		Arrays.sort(arr);
		int index = 0, sum=0;
		while(k > 0) {
			if(arr[index] ==0 )
				k=0;
			else
				arr[index] = -arr[index];
			k--;
			index++;
		}
		for(int i=0; i<arr.length; i++)
			sum += arr[i];
		
		return sum;
	}
}
