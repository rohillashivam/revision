package arrays.ibit;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDuplicatesFromArr {

	public static void main(String[] args) {
		Integer[] arr = { 1, 1, 1, 2 };
		RemoveDuplicatesFromArr removeDuplicatesFromArr = new RemoveDuplicatesFromArr();
		ArrayList<Integer> arrList = (ArrayList<Integer>) Stream.of(arr).collect(Collectors.toList());
		System.out.println(removeDuplicatesFromArr.removeDuplicates(arrList));
		Integer[] arr1 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 3 };
		arrList = (ArrayList<Integer>) Stream.of(arr1).collect(Collectors.toList());
		System.out.println(removeDuplicatesFromArr.removeDuplicates(arrList));
		
		Integer[] arr2 = {1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010 };
		arrList = (ArrayList<Integer>) Stream.of(arr2).collect(Collectors.toList());
		System.out.println(removeDuplicatesFromArr.removeDuplicates(arrList));
		Integer[] arr3 = {1000, 1000, 1000, 1000, 1001, 1002, 1003, 1003, 1004, 1010 };
		arrList = (ArrayList<Integer>) Stream.of(arr3).collect(Collectors.toList());
		System.out.println(removeDuplicatesFromArr.removeDuplicatesNew(arrList));
	}
	
	public int removeDuplicatesNew(ArrayList<Integer> a) {
		//Here at most duplicates allowed is 2, can be scaled to N duplicates
	    int at_most = 2;
	    //Index pointer to new modified array.
	    int j = 0;
	    //Handle corner cases of size less than 2.
	    if(a.size() <=2)
	        return a.size();
	        
	    for(int i=0; i<a.size(); i++) {   
	        //Since corner cases are handled above, blindly add first two elements into same
	        //modified array.
	        //After filling first two elements check if the current element > 2 elements before the added array element.
	        if(j < at_most || a.get(i) > a.get(j-at_most)) {
	            a.set(j++,a.get(i));
	        }
	    }
	    int clearArr = a.size()-1;
	    while(j <= clearArr) {
	    	a.remove(clearArr);
	    	clearArr--;
	    }
	    
	    return j;
	}

	public int removeDuplicates(ArrayList<Integer> arr) {
		if (arr == null || arr.isEmpty())
			return 0;

		int i = 0, j = 1;
		while (i < arr.size() && j < arr.size()) {
			if (arr.get(i).equals(arr.get(j))) {
				while (j < arr.size() && arr.get(i).equals(arr.get(j))) {
					j++;
				}
				while (i < j && j - i > 2) {
					arr.remove(i);
					j--;
				}
				i = j;
				j++;
				continue;
			}
			i++;
			j++;
		}
		return arr.size();
	}
}
