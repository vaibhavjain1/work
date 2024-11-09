package viacom;

class A1 {
    public int i;
    protected int j;
}    
class B2 extends A1 {
    int j;
    void display() {
        super.j = 3;
        super.i=10;
        System.out.println(i + " " + j);
    }
}    
public class Testclass5 extends Thread{
	
    public static void main(String[] args) {
    	/*java.text.DecimalFormat.DecimalFormat df2 = new java.text.DecimalFormat.DecimalFormat(".000");
    	System.out.println(df2.format(64));*/
    }
    public static double limitPrecision(String dblAsString, int maxDigitsAfterDecimal) {
        int multiplier = (int) Math.pow(10, maxDigitsAfterDecimal);
        double truncated = (double) ((long) ((Double.parseDouble(dblAsString)) * multiplier)) / multiplier;
        System.out.println(dblAsString + " ==> " + truncated);
        return truncated;
    }
}
