package testing;

import org.apache.commons.lang3.StringUtils;

public class Permutation {

	public static void main(String[] args) {
		/*String temp = "abcd";
		for (int i = 0; i < temp.length(); i++) {
			for (int j = 0; j < temp.length(); j++) {
						System.out.println(swap(temp,i,j));
			}
		}*/
		String prevVersion = "18.1.0";
		String currVersion = "18.1.1";
		if(prevVersion.length() > 5  && currVersion.length() > 5) {
			String[] prevToken = StringUtils.split(prevVersion, ".");
			String[] currToken = StringUtils.split(currVersion, ".");
			
			if(Integer.parseInt(currToken[0]) == Integer.parseInt(prevToken[0]))
				if(Integer.parseInt(currToken[1]) == Integer.parseInt(prevToken[1]))
					if(Integer.parseInt(currToken[2]) > Integer.parseInt(prevToken[2]))
						System.out.println("Patch");
		}
	}
 
	public static String swap(String temp, int i, int j)
	{
		char[] test = temp.toCharArray();
		char tempi;
		tempi = test[i];
		test[i] = test[j];
		test[j] = tempi;
		return new String(test);
	}
}
