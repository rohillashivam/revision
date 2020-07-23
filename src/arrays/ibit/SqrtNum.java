package arrays.ibit;

public class SqrtNum {
	
	public static void main(String[] args) {
		SqrtNum sqrtNum = new SqrtNum();
		int sqrt = sqrtNum.sqrt(11);
		System.out.println(sqrt);
		System.out.println(sqrtNum.sqrt(9));
		System.out.println(sqrtNum.sqrt(2147483647));
		System.out.println(sqrtNum.sqrt(6));
	}

	public int sqrt(int num) {
        if(num == 1)
            return num;
        Long start = 0l;
        Long end = new Long(num);
        Long mid = -1l;
        boolean found = false;
        while(end >= start) {
        	mid = (start + end) >> 1;
        	if(mid*mid == num) {
        		found = true;
        		break;
        	}
        	if(mid*mid > num) {
        		end = mid-1;
        	} else {
        		start = mid+1;
        	}
        }
        if(!found) {
        	if((mid+1)*(mid+1) < num) {
        		mid++;
        		return mid.intValue();
        	} else if(mid*mid < num) {
        		return mid.intValue();
        	} else if((mid-1)*(mid-1) < num) {
        		mid--;
        		return mid.intValue();
        	} else {
        		return mid.intValue();
        	}
        }
        return mid.intValue();
    }
}
