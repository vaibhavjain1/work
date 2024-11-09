package overriding_overloading;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

class Myobject{
	int myValue;
}
public class OverRiding {
	
	public static void main(String[] args) throws Exception {
		
		 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        int[] myArray = new int[N];
        for (int i = 0; i < N; i++) {
            myArray[N-1-i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            System.out.println(myArray[i]);
        }
        
	}
	
	public void changeprimitive(int i){
		// in case of primitive it's pass by value
	};
	
	public void changeArray(int[] array){
		int[] array1 = {5,4,3,2,1};
		int[] temp = array;
		array = array1;
		array1 = temp;
	}
	
	public void changeObject(Myobject obj){
		
	}
	
	static void swap(String[] a) {
	    String t = a[0];
	    a[0] = a[1];
	    a[1] = t;
	}
}
