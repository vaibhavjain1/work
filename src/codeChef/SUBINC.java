package codeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SUBINC {
 public static void main(String[] args) throws NumberFormatException, IOException {
	
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	 int numberOfTestcases = Integer.parseInt(br.readLine());
	 if(numberOfTestcases<1 || numberOfTestcases>5){
		 return;
	 }
	 int[] endResult = new int[6];
	 for (int k = 0; k < numberOfTestcases; k++) {

	 int arraysized = Integer.parseInt(br.readLine());
	 
	 if(arraysized<1 || arraysized>100000){
		 return;
	 }
		 
	 String tempArray = br.readLine();
	 String[] splitArray = tempArray.split(" ");
	 int result=0;
	 if(splitArray.length!=arraysized){
		 return;
	 }
		 else {	 
		 result+=arraysized;
		 for (int i = 0; i < splitArray.length; i++) {
			 if(Integer.parseInt(splitArray[i])<1 || Integer.parseInt(splitArray[i])>1000000000){
				 return;
			 }
			 int j=i;
			 while (j<splitArray.length-1 && Integer.parseInt(splitArray[j])<=Integer.parseInt(splitArray[j+1])) {
				result+=1;
				j+=1;
			}
			
		}
	 }
	 endResult[k] =  result;
 }
	 for (int p = 0; p < endResult.length; p++) {
		if(endResult[p]!=0)
			System.out.println(endResult[p]);
		
	}
 }
}
