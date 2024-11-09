package godKnowsWhatWillHappen.designPattern.singleton;

public class SingletonDemo {

	/*
	 * Definitation : Singleton pattern enables user to create one and only instance of a class
	 * 
	 * Example : Connection Class
	 * 
	 * Java Example: Runtime, Desktop
	 */
	public static void main(String[] args) {
		Singleton obj = Singleton.getInstance();
		Singleton obj1 = Singleton.getInstance();
	}
}
