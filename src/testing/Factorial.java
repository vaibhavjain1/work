package testing;

public class Factorial {

	public static void main(String[] args) {
		String test = "tesi";
		int val = 5;
		fact(test, 0);
	}
	
	public static void fact(String test, int n) {
		char[] mytest = test.toCharArray();
		for (int i = n; i < mytest.length; i++) {
			
			System.out.println(String.copyValueOf(mytest));
		}
		if(mytest.length>n)
			fact(test, n+1);
	}
}
