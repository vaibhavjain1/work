package noUse;


public class MergeSort {

	int inputArray[];
	int tempMergArr[] = new int[10];
	
	public static void main(String[] args) {
		
		int inputArray[]= {45,23,11,89,77,98,4,28,65,43};
	
		MergeSort obj = new MergeSort();
		obj.inputArray = inputArray;
		obj.doDivide(0,inputArray.length-1);
		for (int i : obj.inputArray) {
			System.out.println(i+" ");
		}
	}
	
	public void doDivide(int lower, int heigher){
		if(lower<heigher){
			int middle = (lower+heigher)/2;
			doDivide(lower, middle);
			doDivide(middle+1, heigher);
			merger(lower,middle,heigher);
		}
	}
	
	public void merger(int lower,int middle, int heigher){
		for (int i = lower; i <= heigher; i++) {
            tempMergArr[i] = inputArray[i];
        }
        int i = lower;
        int j = middle + 1;
        int k = lower;
        while (i <= middle && j <= heigher) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                inputArray[k] = tempMergArr[i];
                i++;
            } else {
                inputArray[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            inputArray[k] = tempMergArr[i];
            k++;
            i++;
        }
       
    }

}
