/**
 * Written By Hemraj Rana
 * Student ID: M23W7252
 */
package algo.sort;

public class MaxHeapSort {
	public static void main(String[] args) {
		MaxBinaryHeap maxHeap = new MaxBinaryHeap();
		
		maxHeap.insert("100");
		maxHeap.insert("-1000");
		maxHeap.insert("Z");
		maxHeap.insert("E");
		maxHeap.insert("C");
		maxHeap.insert("25");
		maxHeap.insert("45");
		maxHeap.insert("123");
		maxHeap.insert("-55");
		maxHeap.insert("F");
		maxHeap.insert("60");
		maxHeap.insert("G");
		maxHeap.insert("K");
		maxHeap.insert("1");
		maxHeap.insert("F");
		maxHeap.insert("E");

		System.out.println("Unsorted: ");
		for(String c : maxHeap.get()) {
			System.out.printf("%s, ", c);
		}
		
		// we get highest element from the max binary heap when calling top()
		// so let's store it in array in reverse order, so it is sorted
		int size = maxHeap.size();
		String[] elements = new String[size];
		for(int i = size - 1; i > -1; i--) {
			elements[i] = maxHeap.top();
		}
		

		System.out.println("\nSorted: ");
		for(String s : elements) {
			System.out.printf("%s, ", s);
		}
	}
}
