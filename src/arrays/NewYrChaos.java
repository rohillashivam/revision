package arrays;

public class NewYrChaos {

	static void minimumBribes(int[] arr) {
		int i = 0, count = 0;
		int[] newArr = new int[arr.length];
		for (; i < arr.length; i++) {
			newArr[i] = i + 1;
		}
		boolean chaotic = false;
		int length = arr.length;
		
		for(i=length - 1; i>=0; i--) {
			if(arr[i] - (i+1) > 2) {
				chaotic = true;
				break;
			} else {
				for(int j=Math.max(0, arr[i] - 2); j < i; j++) {
					if(arr[j] > arr[i])
						count++;
				}
			}
		}
		
		if (chaotic) {
			System.out.println("Too chaotic");
		} else {
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {2, 1, 5, 3, 4};
		minimumBribes(arr);
		
		int arr1[] = {1, 2, 5, 3, 7, 8, 6, 4};
		minimumBribes(arr1);
	}
}
