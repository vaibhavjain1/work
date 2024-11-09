package godKnowsWhatWillHappen.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class MainObserver {

	List<ObserverInterface> observerList = new ArrayList<>();
	private int value;
	
	public void addObserver(ObserverInterface observer){
		observerList.add(observer);
	}
	
	public void setRsValue(int value){
		this.value = value;
		notify1();
	}
	
	public void notify1(){
		for (ObserverInterface observer : observerList) {
			observer.setValue(value);
		}
	}
}
