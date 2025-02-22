package noUse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Vamsi {

	public static void main(String[] args) {
		int[] in = new int[]{1,2,0,3};
		System.out.println(findEquilibrium(in));
	}

	public static int findEquilibrium(int arr[]) {

		for(int i=1;i<arr.length-1;i++){
			int sum1 = sum(0,i, arr);
			int sum2 = sum(i+1,arr.length, arr);
			if(sum1 == sum2)
				return i;
		}

		return -1;
	}

	static int sum(int start, int end, int arr[]){
		int sum = 0;
		for(int j=start; j<end; j++){
			sum += arr[j];
		}
		return sum;
	}
}
