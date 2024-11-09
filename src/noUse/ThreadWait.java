package noUse;


public class ThreadWait extends Thread {
	int amount = 10000;	
	public synchronized void deposit(int sum) {
		this.amount +=sum;
		System.out.println("amount deposited");
		//notify();
		notifyAll();
	}
	
	public synchronized void retrieve(int sum){

		System.out.println("Going to deduct amount");
		if(sum>amount){
			try {
				System.out.println("Less amount , waiting for more amount");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
			this.amount =  amount - sum;
			System.out.println("final balance "+amount);
		
	}
	
	public static void main(String[] args) {
		
		final ThreadWait obj = new ThreadWait();
		new Thread(new Runnable() {
			@Override
			public void run() {
				obj.retrieve(15000);
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				obj.retrieve(15000);
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				obj.deposit(50000);
			}
		}).start();

		
	}

}
