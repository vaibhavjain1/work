package godKnowsWhatWillHappen.designPattern.builder;

public class VegBurger implements MealContentProperties{

	String wrapper;
	int price;
	public VegBurger() {
		wrapper = "VegBurger Box green color";
		price = 50;
	}

	@Override
	public String wrapper() {
		return wrapper;
	}

	@Override
	public int price() {
		return price;
	}
	
	
}
