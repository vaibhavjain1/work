package ignore;

class Even implements Runnable {
	Object lock;

	Even(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while (EvenOdd.i != 50) {

				if (EvenOdd.i % 2 == 0) {
					System.out.println(EvenOdd.i++);
					lock.notify();
				} else {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}
}

class Odd implements Runnable {
	Object lock;

	Odd(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while (EvenOdd.i != 50) {

				if (EvenOdd.i % 2 != 0) {
					System.out.println(EvenOdd.i++);
					lock.notify();
				} else {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}
}

public class EvenOdd {
	static int i = 0;

	public static void main(String[] args) {
		Object lock = new Object();
		Thread teven = new Thread(new Even(lock));
		Thread todd = new Thread(new Odd(lock));
		teven.start();
		todd.start();
	}
}
