package godKnowsWhatWillHappen.designPattern.factoryPattern;

public class FactoryDemo {

	/*
	 * definition : Factory pattern enables subclasses to instantiate required class at runtime.
	 * 
	 * Example : Example of new employee is joining then on the basis of department select the salary to be provided.
	 * 
	 * Example in JAVA : Java.util.calendar, NumberFormat, ValueOf in wrapper class
	 * 
	 */
	public static void main(String[] args) {
	
		MainFactory obj = new MainFactory("Engineer");
		obj.displaySalary();
	}

}
