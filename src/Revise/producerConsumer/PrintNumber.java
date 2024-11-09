package Revise.producerConsumer;

public class PrintNumber implements Runnable {
	Object lock;
	static boolean isEven = true;
	public PrintNumber(Object newLock) {
		lock = newLock;
	}
	@Override
	public void run() {
		
		if(Thread.currentThread().getName().equalsIgnoreCase("even")){
			for (int i = 0; i < 5; i++) {
				System.out.println("Printing even with i = "+i);
				printEven(i);
			}
		}
		if(Thread.currentThread().getName().equalsIgnoreCase("odd")){
			for (int j = 0; j < 5; j++) {
				System.out.println("Printing Odd with j = "+j);
				printOdd(j);
			}
		}
		
		
	}
	
	public void printEven(int i){
			synchronized (lock) {
				if(isEven){
				System.out.println("Even: thread"+i);
				isEven = false;
				lock.notifyAll();
				} else{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		
	}
	
	public void printOdd(int j){

			synchronized (lock) {
				if(!isEven){
				System.out.println("Odd: thread"+j);
				isEven = true;
				lock.notifyAll();
				} else{
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
