package generics;

import java.util.ArrayList;
import java.util.List;

public class Generic<E > {
	
	Generic(E o){
		
	}
	
	public static void main(String[] args) {
		List<?> t = new ArrayList<String>();
		t.add(34, null);
		for (Object object : t) {
			System.out.println(object);
		}
		
	}

}
