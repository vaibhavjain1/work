package exception;

import java.util.HashMap;
import java.util.Map;


public class Parent {

	public void abc() throws Exception{
	try {
		try {
			Map<String, Integer> abc = new HashMap<>();
			abc.clear();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	} catch (Exception e) {
		// TODO: handle exception
	}	
	}
}
