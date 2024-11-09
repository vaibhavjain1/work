package producerConsumerProblem;

public class Consumer extends Thread {

	Buffer b;
	
	
	public Consumer(Buffer obj) {
		this.b = obj;
	}


	@Override
	public void run() {
for (int i = 0; i < 1000; i++) {
b.remove();
	
}
	}

	
}
