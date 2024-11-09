package ignore.threadPool;

import java.util.concurrent.atomic.AtomicInteger;



public class MyThreads{

	private static class MyDaemonThread extends Thread{
	
		public MyDaemonThread() {
			setDaemon(true);
		}
		public static void abc(){
			AtomicInteger temp=  new AtomicInteger();
			
		}
		public static void main(String[] args) {
			
		}
	}
	
}
