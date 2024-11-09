package amazing;

import java.util.Stack;

public class Parenthisis {

	public static void main(String[] args) {

		String test = "ABC";
		permutation("", test);
	}
	
	private static void permutation(String prefix, String str) {
		System.out.println("output : "+prefix+" "+str);
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
}
