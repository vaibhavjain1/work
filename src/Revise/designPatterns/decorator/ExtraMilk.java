package Revise.designPatterns.decorator;

public class ExtraMilk extends Decorator{

	MainInterface obj;
	ExtraMilk(MainInterface newObj){
		obj = newObj;
	}
	@Override
	public void description() {
		obj.description();
		System.out.println("Plus extra milk");
	}

	@Override
	public void amount() {
		obj.amount();
		System.out.println("Plus rs 50");
	}

	
}
