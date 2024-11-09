package abstractClassTesting;

import java.util.*;

public abstract class LetSeeAbstract {

	private final int abc;
	
	private final static void myMethod(){
		
	}
	enum temp{
		mybaby{
			int temp1 = 0;
			Set a = new HashSet<>(10);
			Map b = new HashMap<>();
			
		}
	}
	
	public LetSeeAbstract() {
		
		abc= 0 ;
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Set s = new HashSet<>();
		s.add("a");
		s.add("b");
		System.out.println(s);
		Collections.synchronizedSet(s);
		s.add("c");
		System.out.println(s);
	}
}
