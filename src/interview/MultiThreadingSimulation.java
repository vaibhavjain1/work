package interview;

public class MultiThreadingSimulation {

	public static void main(String[] args) {
		Market  market = new Market(3);
		Farmer farmThread = new Farmer(market);
		Consumer consumeThread = new Consumer(market);
		farmThread.start();
		consumeThread.start();
	}
}

class Market{
	int currSize;
	int maxSize;
	int currMarket[];
	public Market(int maxSize) {
		this.currMarket = new int[maxSize];
		this.maxSize = maxSize;
	}
	
	public void addToMarket(int var){
		synchronized (currMarket) {
			if(currSize<maxSize){
				System.out.println("+:"+currSize);
				currMarket[currSize]=var;
				currSize+=1;
				System.out.println("Added :"+var);
				currMarket.notifyAll();
			}else{
				try {
					currMarket.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void purchaseFromMarket(){
		synchronized (currMarket) {
			if(currSize>0){
				System.out.println("-:"+currSize);
				int a = currMarket[--currSize];
				currMarket[currSize] = -1;
				currMarket.notifyAll();
				System.out.println("purchase :"+a);;
			}else{
				try {
					currMarket.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Farmer extends Thread{
	Market market;
	public Farmer(Market market) {
		this.market = market;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			market.addToMarket(1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread{
	Market market;
	public Consumer(Market market) {
		this.market = market;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				market.purchaseFromMarket();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}