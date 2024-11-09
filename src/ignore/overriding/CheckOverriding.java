package ignore.overriding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Parent{
	public void temp(){
		 
	}
}

class Child extends Parent{
	public void temp(){
		
	}
}

public class CheckOverriding {
	
	class Array {
		int data;
		int noOfones;
		
		Array(int data){
			this.data=data;
			this.noOfones = getBinaryOnes(data);
		}	
	}
	
	public int getBinaryOnes(int num){
		int noOfOnes = 0;
		while(num!=0){
			if(num%2==1)
				noOfOnes++;
			num = num/2;
		}
		return noOfOnes;
	}
	
	public static void main(String[] args) {
		int[] array = { 31, 14, 15, 7, 2};
		CheckOverriding obj = new CheckOverriding();
		List<Array> tempList = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			tempList.add(obj.new Array(array[i]));
		}
		Collections.sort(tempList,new Comparator<Array>() {

			@Override
			public int compare(Array o1, Array o2) {
				if(o1.noOfones<o2.noOfones)
					return 1;
				else if(o1.noOfones>o2.noOfones)
					return -1;
				else if(o1.data<o2.data)
					return 1;
				else if(o1.data>o2.data)
					return -1;
				else
					return 0;
			}
		});
		for (Array array2 : tempList) {
			System.out.println(array2.data);
		}
	}
	
	public static void main2(String[] args) {
		String[] temp = {".B.", ".B."};
		int totalStrok = 0;
		for (int i = 0; i < temp[0].length(); i++) {
			boolean prevPaint = false;
			for (int j = 0; j < temp.length; j++) {
				if(temp[j].charAt(i)=='.' || temp[j].charAt(i)=='R'){
					prevPaint = false;
					continue;
				}else{
					if(temp[j].charAt(i)=='G' || temp[j].charAt(i)=='B'){
						if(!prevPaint){
							prevPaint = true;
							totalStrok++;
						}
					}
				}
			}
		}
		for (int k = 0; k < temp.length; k++) {
			boolean prevPaint = false;
			for (int L = 0; L < temp[0].length(); L++) {
				if(temp[k].charAt(L)=='.' || temp[k].charAt(L)=='B'){
					prevPaint = false;
					continue;
				}else{
					if(temp[k].charAt(L)=='G' || temp[k].charAt(L)=='R'){
						if(!prevPaint){
							prevPaint = true;
							totalStrok++;
						}
					}
				}
			}
		}
		System.out.println(totalStrok);
	}
}
