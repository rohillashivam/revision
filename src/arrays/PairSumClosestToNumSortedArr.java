package arrays;

public class PairSumClosestToNumSortedArr {

	public static void main(String[] args) {
		int[] arr = {10, 22, 28, 29, 30, 40};
		System.out.println(findNearestPairSum(arr, 54));
		int[] arrNew = {1, 3, 4, 7, 10};
		System.out.println(findNearestPairSum(arrNew, 15));
	}

	private static int findNearestPairSum(int[] arr, int sum) {
		if(arr == null || arr.length == 0)
			return 0;
		int i=0, j=arr.length-1;
		Integer nearestSum = Integer.MAX_VALUE;
		int nearestSumIndex1 = -1, nearestSumIndex2 = -1;
		while(i <arr.length && j>=0 && j > i) {
			int val = sum - (arr[i]+arr[j]);
			if(Math.abs(val) < Math.abs(sum -nearestSum)) {
				nearestSum = arr[i]+arr[j];
				nearestSumIndex1 = i;
				nearestSumIndex2 = j;
			}
			if((arr[i]+arr[j]) < sum) {
				i++;
			} else {
				j--;
			}
		}
		System.out.println("nearest sum val :: "+arr[nearestSumIndex1]+" , "+arr[nearestSumIndex2]);
		return nearestSum;
	}
}
