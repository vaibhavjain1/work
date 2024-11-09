package noUse;

import java.util.Arrays;


public class Quicksort {
	int[] array;

 public static void main(String[] args) {
	
	Quicksort sort = new Quicksort();
	int[] inputArray = {6,2,1,9,4,8,3,7};
	sort.array = inputArray;
	sort.quickSortAlgo(0, sort.array.length-1);
	System.out.println("Sorted array :" + Arrays.toString(sort.array));
}
 
 public void quickSortAlgo(int low, int high) { 
	 int i = low; int j = high; // pivot is middle index 
 
	 int pivot = array[low + (high - low) / 2]; // Divide into two arrays
 
	while (i <= j) {
	 /** * As shown in above image, In each iteration, we will identify a * number from left side which is greater then the pivot value, and * a number from right side which is less then the pivot value. Once * search is complete, we can swap both numbers. */
	 while (array[i] < pivot) { i++; }
	 while (array[j] > pivot) { j--; }
	 if (i <= j)
	 { swap(i, j); // move index to next position on both sides 
	 i++; j--; } } // calls quickSort() method recursively
 if (low < j) { 
	 quickSortAlgo(low, j);
	 }
 if (i < high) { 
	 quickSortAlgo(i, high);
	 }
 
 } 
	 
 
 
 private void swap(int i, int j) { int temp = array[i]; array[i] = array[j]; array[j] = temp; }

 
 
}
