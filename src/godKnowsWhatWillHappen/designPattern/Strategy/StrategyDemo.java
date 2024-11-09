package godKnowsWhatWillHappen.designPattern.Strategy;

public class StrategyDemo {

	/*
	 * definition : Strategy pattern enables user to change behaviour of an algorithm at runtime.
	 * 				it defines family of algorithm and make them interchangable.
	 * 
	 * Example : Example of new employee is joining then on the basis of department select the salary to be provided.
	 * 
	 * Example in JAVA : Collections.sort()
	 * 
	 */
	public static void main(String[] args) {
	
		MainStrategyImplementer obj = new MainStrategyImplementer(new Engineer());
		obj.displaySalary();
	}

}
