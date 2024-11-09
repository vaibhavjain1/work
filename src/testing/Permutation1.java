package testing;

public class Permutation1 {

/*
	 				A|B|C
	 			/	  |    \
	 		/		  |			\
	 	/     		  |     		\
	 A|B|C			B|A|C		  C|A|B
	 /	\			/	\		  /	  \
A|B|C	A|C|B	B|A|C	B|C|A   C|A|B C|B|A 
	 
*/
	
	public static void main(String[] args) {
		char[] mytest = "abc".toCharArray();
		permu(mytest, 0,mytest.length-1);
	}
	
	public static void permu(char[] mytest, int m, int n) {
		if(m==n) // return if reached end
			return;
		for (int i = m; i <=n ; i++) {
			swap(mytest, i, m);
			if(m+1==n) // Print only leaf node.Check if it's last iteration
				System.out.println(String.copyValueOf(mytest));
			permu(mytest, m+1, n);
			swap(mytest, m, i); //swap back
		}
	}
	
	public static void swap(char[] mytest, int i, int m) {
		char temp = mytest[m];
		mytest[m] = mytest[i];
		mytest[i] = temp;
	}
}
