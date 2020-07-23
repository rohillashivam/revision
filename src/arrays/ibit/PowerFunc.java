package arrays.ibit;

import java.math.BigInteger;

public class PowerFunc {

	public static void main(String[] args) {
		PowerFunc pf = new PowerFunc();
		System.out.println(pf.pow(71045970, 41535484, 64735492));
	}
	public int pow(int x, int n, int d) {
        if(x == 0)
            return 0;
        if(x == 1 || n == 0)
            return 1;
        BigInteger powVal = powerFunc(x, n);
        System.out.println("powVal :: "+ powVal);
        int powValData = powVal.intValue();
        if(powValData < 0) {
            return ((powValData % d) + d)%d;
        }
        return powValData % d;
    }
    
    private BigInteger powerFunc(int x, int n) {
    	if(n == 0)
            return BigInteger.ONE;
        if(n == 1)
            return new BigInteger(String.valueOf(x));
            
        int m = n/2;
        BigInteger powVal = powerFunc(x, m);
        powVal = powVal.multiply(powVal);
        
        if(n % 2 == 0) {
            return powVal;
        } else {
            return powVal.multiply(new BigInteger(String.valueOf(x)));
        }
    }
}
