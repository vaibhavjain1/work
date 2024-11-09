package godKnowsWhatWillHappen.designPattern.decoratorPattern;

public class ExtraCheese extends PizzaDecorator{

	MainInterface obj;
	public ExtraCheese(MainInterface obj) {
		this.obj = obj;
	}
	
	@Override
	public void preparePizza() {
		obj.preparePizza();
	}

	@Override
	public int Amount() {
		System.out.println("Total amount"+obj.Amount()+50);
		return 0;
	}

}
