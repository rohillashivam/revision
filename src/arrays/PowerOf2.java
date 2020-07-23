package arrays;

public class PowerOf2 {
	
	public static void main(String[] args) {
		PowerOf2 po2 = new PowerOf2();
		System.out.println(po2.power("1"));
		System.out.println(po2.power("5070602400912917605986812821504"));
	}

	public int power(String str) {
        if(str == null || str.isEmpty())
            return 0;
        if(str.equals("1"))
        	return 0;
        return isPowerOfTwoNew(Double.parseDouble(str)) ? 1 : 0;
    }
	
	private boolean isPowerOfTwoNew(Double num) {
        while(num % 2 == 0) {
            num = num/2;
        }
        
        if(num.compareTo(1d) != 0) 
            return false;
        return true;
    }
    
    private boolean isPowerOfTwo(Double num) {
        Double nume = Math.log(num);
        Double den = Math.log(2);
        Double val = nume/den;
        int numInt = val.intValue();
        double decimal = val.doubleValue() - numInt;
        if(decimal > 0f)
            return false;
            
        return true;
    }
}
