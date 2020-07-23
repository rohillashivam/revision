package matrix;

// TODO
public class ShortestPathScreen {

	public static void main(String[] args) {
		String str = "GEEK";
		printPath(str);
	}

	private static void printPath(String str) {
		if(str == null ||  str.isEmpty())
			return;
		str = str.toLowerCase();
		int currRow=0, currCol=0;
		for(int i=0; i<str.length(); i++) {
			int currentDist = 5*currRow + currCol;
			//char currChar = currentDist - 'a' +1;
			
				
		}
	}
	
	
}
