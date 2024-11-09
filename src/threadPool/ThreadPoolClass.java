package threadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolClass {

	public ThreadPoolClass(){
		
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService ser = Executors.newFixedThreadPool(2);
		Thread t1 = new Thread(new MultiThreadingClass());
		Thread t2 = new Thread(new MultiThreadingClass());
		Thread t3 = new Thread(new MultiThreadingClass());
		
		Future<?> t1ans = ser.submit(t1);
		System.out.println(t1ans.get());
		ser.submit(t2);
		ser.submit(t3);
		ser.shutdown();
		
		while (ser.isTerminated()) {
			
		}
	}
}
