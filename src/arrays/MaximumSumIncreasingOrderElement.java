package arrays;

public class MaximumSumIncreasingOrderElement {

	public static void main(String[] args) {
		int arr[][] = { { 1, 7, 3, 4 }, { 4, 2, 5, 1 }, { 9, 5, 1, 8 } };
		System.out.println(maximumIncreasingSum(arr));
		int arr1[][] = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
		System.out.println(maximumIncreasingSum(arr1));
	}

	private static int maximumIncreasingSum(int[][] arr) {
		int sum = 0;
		Integer lastMax = Integer.MIN_VALUE;
		int i = arr.length - 1, j = 0;
		for (; j < arr[0].length; j++)
			lastMax = Math.max(arr[i][j], lastMax);
		sum += lastMax;
		for (i = arr.length - 2; i >= 0; i--) {
			int max = Integer.MIN_VALUE;
			for (j = 0; j < arr[0].length; j++) {
				if (arr[i][j] > max && arr[i][j] < lastMax)
					max = arr[i][j];
			}
			if(max == Integer.MIN_VALUE)
				return 0;
			lastMax = max;
			sum += lastMax;
		}
		return sum;
	}
}
