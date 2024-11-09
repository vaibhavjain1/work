package ignore;

import java.util.Map;
import java.util.TreeMap;

public class Braces {

	public static void main(String[] args) {
		Map<String,String> temp = new TreeMap<>();
		temp.put(null, "dd");
		System.out.println(temp.get(null));
	}
}
