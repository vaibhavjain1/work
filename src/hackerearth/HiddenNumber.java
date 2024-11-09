package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HiddenNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		while(noOfTestCases!=0){
			int noOfIntegers = Integer.parseInt(br.readLine());
			String[] integers = br.readLine().split(" ");
			int sum = 0;
			for (int i = 0; i < noOfIntegers; i++) {
				sum += Integer.parseInt(integers[i]);
			}
			if(sum%noOfIntegers==0)
				System.out.println(sum/noOfIntegers);
			else
				System.out.println("-1");
			noOfTestCases--;
		}
	}

}
