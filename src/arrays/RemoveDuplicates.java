package arrays;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
		System.out.println(removeDuplicates(arr));
	}
	
	public static int removeDuplicates(int[] arr) {
		Set<Integer> dataSet = new HashSet<>();
        int count=0;
        for(Integer data : arr) {
            if(!dataSet.contains(data)) {
                count++;
                dataSet.add(data);
            }
        }
        //System.out.println("count :: "+count);
        return count;
	}
}
