package ignore.evenodd;

public class Demo {

	public static void main(String[] args) {
		Object lock = new Object();
		
		Thread Eventhread = new Thread(new EvenOdd(lock),"Even");
		Thread Oddthread = new Thread(new EvenOdd(lock),"Odd");
		Oddthread.start();
		Eventhread.start();
		
	}
}
