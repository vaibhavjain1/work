package codeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class SPALNUM {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(System.out);
		int noOfInput = Integer.parseInt(br.readLine());
		while(noOfInput>0 && noOfInput<101){
		String[] inputArray = br.readLine().split(" ");
		int leftEntry = Integer.parseInt(inputArray[0]);
		int rightEntry = Integer.parseInt(inputArray[1]);
		if(leftEntry<0&&leftEntry>100000&&rightEntry<0&&rightEntry>100000){
			return;
		}
		int sum = 0;
		for (int i = leftEntry; i <= rightEntry; i++) {
			if(isPalindrome(i)){
				sum+=i;
			}
		}
		pr.println(sum);
		noOfInput--;
		}
		pr.close();
	}

	public static boolean isPalindrome(int number){
		Map<String, String> d = new HashMap<>();
		d.clear();
		String abc = String.valueOf(number);
		for (int i = 0; i < abc.length()/2; i++) {
			if(abc.charAt(i)!=abc.charAt(abc.length()-1-i)){
				return false;
			}
		}
		return true;
	}
}
