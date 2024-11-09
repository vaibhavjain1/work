package codeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class CHRL4 {

	public static void main(String[] args) throws IOException {
		int mod = 1000000007;
		BigInteger result = BigInteger.valueOf(1);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in),1024 * 1024 * 2);
		String nk = br.readLine();
		String streets = br.readLine();
		String[] tempnkString = nk.split(" ");
		String[] tempstreetstring = streets.split(" ");
		int n = Integer.parseInt(tempnkString[0]);
		int k = Integer.parseInt(tempnkString[1]);
		
		int i = tempstreetstring.length-1;
		if(i<n-1 || i>n-1 || k<1 || k>n || n > 100000){
			System.out.println("Invalid input");
		} else {
		while (i>=0) {
			result= result.multiply(BigInteger.valueOf(Integer.parseInt(tempstreetstring[i])));
			result = result.mod(BigInteger.valueOf(mod));
			i=i-k;
		}
		
		System.out.println(result);
		}
	}

}
