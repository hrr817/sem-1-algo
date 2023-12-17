/**
 * Written By Hemraj Rana
 * Student ID: M23W7252
 */
package algo.sort;

public class MinHeapSort {

	public static void main(String[] args) {
		MinBinaryHeap minHeap = new MinBinaryHeap();
		
		minHeap.insert("9");
		minHeap.insert("B");
		minHeap.insert("10");
		minHeap.insert("8");
		minHeap.insert("C");
		minHeap.insert("11");
		minHeap.insert("A");
		minHeap.insert("20");
		minHeap.insert("-10");
		minHeap.insert("D");
		minHeap.insert("80");
		minHeap.insert("75");
		minHeap.insert("-100");
		minHeap.insert("1");
		minHeap.insert("F");
		minHeap.insert("E");

		System.out.println("Unsorted: ");
		for(String c : minHeap.get()) {
			System.out.printf("%s, ", c);
		}
		
		System.out.println("\nSorted: ");
		int size = minHeap.size();
		for(int i = 0; i < size; i++) {
			System.out.printf("%s, ", minHeap.top());
		}
		
		System.out.println();
		
	}
}
