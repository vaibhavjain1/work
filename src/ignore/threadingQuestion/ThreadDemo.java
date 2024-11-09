package ignore.threadingQuestion;

public class ThreadDemo {

	public static void main(String[] args) {
		Object lock = new Object();
		PrintValue even = new PrintValue(lock);
		PrintValue odd = new PrintValue(lock);
		Thread t1 = new Thread(even,"Even");
		Thread t2 = new Thread(odd,"Odd");
		t1.start();
		t2.start();
	}
}
