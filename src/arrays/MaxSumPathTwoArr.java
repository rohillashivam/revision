package arrays;

public class MaxSumPathTwoArr {

	public static void main(String[] args) {
		int[] arr= {2, 3, 7, 10, 12, 15, 30, 34};
		int[] arr2 = {1, 5, 7, 8, 10, 15, 16, 19};
		maxSumPath(arr, arr2);
	}

	private static void maxSumPath(int[] arr, int[] arr2) {
		int i=0, j=0, sum1=0, sum2=0;
		Integer maxSum = Integer.MIN_VALUE;
		while(i < arr.length && j < arr2.length) {
			if(i < arr.length && j < arr2.length && arr[i] < arr2[j]) {
				sum1 += arr[i];
				i++;
			} else if(i < arr.length && j < arr2.length && arr[i] > arr2[j]) {
				sum2 += arr2[j];
				j++;
			} else {
				if(i < arr.length) {
					sum1 += arr[i];
					i++;
				}
				if(j < arr.length) {
					sum2 += arr2[j];
					j++;
				}
				//if((i < arr.length && j < arr2.length && arr[i-1] == arr2[j-1])) {
					maxSum = Math.max(maxSum, Math.max(sum1, sum2));
					sum1 = maxSum;
					sum2 = maxSum;
				/*} else {
					if(i == arr.length && j == arr2.length) {
						maxSum = Math.max(maxSum, Math.max(sum1, sum2));
					}
				}*/
			}
		}
		
		while(i < arr.length) {
			sum1 += arr[i];
			i++;
		}
		
		while(j < arr2.length) {
			sum2 += arr2[j];
			j++;
		}
		
		maxSum = Math.max(maxSum, Math.max(sum1, sum2));
		
		System.out.println("max sum :: "+maxSum);
	}
}
