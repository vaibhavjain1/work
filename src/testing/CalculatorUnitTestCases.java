package testing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorUnitTestCases {
    static Calculator1 obj;

    @Test
    public void testConcatenate() {
        int result = obj.add(1, 2);

        assertEquals(3, result);

    }

    @BeforeAll
    public static void testMul() {
        obj = new Calculator1();

    }
}
