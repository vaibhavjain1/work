package amazing;

public class MaxSum {

	public static void main(String[] args) {
		int ar1[] = {1, 5, 9, 10, 15, 20};
	    int   ar2[] = {2, 3, 8, 13};
		int j = 0;
		for (int i = 0; i < ar1.length; i++) {
			if(ar1[i]<ar2[j])
				continue;
			else{
				int temp = ar1[i];
				ar1[i]=ar2[j];
				ar2[j] = temp;
				sort(ar2);
			}
		}
		
		
		System.out.print("Array 1 ");
		for (int i = 0; i < ar1.length; i++) {
			System.out.print(ar1[i]+" ");
		}
		System.out.println();
		System.out.print("Array 2 ");
		for (int i = 0; i < ar2.length; i++) {
			System.out.print(ar2[i]+" ");
		}
	}
	
	public static void sort(int[] array){
		for (int i = 0; i < array.length-1; i++) {
			if(array[i]<array[i+1])
				continue;
			else{
				while(i < array.length-1 && array[i]>array[i+1] ){
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					i++;
				}
			}
		}
	}
}
