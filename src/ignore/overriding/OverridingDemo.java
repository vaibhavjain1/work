package ignore.overriding;

import java.util.List;

class Parent1{
	public void func(int a){
		System.out.println("Called parent");
	}
	public static void func1(){
		
	}
	
	public int func(int a, int b){
		return 0;
	}
}

class Child1 extends Parent1{
	public void func(Integer a){
		System.out.println("Called child");
	}
	
	public static void func1(){
		List<Object> objectList;
		List<String> stringList;
		
		try {
			
		} catch (RuntimeException e) {
			// TODO: handle exception
		}
		      
		 //stringList= objectList ;
	}
}

public class OverridingDemo {
	
}
