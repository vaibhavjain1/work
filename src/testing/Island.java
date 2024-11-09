package testing;

public class Island {

	public static int count = 0;
	public static void main(String[] args) {
		int[][] island = {
							{0,1,0,1,0},
							{0,0,1,1,1},
							{1,0,0,1,0},
							{0,1,1,0,0},
							{1,0,1,0,1}
						};
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if(island[i][j] == 1) {
					checkadjacent(island, i, j);
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	private static void checkadjacent(int[][] island, int i, int j) {
		if((j-1)>=0 && island[i][j-1]==1) {
			island[i][j-1]=0;
			checkadjacent(island, i, j-1);
		}
		if((j+1)<5 && island[i][j+1]==1) {
			island[i][j+1]=0;
			checkadjacent(island, i, j+1);
		}
		if((i-1)>=0 && island[i-1][j]==1){
			island[i-1][j]=0;
			checkadjacent(island, i-1, j);
		}
		if((i+1)<5 && island[i+1][j]==1) {
			island[i+1][j]=0;
			checkadjacent(island, i+1, j);
		}
	}
}
