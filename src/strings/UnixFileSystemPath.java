package strings;

import java.util.Stack;

public class UnixFileSystemPath {

	public static void main(String[] args) {
		
	}
	
	public String simplifyPath(String path) {
        if(path == null || path.isEmpty())
            return path;
            
        Stack<String> stackPath = new Stack<>();
        int i=0;
        while(i<path.length()) {
        	if(i+1 < path.length() && path.charAt(i+1) == '.') {
        		if(i+2 < path.length() && path.charAt(i+2) == '.') {
        			if(!stackPath.isEmpty()) {
        				stackPath.pop();
        			}
        			i += 3;
        		} else
        			i += 2;
        		continue;
        	}
        	i++;
        	StringBuilder sb = new StringBuilder('/');
        	while(i < path.length() && path.charAt(i) != '/') {
        		sb.append(path.charAt(i));
        		i++;
        	}
        	stackPath.push(sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        Stack<String> stackStr = new Stack<>();
        while(!stackPath.isEmpty()) {
            String str = stackPath.pop();
            stackStr.push(str);
        }
		while (!stackStr.isEmpty()) {
			String str = stackStr.pop();
			if (str.isEmpty())
				continue;
			if (flag)
				sb.append('/');
			sb.append(str);
			if (flag && stackStr.isEmpty())
				flag = false;
		}
        if(sb.length() == 0)
            sb.append('/');
        return sb.toString();
    }
}
