package arrays.ibit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		
	}
	
	public ArrayList<Integer> twoSum(final List<Integer> arr, int target) {
        ArrayList<Integer> returnList = new ArrayList<>();
        if(arr == null || arr.isEmpty())
            return returnList;
        Map<Integer, Integer> mapSum = new HashMap<>();
        
        for(int i=0; i<arr.size(); i++) {
            if(mapSum.containsKey(target - arr.get(i))) {
                returnList.add(mapSum.get(target - arr.get(i)));
                returnList.add(i+1);
                return returnList;
            }
            if(!mapSum.containsKey(arr.get(i)))
                mapSum.put(arr.get(i), i+1);
        }
        
        return returnList;
    }
}
