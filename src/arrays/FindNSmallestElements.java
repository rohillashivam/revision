package arrays;

import java.util.Arrays;

public class FindNSmallestElements {

	public static void main(String[] args) {
		int arr[] = { 1, 5, 8, 9, 6, 7, 3, 4, 2, 0 }; 
	    int k = 5; 
	    printSmall(arr, k); 
	}

	private static void printSmall(int[] arr, int k) {
		int[] arrCopy = Arrays.copyOf(arr, arr.length);
		Arrays.sort(arrCopy);
		
		for(int i=0; i<arr.length; i++) {
			if(Arrays.binarySearch(arrCopy, 0, k, arr[i]) > -1) {
				System.out.println(arr[i]);
			}
		}
	}
}
