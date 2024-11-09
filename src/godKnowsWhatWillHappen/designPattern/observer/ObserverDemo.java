package godKnowsWhatWillHappen.designPattern.observer;

public class ObserverDemo {

	/*
	 * Definition : Observer pattern is used when state of an object is changed then all the dependent objects needs to be notified
	 * 
	 * Example : on Rs change , change the dollar , pound
	 * 
	 * Java Example : In built observer classes are there
	 */
	
	public static void main(String[] args) {
		
		Dollar dollarObj = new Dollar();
		Pound poundObj = new Pound();
		
		
		MainObserver obj = new MainObserver();
		obj.addObserver(dollarObj);
		obj.addObserver(poundObj);
		
		dollarObj.displayValue();
		poundObj.displayValue();
		
		obj.setRsValue(10);
		
		dollarObj.displayValue();
		poundObj.displayValue();
		
	}
}
