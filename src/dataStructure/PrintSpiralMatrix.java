package dataStructure;

public class PrintSpiralMatrix {

	public static void main(String[] args) {
		int m = 2;
		int n = 2;
		int[][] mat = {
				     {1,2,3},
				     {4,5,6},
				     {7,8,9}
					};
		
		int i=0, j=0;
		while(j<=n) {
			System.out.println(mat[i][j]);
			if(j==n)
				break;
			j++;
		}
		i++;
		while(i<=m) {
			System.out.println(mat[i][j]);
			if(i==m)
				break;
			i++;
		}
		j--;
		while(j>=0) {
			System.out.println(mat[i][j]);
			if(j==0)
				break;
			j--;
		}
		i--;
		
	}

}
