package ignore.producerConsumer;

public class EvenOdd implements Runnable{

	Object lock;
	static boolean curr = true;
	static int i =0;
	EvenOdd(Object lock){
		this.lock = lock;
	}
	@Override
	public void run() {
		
		while (i<10) {
		
			if(Thread.currentThread().getName().equalsIgnoreCase("Even"))
			{
				printEven(i);
				
			}
			else
			{
				printOdd(i);
			}
			
		}
	}

	public void printEven(int k){	
		synchronized (lock) {
		if(curr){
				System.out.println("Value of i"+i);
				System.out.println(k);
				curr = false;
				lock.notifyAll();
				i++;
			
		}else{
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
		if(!curr){
		System.out.println("Value of i"+i);
			System.out.println(j);
			curr = true;
			lock.notifyAll();
			i++;
		}
		else{
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
