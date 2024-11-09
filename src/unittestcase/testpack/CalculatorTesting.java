package unittestcase.testpack;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import unittestcase.javapack.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTesting {

	@BeforeAll
	public void testing(){

	}
	@Test
	//@Parameters({1,2})
	public void testAdd(int a, int b){
		Calculator obj = new Calculator();
		int result = obj.add(10, 20);
		assertEquals(30,result);
	}
}
