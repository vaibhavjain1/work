package interview;


public class Letsee {

	class temp{
		int a = 5;
	}
	public static void abc(Integer a){
		a+=5;
	}
	public static void def(temp a){
		a.a+= 5;
	}
	public static void main(String[] args) {
		Integer a = new Integer(5);
		temp b = new Letsee(). new temp();
		System.out.println(b.a);
		abc(a);
		def(b);
		System.out.println(a);
		System.out.println(b.a);
	}
}
