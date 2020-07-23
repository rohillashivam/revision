package arrays;

public class TrailingZeros {

	public static void main(String[] args) {
		System.out.println(trailingZeroes(15));
	}
	public static int trailingZeroes(int num) {
        int trailZero = 0;
        for(int i=5; num/i>=1; i*=5) {
            trailZero += num/i;
        }
        
        return trailZero;
    }
}
