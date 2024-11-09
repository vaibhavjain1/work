package ignore;

public class SpecialNum {

	public static void main(String[] args) {
		for (int i = 1; i < 10000; i++) {
			if(i%2==1&&i%3==1&&i%4==1&&i%5==1&i%6==1&i%7==0)
				System.out.println(i);
		}
	}
}
