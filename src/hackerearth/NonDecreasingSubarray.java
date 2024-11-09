package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NonDecreasingSubarray {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfElement = Integer.parseInt(br.readLine());
		String[] tempInput = br.readLine().split(" ");
		int[] input = new int[noOfElement];
		for (int i = 0; i < noOfElement; i++) {
			input[i] = Integer.parseInt(tempInput[i]);
		}
		
		int result = 0;
		for (int i = 0; i < input.length; i++) {
			int longestsubarray = 1;
			int temp = input[i];
			for (int j = i+1; j < input.length; j++) {
				if(input[j]>=temp){
					longestsubarray++;
					temp = input[j];
				}
				else
					break;
			}
			if(longestsubarray>result)
				result = longestsubarray;
		}
		System.out.println(result);
	}

}
