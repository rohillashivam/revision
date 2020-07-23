package arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinIncreDecreArrNonIncreasing {

	public static void main(String[] args) {
		int[] arr = {3, 1, 5, 1};
		System.out.println(decreasingArr(arr));
		int[] arr1 = {3, 1, 2, 1};
		System.out.println(decreasingArr(arr1));
		int[] arr2 = {1, 5, 5, 5};
		System.out.println(decreasingArr(arr2));
	}

	private static int decreasingArr(int[] arr) {
		int sum = 0;
		if(arr == null || arr.length == 0)
			return sum;
		
		Queue<Integer> minHeap = new PriorityQueue<>();
		for(int i=0; i<arr.length; i++) {
			if(!minHeap.isEmpty() && arr[i] > minHeap.peek()) {
				int diff = arr[i] - minHeap.peek();
				sum += diff;
				minHeap.poll();
			}
			minHeap.add(arr[i]);
		}
		return sum;
	}
}
