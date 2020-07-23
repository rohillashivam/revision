package arrays;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindowSizeK {

	public static void main(String[] args) {
		int[] array = { 9, 6, 11, 8, 10, 5, 14, 13, 93, 14 };
		int k = 4;

		System.out.println("Maximum elements from each sub-array of specified size are - ");
		printMaxfromEachSubarray(array, k);
	}

	private static void printMaxfromEachSubarray(int[] arr, int k) {
		if(arr == null)
			return;
		
		Deque<Integer> deque = new LinkedList<>();
		for(int i=0; i<k; i++) {
			updateDeque(arr, deque, i);
		}
		
		for(int i=k; i<arr.length; i++) {
			System.out.println(arr[deque.peekFirst()]);
			updateDequeForIndex(deque, i, k);
			updateDeque(arr, deque, i);
		}
		System.out.println(arr[deque.peekFirst()]);
		deque.clear();
	}


	private static void updateDequeForIndex(Deque<Integer> deque, int index, int k) {
		while(!deque.isEmpty() && deque.peekFirst() < (index - k)) {
			deque.removeFirst();
		}
	}

	private static void updateDeque(int[] arr, Deque<Integer> deque, int i) {
		while(!deque.isEmpty() && arr[i] > arr[deque.peekLast()]) {
			deque.removeLast();
		}
		deque.addLast(i);
	}
}
