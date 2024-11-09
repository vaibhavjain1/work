package overriding_overloading;

public class StaticInitializer_Block {

	static{
		System.out.println("static block called");
	}
	
	{
		System.out.println("Initial block1 called");
	}
	{
		System.out.println("Initial block2 called");
	}
	
	public static void main(String[] args) {
		StaticInitializer_Block obj = new StaticInitializer_Block();
		
	}
}
