package viacom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfAlbums = Integer.parseInt(br.readLine());
		if(noOfAlbums>100000)
			return;
		String[] tempIinput = br.readLine().trim().split(" ");
		int noOfQueries = Integer.parseInt(br.readLine());
		if(noOfQueries>1000000)
			return;
		for (int i = 0; i < noOfQueries; i++) {
			int maxBuy = 0;
			String[] temp = br.readLine().split(" ");
			int lowerBound = Integer.parseInt(temp[0]) - 1;
			int upperBound = Integer.parseInt(temp[1]) - 1;
			int divisor = Integer.parseInt(temp[2]);
			
			for (int j = lowerBound; j <= upperBound; j++) {
				if (Integer.parseInt(tempIinput[j]) % divisor == 0)
					maxBuy++;
			}
			System.out.println(maxBuy);
		}
	}
}
