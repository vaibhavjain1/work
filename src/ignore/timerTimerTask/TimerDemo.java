package ignore.timerTimerTask;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

	public static void main(String[] args) {
		Timer timer = new Timer(true); // to run timer as daemon thread
		TimerTask timertask = new TimerTask() {
			@Override
			public void run() {
				System.out.println("Called timer task");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {}
			}
		};
		
		timer.scheduleAtFixedRate(timertask, 0, 1000);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {}
		timer.cancel(); //Cancel after sometime
	}
}
