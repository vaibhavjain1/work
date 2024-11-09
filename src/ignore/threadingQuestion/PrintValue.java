package ignore.threadingQuestion;

public class PrintValue implements Runnable {

	Object lock;
	
	char[] array = {'a','b','c','d','e','f','g','h','i'};
	static volatile int i = 0;
	public PrintValue(Object lock){
		this.lock = lock;
	}
	
	@Override
	public void run() {
		while(i<array.length){
			if(Thread.currentThread().getName().equals("Even")){
				PrintEven();
			}else{
				PrintOdd();
			}
		}
	}

	public void PrintEven(){
		synchronized (lock) {
			if(i%2==0){
				System.out.println(Thread.currentThread().getName() +" " + array[i]);
				i++;
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
	
	public void PrintOdd(){
		synchronized (lock) {
			if(i%2!=0){
				System.out.println(Thread.currentThread().getName() +" " + array[i]);
				i++;
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
	
}
