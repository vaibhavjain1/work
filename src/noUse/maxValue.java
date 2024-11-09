package noUse;

public class maxValue {

	public static void main(String[] args) {
		int[] arr = {8,1,9,4};
		int max = Math.abs(0-1)*(arr[0]<arr[1]?arr[0]:arr[1]);
		
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				int temp = Math.abs(i-j)*(arr[i]<arr[j]?arr[i]:arr[j]);
				if(temp>max)
					max= temp;
			}
		}
		System.out.println(max);
	}
	
}
