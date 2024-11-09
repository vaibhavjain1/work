package monoCept;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MyTest{
	
	private static int vx1;
	private static int vx2;
	
	public static BigInteger Fact(int n) {
		int ik= 4;
		//float f = 4.0;
		double ff = 9.0; 
		 BigInteger fact = BigInteger.valueOf(1);
		    for (int i = 1; i <= 8785856; i++)
		        fact = fact.multiply(BigInteger.valueOf(i));
		    return fact;
    }
	
	static BigInteger Count(int K, int S)
    {
        BigInteger sum = BigInteger.valueOf(0);
        for (int i = 1; i <= S; i++)
        {
        	//sum.add( Fact(S).multiply(BigInteger.valueOf((long) Math.pow(-1, (S-i))))).divide((Fact(i).multiply(Fact(S - i))).multiply( (long) Math.pow(i, K)));
        }
        return sum.mod(BigInteger.valueOf(1000000007)) ;
    }
	
	public static void main2(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int NoofTestcases = Integer.parseInt(br.readLine().trim());
		while (NoofTestcases!=0) {
			System.out.println(Count(Integer.parseInt(br.readLine()), 3));
			NoofTestcases--;
		}
		
	}
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] tempInput = br.readLine().split(" ");
		
    	int noOfElementForMonk = Integer.parseInt(tempInput[0]);
		int noOfElementForEMonk = Integer.parseInt(tempInput[1]);
		
		String[] tempInput1 = br.readLine().split(" ");
		String[] tempInput2 = br.readLine().split(" ");
		
		int[] MonkElements = new int[tempInput1.length];
		int[] EMonkElements = new int[tempInput2.length];
		
		for (int i = 0; i < tempInput1.length; i++) {
			MonkElements[i] = Integer.parseInt(tempInput1[i]);
		}
		
		for (int j = 0; j < tempInput2.length; j++) {
			EMonkElements[j] = Integer.parseInt(tempInput2[j]);
		}
		
		functionVX(MonkElements, EMonkElements);
		
		if(vx1>vx2)
			System.out.println("Monk "+(vx1-vx2));
		else if(vx1<vx2)
			System.out.println("!Monk "+(vx2-vx1));
		else
			System.out.println("Tie");
	}
    
    class Variable{
    	int value;
    	int greaterThen;
    	int LessThen;
		public Variable(int value, int greaterThen, int lessThen) {
			super();
			this.value = value;
			this.greaterThen = greaterThen;
			LessThen = lessThen;
		}
    	
    }
    public static void functionVX(int[] From,int[] To){
    	Map<Integer,Variable> Map1 = new HashMap<>();
    	Map<Integer,Variable> Map2 = new HashMap<>();
    	for (int i = 0; i < From.length; i++) {
    		for (int j = 0; j < To.length; j++) {
    			if(From[i]<To[j]){
					//Map1.put(i,Map1.get(1).LessThen+1);
				} else if(From[i]>To[j]){
					
				}
    		}
		}
    }
    
    
    public static void functionFX(int From,int[] To){
    	int noOfElementsLessThan1 = 0;
    	int noOfElementsGreaterThan1 = 0;
    	int noOfElementsLessThan2 = 0;
    	int noOfElementsGreaterThan2 = 0;
    	
			for (int j = 0; j < To.length; j++) {
				if(From<To[j]){
					noOfElementsLessThan1++;
				} else if(From>To[j]){
					noOfElementsGreaterThan1++;
				}
			}
    	vx1 += noOfElementsLessThan1*noOfElementsGreaterThan1;
    	vx2 += noOfElementsLessThan2*noOfElementsGreaterThan2;
    }
    
}