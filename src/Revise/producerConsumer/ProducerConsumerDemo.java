package Revise.producerConsumer;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		PrintNumber obj = new PrintNumber(new Object());
		Thread teven = new Thread(obj,"Even");
		Thread todd = new Thread(obj,"Odd");
		teven.start();
		todd.start();
	}

}
