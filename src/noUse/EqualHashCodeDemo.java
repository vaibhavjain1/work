package noUse;

import java.util.HashMap;
import java.util.Map;

class Student {
    int rollNo;
    String name;

    @Override
    public int hashCode() {
        int hash = 20;
        hash = hash + rollNo;
        hash = hash + name.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}

public class EqualHashCodeDemo {

    public static void main(String[] args) {
        int a = 20;
        a = a * 20 + 10;
        System.out.println(a);

    }
}
