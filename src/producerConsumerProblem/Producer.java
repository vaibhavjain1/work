package producerConsumerProblem;

public class Producer extends Thread {

	Buffer b;
	public Producer(Buffer obj) {
		this.b = obj;
	}
	@Override
	public void run() {
			for (int i = 0; i < 1000; i++) {
				b.put(i);
			}
	}

	
}
