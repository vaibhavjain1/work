package noUse;

import java.io.IOException;


public class CreateZip {

	 public static void main(String[] args) throws IOException {
		 CreateZip obj = new CreateZip();
		 int[] myIntArray = {1,2,3,4,5};
		 int[] sumDifferenceArray = new int[myIntArray.length-1];
		 for (int i = 0; i < myIntArray.length-1; i++) {
			sumDifferenceArray[i] = obj.getDiference(myIntArray[i], myIntArray[i+1]);
		}
		 System.out.println(obj.getSumDiference(sumDifferenceArray));
		}
	 public int getDiference(int num1, int num2){

		    return num2-num1;

		    }



		     public int getSumDiference(int[] numbers){
				int totalSum = 0;
				for (int i = 0; i < numbers.length; i++) {
					totalSum+=numbers[i];
				}
				return totalSum;
		     }
}
