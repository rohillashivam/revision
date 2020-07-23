package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {

	public static void main(String[] args) {
		int[] coins = {1, 2, 3};
		System.out.println(ways(4, coins));
		int coins1[] = {2, 5, 3, 6};
		System.out.println(ways(10, coins1));
	}
	
	static int ways(int n, int[] coins) {
		indexSumMap.clear();
		Arrays.sort(coins);
		//return ways(n, coins, 0);
		return waysNew(n, coins);
    }
	
	private static int waysNew(int sum, int[] coins) {
		int[] table = new int[sum+1];
		table[0]=1;
		
		for(int i=0; i<coins.length; i++) {
			for(int j=coins[i]; j<= sum; j++) {
				table[j] = table[j] + table[j-coins[i]];
			}
		}
		return table[sum];
	}

	static Map<String, Integer> indexSumMap = new HashMap<>();

    static int ways(int sum, int[] coins, int index) {
    	if(sum == 0)
    		return 1;
    	if(sum > 0 && index == coins.length)
    		return 0;
    	if(sum - coins[index] < 0)
    		return 0;
    	
    	int include = -1;
    	if(indexSumMap.containsKey((sum-coins[index])+"|"+index))
    		include = indexSumMap.get((sum-coins[index])+"|"+index);
    	else
    		include = ways(sum-coins[index], coins, index);
    	
    	int exclude = -1;
    	if(indexSumMap.containsKey((sum)+"|"+(index+1)))
    		exclude = indexSumMap.get((sum)+"|"+(index+1));
    	else
    		exclude = ways(sum, coins, index+1);
    	
    	return include + exclude;
    }
}
