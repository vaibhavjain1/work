package godKnowsWhatWillHappen.designPattern.decoratorPattern;

public class DecoratorDemoe {

	/*
	 * Definition: Decorator pattern enables users to add extra functionalities to the object dynamically
	 * 
	 * Example : Restaurent pizza
	 * 
	 * Java Example: Java.io package for bufferedReader, fileReader
	 */
	public static void main(String[] args) {
		PizzaDecorator obj = new ExtraCheese(new PreparePizza());
		obj.preparePizza();
		obj.Amount();

	}

}
