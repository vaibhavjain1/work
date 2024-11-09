package hackerRank;


public class MyTest {

	
	public static void main(String[] args) {
			
		final String resource1 = "hello";
		final String resource2 = "world";
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (resource1) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (resource2) {
						System.out.println("d");
					}
				}
			}
		});
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (resource2) {
					synchronized (resource1) {
						
					}
				}
			}
		});
		t1.start();
		t.start();
	}
	
}

