package arrays;

public class FindingDuplicateInArray {

	public static void main(String[] args) {
		FindingDuplicateInArray duplicate = new FindingDuplicateInArray(); 
        int arr[] = {1, 2, 3, 1, 3, 6, 6}; 
        int arrSize = arr.length; 
  
        duplicate.printRepeating(arr, arrSize);
	}

	private void printRepeating(int[] arr, int arrSize) {
		for(int i=0; i<arrSize; i++) {
			if(arr[i] >= 0 && arr[arr[i]] >= 0) {
				arr[arr[i]] = -arr[arr[i]];
			} else {
				System.out.println("duplicate found :: "+((-1)*arr[i]));
			}
		}
	}
}
