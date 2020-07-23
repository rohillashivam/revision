package heaps;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class RunningMedian {

	public static void main(String[] args) {
		int[] arr = new int[]{5, 15, 10, 20, 3};
		printMedian(arr);
		printMedianNew(arr);
	}

	private static void printMedianNew(int[] arr) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int median[] = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			addNumberNew(arr[i], maxHeap, minHeap);
			rebalanceNew(maxHeap, minHeap);
			median[i] = findMedianNew(minHeap, maxHeap);
		}
		System.out.println("--------------------------");
		for (int i : median) {
			System.out.println("median :: "+i);
		}
	}

	private static int findMedianNew(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
		if(minHeap.size() == maxHeap.size())
			return maxHeap.peek() + minHeap.peek() >> 1;
		else
			return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
	}

	private static void rebalanceNew(Queue<Integer> maxHeap, Queue<Integer> minHeap) {
		if(minHeap.size() - maxHeap.size() > 1) {
			maxHeap.add(minHeap.poll());
			return;
		} 
		if(maxHeap.size() - minHeap.size() > 1){
			minHeap.add(maxHeap.poll());
		}
	}

	private static void addNumberNew(int data, Queue<Integer> maxHeap, Queue<Integer> minHeap) {
		if(minHeap.size() == 0 || data > minHeap.peek())
			minHeap.add(data);
		else
			maxHeap.add(data);
	}

	private static void printMedian(int[] arr) {
		Queue<Integer> maxHeap = new PriorityQueue<>((data2, data1) -> data1.compareTo(data2));
		Queue<Integer> minHeap = new PriorityQueue<>();
		int[] median = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			int val = arr[i];
			addNumber(maxHeap, minHeap, val);
			rebalance(maxHeap, minHeap);
			median[i] = findMedian(maxHeap, minHeap);
		}
		for (int i = 0; i < median.length; i++) {
			System.out.println(median[i]);
		}
	}

	private static int findMedian(Queue<Integer> maxHeap, Queue<Integer> minHeap) {
		if(maxHeap.size() == minHeap.size())
			return maxHeap.peek() + minHeap.peek() >> 1;
		else if(maxHeap.size() > minHeap.size())
			return maxHeap.peek();
		else
			return minHeap.peek();
	}

	private static void rebalance(Queue<Integer> maxHeap, Queue<Integer> minHeap) {
		if(maxHeap.size() - minHeap.size() > 1) {
			minHeap.add(maxHeap.poll());
			return;
		}
		if(minHeap.size() - maxHeap.size() > 1) 
			maxHeap.add(minHeap.poll());
	}

	private static void addNumber(Queue<Integer> maxHeap, Queue<Integer> minHeap, int val) {
		if(minHeap.size() == 0 || val > minHeap.peek())
			minHeap.add(val);
		else
			maxHeap.add(val);
	}

}
