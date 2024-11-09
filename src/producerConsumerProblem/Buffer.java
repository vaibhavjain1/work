package producerConsumerProblem;

public class Buffer {

	static volatile int i;
	
	public synchronized void put(int j){
		if(i==10){
			try {
				System.out.println("Stack full waiting for buffer to empty");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			i++;
			notifyAll();
			System.out.println("Added to buffer. Value of i "+i);
		}
	}
	
	public synchronized void remove(){
		if(i==0){
			System.out.println("Stack empty waiting for buffer to have elements");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			i--;
			notifyAll();
			System.out.println("Removed from buffer. Value of i "+i);
		}
	}
}
