package noUse;

public class My_class extends Thread{
	static int tempValue;
   public static void main(String args[]) throws InterruptedException{
      
	   My_class thread1 = new My_class();
	   My_class thread2 = new My_class();
	   Thread a = new Thread(thread1);
	   Thread b = new Thread(thread2);
	   a.start();
	   b.start();
}

   
@Override
public synchronized void run() {
	tempValue++;
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("I'm in run of"+Thread.currentThread().getName()+" and value of tempvalue = "+ tempValue);
}}