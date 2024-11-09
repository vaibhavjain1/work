package godKnowsWhatWillHappen.designPattern.singleton;

public class Singleton {

	private static Singleton singleInstance;
	
	private Singleton(){}
	
	public static Singleton getInstance(){
		System.out.println("Getting instance of singleton class");
		if(singleInstance==null)
		{
			System.out.println("Creating new instance");
			singleInstance = new Singleton();
		}
		return singleInstance;
	}
}
