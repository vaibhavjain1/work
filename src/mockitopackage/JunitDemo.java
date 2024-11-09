package mockitopackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

interface Calculator {
    int add(int a, int b);

    float divide(int a, int b);
}

class MyCalculator implements Calculator{

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public float divide(int a, int b) {
        return a/b;
    }
}

public class JunitDemo{

    @Test
    void testAdd(){
        MyCalculator obj = Mockito.mock(MyCalculator.class);
        Mockito.when(obj.add(Mockito.anyInt(),Mockito.anyInt())).thenCallRealMethod();
        Mockito.when(obj.divide(10,0)).thenCallRealMethod();
        int val = obj.add(10, 20);
        Assertions.assertEquals(30, val);
        Assertions.assertThrows(ArithmeticException.class, () -> obj.divide(10,0));
    }
}