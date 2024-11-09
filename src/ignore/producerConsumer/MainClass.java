package ignore.producerConsumer;

public class MainClass {

	public static void main(String[] args) {
		Object lock =  new Object();
		EvenOdd evenObj = new EvenOdd(lock);
		EvenOdd oddObj = new EvenOdd(lock);
		Thread even = new Thread(evenObj,"Even");
		Thread odd = new Thread(oddObj,"Odd");
		even.start();
		odd.start();
	}
}
