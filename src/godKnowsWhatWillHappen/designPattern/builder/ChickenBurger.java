package godKnowsWhatWillHappen.designPattern.builder;

public class ChickenBurger implements MealContentProperties{

	String wrapper;
	int price;
	public ChickenBurger() {
		wrapper = "ChickenBurger Box in red color";
		price = 100;
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
