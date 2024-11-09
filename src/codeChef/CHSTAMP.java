package codeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CHSTAMP {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tempi = br.readLine().split(" ");
		int numberOfChefStamp = Integer.parseInt(tempi[0]);
		int numberOfOffers = Integer.parseInt(tempi[1]);
		tempi = br.readLine().split(" ");
		List<Integer> stampList = new ArrayList<Integer>();
		for (int i = 0; i < tempi.length; i++) {
			stampList.add(Integer.parseInt(tempi[i]));	
		}
		
		int[][] offers = new int[numberOfOffers][3];
		for (int j = 0; j < numberOfOffers; j++) {
			tempi=br.readLine().split(" ");
			for (int k = 0; k < 3; k++) {
				offers[j][k]=Integer.parseInt(tempi[k]);
			}
		}
		
		for (int i = 0; i < numberOfOffers; i++) {
			for (int j = 0; j < stampList.size(); j++) {
				if(stampList.get(j)==offers[i][1]){
					stampList.set(j, offers[i][2]);
				}
			}
		}
	}

}
