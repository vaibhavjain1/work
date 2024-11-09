package interview;

public class DemoDeadlock {

	
	public static void main(String[] args) {
		final String s1="lock1";
		final String s2="lock2";
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (s1) {
				       try {
						Thread.sleep(2000);
						synchronized (s2) {
							
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {

				synchronized (s2) {
				       try {
						Thread.sleep(2000);
						synchronized (s1) {
							
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}
		});
	
		t1.start();
		t2.start();
	}

}
