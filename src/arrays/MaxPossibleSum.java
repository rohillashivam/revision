package arrays;

public class MaxPossibleSum {

	public static void main(String[] args) {
		int[] arr = {5, 5, 10, 100, 10, 5};
		System.out.println(findMaxPossibleSumRec(arr, 0));
		System.out.println(findMaxPossibleSumDP(arr));
	}

	private static int findMaxPossibleSumDP(int[] arr) {
		
		return 0;
	}

	private static int findMaxPossibleSumRec(int[] arr, int index) {
		if(index >= arr.length)
			return 0;
		
		return Math.max(arr[index] + findMaxPossibleSumRec(arr, index + 2),
				findMaxPossibleSumRec(arr, index + 1));
	}
	
	
}
