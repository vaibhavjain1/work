package godKnowsWhatWillHappen.designPattern.builder;

import java.util.ArrayList;
import java.util.List;

public class MealBuilder {

	List<MealContentProperties> mealContents;
	public void prepareVegMeal(){
		mealContents = new ArrayList<>();
		mealContents.add(new VegBurger());
		mealContents.add(new Coke());
	}

	public void prepareNonVegMeal() {
		mealContents = new ArrayList<>();
		mealContents.add(new ChickenBurger());
		mealContents.add(new Coke());
	}
	
	public void cost(){
		int cost= 0;
		for (MealContentProperties MealObj : mealContents) {
			cost+=MealObj.price();
		}
		System.out.println("Total cost of Meal:" + cost);
	}
	
}
