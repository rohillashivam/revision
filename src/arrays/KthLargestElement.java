package arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElement {

	public static void main(String[] args) {
		int arr[] = { 12, 3, 5, 7, 4, 19, 26 };
		int k = 3;
		findKthLargestUsingMinHeap(arr, k);
		System.out.println("----------------------");
		int index = findKthLargestUsingQuickSelect(arr, 0, arr.length - 1, arr.length - k);
		System.out.println(arr[index-1]);
	}

	private static int findKthLargestUsingQuickSelect(int[] arr, int left, int right, int k) {
		if (k > 0 && k <= right - left + 1) {
			int pos = partition(arr, left, right);
			System.out.println("pos :: " + pos);
			if (pos - 1 == k - 1)
				return arr[pos];

			if (pos - 1 > k - 1)
				return findKthLargestUsingQuickSelect(arr, left, pos - 1, k);

			return findKthLargestUsingQuickSelect(arr, pos - 1, right, k - pos + left - 1);
		}

		return Integer.MAX_VALUE;
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[right], i = left;
		for (int j = left; j <= right - 1; j++) {
			if (arr[j] <= pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, right);
		return i;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void findKthLargestUsingMinHeap(int[] arr, int k) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++) {
			minHeap.add(arr[i]);
			rebalance(minHeap, k);
		}
		rebalance(minHeap, k);
		System.out.println(minHeap.poll());
	}

	private static void rebalance(Queue<Integer> minHeap, int k) {
		if (minHeap.size() > k)
			minHeap.poll();
	}
}
