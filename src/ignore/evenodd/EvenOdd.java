package ignore.evenodd;

public class EvenOdd extends Thread{
	Object lock;
	static boolean isEven;
	public EvenOdd(Object lock) {
		this.lock = lock;
	}
	@Override
	public void run() {
		int i = 0;
		while(i<10){
		if(Thread.currentThread().getName().equalsIgnoreCase("Even")){
				printEven(i);
		}else{
				printOdd(i);
		}
			i++;
		}
	}
	
	public void printEven(int i){
		synchronized (lock) {
		if(isEven){
				System.out.println("Current Even Thread" + Thread.currentThread().getName()+(i+1));
				isEven = false;
				lock.notifyAll();
			
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
		if(!isEven){
				System.out.println("Current Odd Thread" + Thread.currentThread().getName()+j);
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
