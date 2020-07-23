package arrays;

public class MaxProductSubArr {

	public static void main(String[] args) {
		int arr[] = {0, -10, 0, 10};
		System.out.println(maxProduct(arr));
		
		int arrNew[] = {1, 2, 3, -10, 1, 45};
		System.out.println(maxProduct(arrNew));
	}

	private static int maxProduct(int[] arr) {
		int minProduct = arr[0];
		int maxProduct = arr[0];
		int maxValue = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] < 0) {
				int temp = minProduct;
				minProduct = maxProduct;
				maxProduct = temp;
			}
			
			maxProduct = Math.max(arr[i], maxProduct*arr[i]);
			minProduct = Math.min(arr[i], minProduct*arr[i]);
			
			maxValue = Math.max(maxProduct, maxValue);
		}
		
		return maxValue;
	}
}
