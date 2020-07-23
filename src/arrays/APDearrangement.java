package arrays;

import java.util.Arrays;

public class APDearrangement {

	public static void main(String[] args) {
		int arr[] = {8, 6, 10, 4, 2};
		System.out.println(minDeArrangement(arr.clone()));
		System.out.println("------------------------------");
		System.out.println(minDeArrangementNew(arr));
	}

	private static int minDeArrangementNew(int[] arr) {
		int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > maxValue)
				maxValue = arr[i];
			if(arr[i] < minValue)
				minValue = arr[i];
		}
		int diff = maxValue / arr.length;
		
		int val = maxValue;
		int count = 0, dscCount = 0, ascCount = 0;
		while(val >= minValue && count < arr.length) {
			if((val - count*diff) != arr[count]) 
				dscCount++;
			count++;
		}
		val = minValue;
		count = arr.length -1;
		while(val <= maxValue && count >= 0) {
			if((val + count*diff) != arr[count])
				ascCount++;
			count--;
		}
		return Math.min(dscCount, ascCount);
	}

	private static int minDeArrangement(int[] arr) {
		int[] clonedArr = arr.clone();
		Arrays.sort(arr);
		
		int countAsc = 0;
		for(int i=0; i<arr.length; i++) {
			System.out.println("cloned Arr :: " + clonedArr[i]+"  amd arr[i] :: "+arr[i]);
			if(clonedArr[i] != arr[i])
				countAsc++;
		}
		System.out.println("-----------------------------");
		int countDsc = 0;
		for(int i=arr.length-1; i>=0 ; i--) {
			System.out.println("cloned Arr :: " + clonedArr[arr.length - i -1]+"  amd arr[i] :: "+arr[i]);
			if(clonedArr[arr.length - i -1] != arr[i])
				countDsc++;
		}
		return Math.min(countAsc, countDsc);
	}
}
