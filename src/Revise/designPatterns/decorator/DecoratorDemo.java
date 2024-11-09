package Revise.designPatterns.decorator;

public class DecoratorDemo {

	public static void main(String[] args) {
		MainInterface obj = new Coffee();
		obj = new ExtraMilk(obj);
		obj.amount();
	}
}
