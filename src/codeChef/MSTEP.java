package codeChef;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MSTEP {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] endResult=null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int noOfTestCases = Integer.parseInt(br.readLine());
		if(noOfTestCases<1 || noOfTestCases>5)
			return;
		endResult = new int[noOfTestCases];
		for (int p = 0; p < noOfTestCases; p++) {
			
		int n = Integer.parseInt(br.readLine());
		if(n<1 || n>500)
			return;
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] tempi = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				matrix[i][j]= Integer.parseInt(tempi[j]);
			}
		}
		int row=0;
		int column =0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(matrix[i][j]==1){
					row=i;
					column=j;
					i=n;
					break;
				}
			}
		}
		int current = 1;
		int steps=0;
		while(current<=(n*n)){
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(matrix[i][j]==current){ 
						steps+=Math.abs(row-i)+Math.abs(column-j);
						row=i;
						column=j;
					}
				}
			}
			current+=1;
		}
		endResult[p]=steps;
		}
		
		for (int p = 0; p < noOfTestCases; p++) {
			System.out.println(endResult[p]);
			
		}
	}

}
