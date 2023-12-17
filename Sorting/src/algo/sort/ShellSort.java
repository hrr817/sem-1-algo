/**
 * Written by Rana Hemraj
 * Student ID: M23W7252
 * Dated: 12/09/2023
 */
package algo.sort;

public class ShellSort {
	public static int[] insertionSort(int[] arr, int start, int end) {
		for(int i = start + 1; i < end; i++) {
			int j = i - 1, elem = arr[i];
			while(elem < arr[j] && j >= start) {
				arr[j + 1] = arr[j--];
			}
			arr[j + 1] = elem;
		}
		
		return arr;
	}
	
	public static void displayNumbers(String msg, int[] nums) {
		System.out.println(msg);
		for(int i : nums) {
			System.out.printf("%d ", i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr1 = { -10, 2, 200, -34, 12, 30, 4, 2, 3, 20, 100, 2934, 234, -2134, 2340, 304, -43 };
		int[] arr2 = { 3, 4, 1, -2, 34, 200, -44, 939, 19, -44 };
		int[] arr3 = { 23, 84, 99, -20202, 8383, -34, 123, -2,  -3, -2, 12, 44 };
		
		int size1 = arr1.length;
		int size2 = arr2.length;
		int size3 = arr3.length;
		
		

		int[] sortedWithKnuth = {}, sortedWithHibbard = {}, sortedWithSedgewick = {};
		
		System.out.println("arr1:\n");
		
		// Knuth interval h = (3^k - 1) / 2
		int h = 1;
		while(h < size1) h = 3 * h + 1;
		
		for (int gap = h; gap > 0; gap /= 3) {
			sortedWithKnuth = insertionSort(arr1, gap, size1);
	    }

		displayNumbers("Sorted with Knuth's interval", sortedWithKnuth);
		
		// Hibbard's interval = 2^k - 1
		h = 1; // set it back to 1
	    while (h < size1) h = 2 * h + 1;
		for (int gap = h; gap > 0; gap /= 2) {
			// insertion sort on subset
			sortedWithHibbard = insertionSort(arr1, gap, size1);
	    }
		
		displayNumbers("Sorted with Hibbard's interval", sortedWithHibbard);

		// Sedgewick's interval = 4^k + 3 * 2^(k-1) + 1
		h = 1;
		while (h < size1 / 3) h = (4 * h) + 3 * (2 * h + 1);
		
		for (int gap = h; gap > 0; gap /= 3) {
			sortedWithSedgewick = insertionSort(arr1, gap, size1);
	    }

		displayNumbers("Sorted with Sedgewick's interval", sortedWithSedgewick);
		
		System.out.println("\narr2:\n");
		
		while(h < size2) h = 3 * h + 1;
		
		for (int gap = h; gap > 0; gap /= 3) {
			sortedWithKnuth = insertionSort(arr2, gap, size2);
	    }

		displayNumbers("Sorted with Knuth's interval", sortedWithKnuth);
		
		// Hibbard's interval = 2^k - 1
		h = 1; // set it back to 1
	    while (h < size2) h = 2 * h + 1;
		for (int gap = h; gap > 0; gap /= 2) {
			// insertion sort on subset
			sortedWithHibbard = insertionSort(arr2, gap, size2);
	    }
		
		displayNumbers("Sorted with Hibbard's interval", sortedWithHibbard);

		// Sedgewick's interval = 4^k + 3 * 2^(k-1) + 1
		h = 1;
		while (h < size2 / 3) h = (4 * h) + 3 * (2 * h + 1);
		
		for (int gap = h; gap > 0; gap /= 3) {
			sortedWithSedgewick = insertionSort(arr2, gap, size2);
	    }

		displayNumbers("Sorted with Sedgewick's interval", sortedWithSedgewick);
		
		System.out.println("\narr3:\n");
		
		while(h < size3) h = 3 * h + 1;
		
		for (int gap = h; gap > 0; gap /= 3) {
			sortedWithKnuth = insertionSort(arr3, gap, size3);
	    }

		displayNumbers("Sorted with Knuth's interval", sortedWithKnuth);
		
		// Hibbard's interval = 2^k - 1
		h = 1; // set it back to 1
	    while (h < size3) h = 2 * h + 1;
		for (int gap = h; gap > 0; gap /= 2) {
			// insertion sort on subset
			sortedWithHibbard = insertionSort(arr3, gap, size3);
	    }
		
		displayNumbers("Sorted with Hibbard's interval", sortedWithHibbard);

		// Sedgewick's interval = 4^k + 3 * 2^(k-1) + 1
		h = 1;
		while (h < size3 / 3) h = (4 * h) + 3 * (2 * h + 1);
		
		for (int gap = h; gap > 0; gap /= 3) {
			sortedWithSedgewick = insertionSort(arr3, gap, size3);
	    }

		displayNumbers("Sorted with Sedgewick's interval", sortedWithSedgewick);
	}
}
