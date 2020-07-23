package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllSubSequencesOfArray {

	public static void main(String[] args) {
		Integer[] arr = {2, 3, 5, 9};
		List<Integer> arrList = Stream.of(arr).collect(Collectors.toList());
		int k=3;
		List<List<Integer>> allSubSequences = findAllSubSequences(arrList, k);
		
		Map<Character, Character> cMap = new HashMap<>();
		
	}

	private static List<List<Integer>> findAllSubSequences(List<Integer> arrList, int k) {
		String str = "ac";
		Set<Integer> dataList = new HashSet<>(k);
		findAllSubSequencesUtils(arrList, k, 0, dataList);
		return null;
	}

	private static List<Set<Integer>> subSeqList = new ArrayList<>();
	private static void findAllSubSequencesUtils(List<Integer> arrList, int k, int index, Set<Integer> dataList) {
		if(arrList.size() == index) {
			if(dataList.size() == k)
				addSet(dataList);
			return;
		}
		if(dataList.size() == k) {
			addSet(dataList);
			//dataList.clear();
			return;
		}
		
		// include case
		dataList.add(arrList.get(index));
		findAllSubSequencesUtils(arrList, k, index+1, dataList);
		
		// exclude case
		dataList.remove(arrList.get(index));
		findAllSubSequencesUtils(arrList, k, index+1, dataList);
		
	}

	private static void addSet(Set<Integer> dataList) {
		subSeqList.add(new HashSet(dataList));
	}
	
	public void printAllSubSequences(int [] arrInput){
		int [] temp = new int[arrInput.length];
		int index = 0;
		        solve(arrInput, index, temp);
		    }
		private void solve(int [] arrInput, int index, int [] temp){
		if(index==arrInput.length){
		            print(arrInput,temp);
		return;
		        }
		//set the current index bit and solve it recursively
		        temp[index] = 1;
		        solve(arrInput,index+1,temp);
		//unset the current index bit and solve it recursively
		        temp[index] = 0;
		        solve(arrInput,index+1,temp);
		    }
		private void print(int [] arrInput, int [] temp){
		String result = "";
		for (int i = 0; i <temp.length ; i++) {
		if(temp[i]==1)
		                result += arrInput[i]+" ";
		        }
		if(result=="")
		            result = "{Empty Set}";
		System.out.println(result);
		    }
		/*public static void main(String[] args) {
		int [] arrInput = {1, 2, 3};
		new PrintArraySubSequences().printAllSubSequences(arrInput);
	 }*/
	
	
}
