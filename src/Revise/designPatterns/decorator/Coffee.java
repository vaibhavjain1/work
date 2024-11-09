package Revise.designPatterns.decorator;

public class Coffee implements MainInterface {

	@Override
	public void description() {
		System.out.println("Added coffe");
	}

	@Override
	public void amount() {
		System.out.println("Total amount =" +50);
	}

}
