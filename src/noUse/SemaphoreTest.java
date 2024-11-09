package noUse;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		Semaphore sema = new Semaphore(1);
		Thread teven = new Thread(new PrintOddEven(sema),"even");
		Thread todd = new Thread(new PrintOddEven(sema), "odd");
		teven.start();
		todd.start();
	}
}

class PrintOddEven implements Runnable{

	Semaphore lock;
	static boolean isEven = true;
	PrintOddEven(Semaphore lock){
		this.lock = lock;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 50; i++) {
			if(Thread.currentThread().getName().equalsIgnoreCase("even"))
				this.printEven(i);
			else
				this.printOdd(i);
		}
	}
	
	public void printEven(int i){
		try {
			System.out.println("Inside printeven: "+i);
			lock.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			if(isEven){
				System.out.println("Even: "+i);
				isEven = false;
			}
			
		lock.release();
	}
	
	public void printOdd(int i){
		try {
			System.out.println("Print odd: "+i);
			lock.acquire();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			if(!isEven){
				System.out.println("Odd: "+i);
				isEven = true;
			}
			
		lock.release();
	}
}
