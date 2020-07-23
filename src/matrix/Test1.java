package matrix;

import java.util.Properties;

public class Test1 {

	public static void main(String[] args) {
		Properties prop = System.getProperties();
		prop.setProperty("pirate", "scurvy");
		String s = prop.getProperty("argProp")+" ";
		s += prop.getProperty("pirate");
		System.out.println(s);
	}
}
