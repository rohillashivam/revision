package stackqueue.ctci;

import java.util.ArrayList;
import java.util.List;

public class StackOfPlates {

	public static void main(String[] args) {
		MultiStack<Integer> multiStack = new MultiStack<>();
		for(int i=1; i<=17; i++) {
			multiStack.push(i);
		}
		for(int i=0; i<4; i++)
			System.out.println(multiStack.pop());
	}
	
}

 class MultiStack<Type> {
	private List<Type> typeListStack = null;
	private List<List<Type>> typeListStackList = null;
	private static final Integer threshold = 5;
	
	public MultiStack() {
		super();
		typeListStack = new ArrayList<>(threshold);
		typeListStackList = new ArrayList<List<Type>>();
	}
	
	public void push(Type type) {
		if(type == null)
			return;
		if(typeListStack == null)
			typeListStack = new ArrayList<>();
		if(typeListStack.size() == threshold) {
			List<Type> copyList = new ArrayList<>(typeListStack);
			typeListStack.clear();
			typeListStackList.add(copyList);
		}
		typeListStack.add(type);
	}
	public Type pop() {
		if(typeListStack.size() == 0) {
			if(typeListStackList.size() == 0)
				return null;
			
			typeListStack = typeListStackList.get(typeListStackList.size() - 1);
			typeListStackList.remove(typeListStackList.size() - 1);
		}
		return typeListStack.remove(typeListStack.size() - 1);
	}
	
	/*public Type indexAt(int index) {
		if(index < 0)
			return null;
		
		if(index >= 0 && index < threshold) {
			int stackListIndex = index / threshold;
			int indexNum = index % threshold;
			
			if(stackListIndex > typeListStackList.size()) {
				return null;
			}
			
		}
		
	}*/
}
