package godKnowsWhatWillHappen.designPattern.builder;

public class BuilderDemo {

	public static void main(String[] args) {
		MealBuilder mealBuilder = new MealBuilder();
		mealBuilder.prepareVegMeal();
		mealBuilder.cost();
		mealBuilder.prepareNonVegMeal();
	}
	
}
