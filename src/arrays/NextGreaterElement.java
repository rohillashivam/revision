package arrays;

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int arr[] = { 5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9};
		printNGE(arr);
		System.out.println("==============");
		int arr1[] = { 11, 13, 21, 3 };
		printNGE(arr1);
	}

	private static void printNGE(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		stack.push(arr[0]);
		
		for(int i=1; i<arr.length; i++) {
			int nextElement = arr[i];
			
			if(!stack.isEmpty()) {
				int element = stack.pop();
				if(element < nextElement) {
					System.out.println(element+" --> "+nextElement);
					while(!stack.isEmpty()) {
						int currElement = stack.pop();
						if(currElement > nextElement) {
							stack.push(currElement);
							stack.push(nextElement);
							break;
						} else if (currElement < nextElement) {
							System.out.println(currElement+" --> "+nextElement);
						} 
					}
				} else {
					stack.push(element);
				}
				stack.push(nextElement);
			}
		}
		while(!stack.isEmpty()) {
			int element = stack.pop();
			System.out.println(element+" --> "+null);
		}
		
	}

}
