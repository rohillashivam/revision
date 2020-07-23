package arrays.ibit;

public class PalindromCheck {
	
	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		System.out.println(new PalindromCheck().isPalindrome(str));
		System.out.println(new PalindromCheck().isPalindrome("race a car"));
	}

	public int isPalindrome(String str) {
        if(str == null || str.isEmpty())
            return 0;
            
        str = str.toLowerCase();
        str = removeGarbage(str);
        System.out.println("str :; "+ str);
        return isPalindrom(str);
    }
    
    private int isPalindrom(String str) {
        for(int i=0, j=str.length()-1; j>=i; i++, j--) {
            if(str.charAt(i) != str.charAt(j))
                return 0;
        }
        return 1;
    }
    
    private String removeGarbage(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            if((str.charAt(i) < 'a' || str.charAt(i) > 'z') && (str.charAt(i) <= '1'
                    || str.charAt(i) >='9'))
                continue;
            sb.append(str.charAt(i));
        }
        String st = sb.toString();
        System.out.println("st :: "+st);
        return st;
    }
}
