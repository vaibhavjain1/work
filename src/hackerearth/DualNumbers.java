package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DualNumbers {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		while(noOfTestCases!=0){
			br.readLine();
			String[] tempInput = br.readLine().split(" ");
			int[] input = new int[tempInput.length];
			for (int k = 0; k < tempInput.length; k++) {
				input[k] = Integer.parseInt(tempInput[k]);
			}
			int max = -1;
			for (int i = 0; i < input.length; i++) {
				if(i==0){
					for (int j = 0; j < input.length; j++) {
						if(!isPrime(input[j]))
							input[j] = -1;
					}
				}
				for (int j = i; j < input.length; j++) {
					if(input[j]!=-1&&input[i]*input[j]>max){
						max = input[i]*input[j];
					}
				}
			}	
			System.out.println(max);
			noOfTestCases--;
		}
	}
	
	public static boolean isPrime(int num){
		if(num==1)
			return false;
		for (int i = 2; i <= num/2; i++) {
			if(num%i==0)
				return false;
		}
		return true;
	}

}
