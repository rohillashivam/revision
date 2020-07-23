package arrays;

import java.util.Arrays;

public class SumClosestToZero {

	public static void main(String[] args) {
		int arr[] = { 1, 60, -10, 70, -80, 85 };
		findNumNearestToZero(arr.clone());
	}

	private static void findNumNearestToZero(int[] arr) {
		Arrays.sort(arr);
		int left = 0, right = arr.length - 1, minVal = Integer.MAX_VALUE, rightIndex = 0, leftIndex = 0;
		while (left < right) {
			int sum = arr[left] + arr[right];
			
			if (Math.abs(sum) < minVal) {
				minVal = Math.abs(sum);
				leftIndex = left;
				rightIndex = right;
			}
			
			if (sum < 0) {
				left++;
			} else if (sum == 0) {
				leftIndex = left;
				rightIndex = right;
				break;
			} else {
				right--;
			}

		}
		System.out.println("min sum :: " + minVal + " and elements :: " + arr[leftIndex] + " and " + arr[rightIndex]);
	}
}
