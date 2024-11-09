package godKnowsWhatWillHappen.designPattern.decoratorPattern;

public class PreparePizza implements MainInterface {

	@Override
	public void preparePizza() {
		System.out.println("Preparing pizza");
	}

	@Override
	public int Amount() {
		System.out.println("Amount of pizza:"+50);
		return 50;
	}

}
