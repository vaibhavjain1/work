package reflection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

class A{  
private void cube(int n){System.out.println(n*n*n);}  
}  

class myVar{
	private int obj = 50;
	private void callPrivateMethod(){
		System.out.println("Private method called.");
	}
}

public class CheckingReflection {
	public static void abc(int arg1, String... args){
		for (String string : args) {
			System.out.println(string);
		}
		/*for (String string : arg1) {
			System.out.println(string);
		}*/
	}
	
	public static void temp(String[] args){
		for (String string : args) {
			System.out.println(string);
		}
	}
	public static void main(String[] args) throws Exception {
		
		AtomicInteger tr = new AtomicInteger(0);
		tr.addAndGet(15);
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 PrintWriter pr = new PrintWriter(System.out);
		 int noOfTestCases = Integer.parseInt(br.readLine());
		 for (int j = 0; j < noOfTestCases; j++) {
		 int noOfCars = Integer.parseInt(br.readLine());
		 int noOfCarsMovingAtMaximumSpeed = 1;
		 String[] tempCars = br.readLine().split(" ");
		 int min = Integer.parseInt(tempCars[0]);
		 for(int i=1;i<noOfCars;i++){
		 	if(Integer.parseInt(tempCars[i])<=min&&Integer.parseInt(tempCars[i])<=Integer.parseInt(tempCars[i-1])){
		 		min = Integer.parseInt(tempCars[i]);
		 		noOfCarsMovingAtMaximumSpeed++;
		 	}
		 }
		 pr.println(noOfCarsMovingAtMaximumSpeed);
		 }
		 pr.flush();
	}
}
