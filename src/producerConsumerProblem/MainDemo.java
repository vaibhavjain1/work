package producerConsumerProblem;

public class MainDemo {

	public static void main(String[] args) {
		Buffer Obj = new Buffer();
		Consumer cObj = new Consumer(Obj);
		Producer pObj = new Producer(Obj);
		
		pObj.start();
		cObj.start();
	}

}
