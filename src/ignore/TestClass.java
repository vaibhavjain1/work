package ignore;

/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;


class TestClass {
	private static int vx1;
	private static int vx2;
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
		
		vx1 = functionVX(MonkElements, EMonkElements);
		vx2 = functionVX(EMonkElements, MonkElements);
		
		
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
    public static int functionVX(int[] From,int[] To){
    	int fx = functionFX(From[0], To);
    	int gx = functionGX(From[0], To);
    	int value = fx*gx;
    	int fxCache = From[0];
    	int gxCache = From[0];
    	for (int i = 1; i < From.length; i++) {
    		if(From[i]<fxCache){
    			fx = functionFX(From[i], To);
    			fxCache = From[i];
    		}
    		else if(From[i]>gxCache){
    			gx = functionGX(From[i], To);
    			gxCache = From[i];
    		}
    		value += fx *gx;
		}
    	return value;
    }
    
    
    public static int functionFX(int From,int[] To){
    	int noOfElementsLessThan1 = 0;
			for (int j = 0; j < To.length; j++) {
				if(From>To[j]){
					noOfElementsLessThan1++;
				} 
			}
		return noOfElementsLessThan1;
    }
    
    public static int functionGX(int From,int[] To){
    	int noOfElementsGreaterThan1 = 0;
			for (int j = 0; j < To.length; j++) {
				if(From<To[j]){
					noOfElementsGreaterThan1++;
				} 
			}
		return noOfElementsGreaterThan1;
    }
}
