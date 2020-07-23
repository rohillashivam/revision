package arrays;

public class RainWaterTrapping {

	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(maxWater(arr));
		System.out.println("------------in O(1)--------");
		System.out.println(maxWaterOptimized(arr));
	}

	private static int maxWaterOptimized(int[] arr) {
		int low=0, high=arr.length-1;
		int leftHigh = Integer.MIN_VALUE;
		int rightHigh = Integer.MIN_VALUE;
		
		int water = 0;
		
		while(low <= high) {
			if(arr[low] < arr[high]) {
				if(leftHigh < arr[low])
					leftHigh = arr[low];
				else
					water += leftHigh - arr[low];
				
				low++;
			} else {
				if(rightHigh < arr[high])
					rightHigh = arr[high];
				else
					water += rightHigh - arr[high];
				high--;
			}
		}
		return water;
	}

	private static int maxWater(int[] arr) {
		int[] minRightHeight = new int[arr.length];
		int leftMinHeight = 0, minRight = 0;
		
		for(int i=arr.length - 1; i>=0 ; i--) {
			if(i == arr.length -1) {
				minRightHeight[i] = arr[i];
			}
			
			if(minRight < arr[i])
				minRight = arr[i];
			minRightHeight[i] = minRight;
		}
		
		int water = 0;
		for(int i=0; i<arr.length; i++) {
			if(leftMinHeight < arr[i]) {
				leftMinHeight = arr[i];
			} else {
				water += Math.max(Math.min(leftMinHeight, minRightHeight[i]) - arr[i], 0);
			}
		}
		return water;
	}

}
