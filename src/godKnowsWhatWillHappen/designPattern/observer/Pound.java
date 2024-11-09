package godKnowsWhatWillHappen.designPattern.observer;

public class Pound implements ObserverInterface{

	int value;

	public void setValue(int value){
		this.value = value*72;
	}
	public void displayValue(){
		System.out.println("Total pound value : "+value);
	}
}
