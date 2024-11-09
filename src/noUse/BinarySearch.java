package noUse;


public class BinarySearch {
public static void main(String[] args) {
	int[] array = {1,2,3,4,5,6,7,8,9};
	int searchElement = 8;
	int end = array.length;
	int start = 0;
	int mid = (start+end)/2;
	while (array[mid]!=searchElement&&start<=end) {
		if(searchElement<array[mid]){
			end = mid-1;
			mid = (start+end)/2;
		}else{
			start=mid+1;
			mid = (start+end)/2;
		}
	}
	System.out.println(mid);
}
}
