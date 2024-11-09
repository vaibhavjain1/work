package godKnowsWhatWillHappen.designPattern.builder;

public class Coke implements MealContentProperties{

	String wrapper;
	int price;
	public Coke() {
		wrapper = "Bottle";
		price = 20;
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
