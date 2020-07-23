package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		 // 3, 30, 34, 5, 9
		intList.add(3);
		intList.add(30);
		intList.add(34);
		intList.add(5);
		intList.add(9);
		LargestNumber ln = new LargestNumber();
		System.out.println(ln.largestNumber(intList));
	}
	
	public String largestNumber(final List<Integer> arr) {
        if(arr == null || arr.isEmpty()) {
            return "";
        }
        Collections.sort(arr, (obj1, obj2) -> {
            String obj1Str = String.valueOf(obj1);
            String obj2Str = String.valueOf(obj2);
            
            String c1Str = obj1Str + obj2Str;
            String c2Str = obj2Str + obj1Str;
            
            Long c1StrL = Long.parseLong(c1Str);
            Long c2StrL = Long.parseLong(c2Str);
            System.out.println("for "+c2StrL+" and "+c1StrL+" compare result :: "+(c2StrL.compareTo(c1StrL)));
            return c2StrL.compareTo(c1StrL);
        });
        
        String str = "";
        for(Integer data : arr) {
            str += data;
        }
        if(str.startsWith("0"))
            return "0";
        return str;
    }
}
