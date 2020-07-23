package dp;

import java.util.ArrayList;
import java.util.List;

public class PerfectSumProblem {

	public static void main(String[] args) {
		int[] arr = {2, 3, 5, 6, 8, 10};
		List<Integer> dataList = new ArrayList<>();
		printPerfectSum(arr, 10, dataList, 0);
	}

	private static void printPerfectSum(int[] arr, int sum, List<Integer> dataList, int index) {
		if(index == arr.length)
			return;
		
		if(sum - arr[index] < 0) {
			printPerfectSum(arr, sum, dataList, index+1);
			return;
		}
		
		// include in sum
		if(sum == arr[index]) {
			dataList.add(arr[index]);
			printList(dataList);
			dataList.remove(dataList.size()-1);
			return;
		}
		
		dataList.add(arr[index]);
		printPerfectSum(arr, sum - arr[index], dataList, index+1);
		dataList.remove(dataList.size()-1);
		// exclude
		printPerfectSum(arr, sum, dataList, index+1);
	}

	private static void printList(List<Integer> dataList) {
		for (Integer data : dataList) {
			System.out.print(data+" ");
		}
		System.out.println();
	}
}
