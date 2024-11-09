package testing;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList();
	    list.add("Hello");
	    String s = (String) list.get(0);
	    System.out.println(s);
	}
	
	 
	
	
	
	
	
	
	
	
	public static void main1(String[] args) {
		int a = 5;
		int b = 10;

		float c = 5f;
		float d = 10f;

		double e = 5.0;
		double f = 10.0;
	}


	
	
	
	
	
	
	
	
	public static <T extends Number> Double sum(T x,T y) {
		return x.doubleValue() + y.doubleValue();
	}

	
	
	public static void main2(String args[]) {
		// Create arrays of Integer, Double and Character
		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
		Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.println("Array integerArray contains:");
		//printArray(intArray); // pass an Integer array

		System.out.println("\nArray doubleArray contains:");
		//printArray(doubleArray); // pass a Double array

		System.out.println("\nArray characterArray contains:");
		//printArray(charArray); // pass a Character array
	}
}
