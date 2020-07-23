package arrays.ibit;

import java.util.List;

public class MedianOfTwoArr {

	public static void main(String[] args) {
		int[] a = {-50, -41, -40, -19, 5, 21, 28};
		int[] b = {-50, -21, -10};
		System.out.println(findMedianSortedArrays(a, b));
	}
	
	public static double findMedianSortedArrays(int[] a, int[] b) {

        if((a == null || a.length == 0) && (b == null && b.length == 0))
            return 0d;
        
        if((a == null || a.length == 0) && (b != null && a.length != 0)) {
            return b[(0+b.length-1) >> 1];
        }
        
        if((a != null && a.length != 0) && (b == null && b.length == 0)) {
            return a[(0+a.length-1) >> 1];
        }
        int startA = 0, endA = a.length-1;
        int startB = 0, endB = b.length-1;
        while(true) {
            System.out.println("startA :: "+startA+" startB :: "+startB+" -- endA :: "+endA+" endB :: "+endB);
            int partitionA = (startA + endA) >> 1;
            int partitionB = (startB + endB) >> 1;
            
            if((endA - startA <= 1) && (endB - startB <= 1)) 
                break;
                
            int medianA = a[partitionA];
            int medianB = b[partitionB];
            
            if(medianA == medianB) {
                return medianB;
            }
            
            if(medianA < medianB) {
                startA = partitionA;
                endB = partitionB;
            }
            if(medianB < medianA) {
                startB = partitionB;
                endA = partitionA;
            }
            
        }
        return (Math.max(startA, startB) + Math.min(endA, endB))/2;
    
	}
	public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if((a == null || a.isEmpty()) && (b == null && b.isEmpty()))
            return 0d;
        
        if((a == null || a.isEmpty()) && (b != null && !b.isEmpty())) {
            return b.get((0+b.size()-1) >> 1);
        }
        
        if((a != null && !a.isEmpty()) || (b == null && b.isEmpty())) {
            return a.get((0+a.size()-1) >> 1);
        }
        int startA = 0, endA = a.size()-1;
        int startB = 0, endB = b.size()-1;
        while(true) {
            System.out.println("startA :: "+startA+" startB :: "+startB+" -- endA :: "+endA+" endB :: "+endB);
            int partitionA = (startA + endA) >> 1;
            int partitionB = (startB + endB) >> 1;
            
            if((endA - startA == 1) && (endB - startB == 1)) 
                break;
                
            int medianA = a.get(partitionA);
            int medianB = b.get(partitionB);
            
            if(medianA == medianB) {
                return medianB;
            }
            
            if(medianA < medianB) {
                startA = partitionA;
                endB = partitionB;
            }
            if(medianB < medianA) {
                startB = partitionB;
                endA = partitionA;
            }
            
        }
        return (Math.max(startA, startB) + Math.min(endA, endB))/2;
    }
}
