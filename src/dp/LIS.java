package dp;

import java.util.HashMap;

public class LIS {

	private static HashMap<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		int arr[] = {7,1,2,4,21,9,31,10,15};
		System.out.println(lcs(arr, 0, Integer.MIN_VALUE));
		//System.out.println(lcsOptimized(arr, 0, Integer.MIN_VALUE));
		System.out.println("---------------WITH DP--------------");
		System.out.println(lcsDP(arr));
	}

	private static int lcsDP(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 1;
		int maxLength = -1;
		for(int i=1; i<arr.length; i++) {
			dp[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1); 
					maxLength = Math.max(maxLength, dp[i]);
				}
			}
		}
		
		return maxLength;
	}

	private static int lcsOptimized(int[] arr, int index, int lastMax) {
		if(index >= arr.length)
			return 0;
		String key = index+"|"+lastMax;
		if(arr[index] > lastMax) {
			if(!map.containsKey(key))
				map.put(key, 1 + lcs(arr, index+1,  arr[index]));
		}
		
		if(map.containsKey(key)) {
			//int value = 
		}
		return 0;
	}

	
	private static int lcs(int[] arr, int index, int lastMax) {
		if(index >= arr.length)
			return 0;
		
		if(arr[index] > lastMax)
		      return 1 + lcs(arr, index+1,  arr[index]);

		return Math.max(lcs(arr, index+1, lastMax), lcs(arr,index+1, arr[index]));
	}
	
	
}
