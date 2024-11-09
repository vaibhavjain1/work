package godKnowsWhatWillHappen.designPattern.observer;

public class Dollar implements ObserverInterface{

	int value;

	public void setValue(int value){
		this.value = value*50;
	}
	public void displayValue(){
		System.out.println("Total dollar value : "+value);
	}
}
