package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// URL: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/magical-word/

public class Dhananjay_Magical_word {

	public static boolean isPrimeOrNot(int num) {
		if (num < 0) {
			return false;
		}
		if (num == 0 || num == 1) {
			return false;
		}
		if (num == 2 || num == 3) {
			return true;
		}
		if ((num * num - 1) % 24 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int nearestPrime(int num){
		int i = num;
		for (; i <= 122 && i >= 65; i++) {
			//int lower = 
		}
		return i;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		while(noOfTestCases>0){
			int StringLength = Integer.parseInt(br.readLine());
			char[] tempArray = br.readLine().toCharArray();
			for (int i = 0; i < tempArray.length; i++) {
				if(isPrimeOrNot((int)tempArray[i])){
					System.out.print(tempArray[i]);
				}else{
					
				}
			}
			noOfTestCases--;
			System.out.println();
		}
	}

}
