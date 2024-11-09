package noUse;


//012358
public class Fibonacci {
	public static void main(String[] args) {

		int first=0;
		int second=1;
		int total=0;
		int number = 10;
		for (int i = 0; i < number; i++) {
			if(i==0)
				System.out.println(first);
			else if(i==1)
				System.out.println(first+" "+second);
			else{
				total=first+second;
				first=second;
				second=total;
				System.out.println(total);
			}
		}
	}
	
}
