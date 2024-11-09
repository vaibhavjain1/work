package testing;

public class StringTesting {
    public static void main(String[] args) {
        String test = "vaibhav";
        String test1 = new String("vaibhav");
        if(test == test1)
            System.out.println("== yes");
        else
            System.out.println("== NO");
        if(test.equals(test1))
            System.out.println("equals yes");
        else
            System.out.println("equals NO");
    }
}
