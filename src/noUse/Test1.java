package noUse;

import java.util.ArrayList;
import java.util.List;

class Shape { /* ... */ }
class Circle extends Shape { /* ... */ }
class Rectangle extends Shape { /* ... */ }

class Node<T> { /* ... */ }
public class Test1
{
	public static void main(String[] args) {
		Node<Circle> nc = new Node<>();
		
		List rawType;
		List<Object> objectType;
		List<?> unknownType;
		
		rawType = new ArrayList<String>();  //new ArrayList<Object>(); or new ArrayList<String>() will also work
		rawType.add(10); 
		rawType.add("12"); // Both works. No type safety
		
		objectType = new ArrayList<Object>(); //new ArrayList<>();
		//objectType = new ArrayList<String>(); won't work
		
		unknownType = new ArrayList<String>();
		unknownType.add(null); // only null can be added
		//unknownType.add("10"); wont work
		//Since nothing is known about this type, you can't add anything to that set (except for null) 
		//Wild card type can only ever be useful for reading from it's elements.
		// It signals a promise that the method in question is aware of generics and will honor the generic type of that object.
		
	}
}
