/**
 * Written by Hemraj Rana
 * Student ID: M23W7252
 */
package algo.sort;

import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {
	public static int[] bubbleSort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[i] > nums[j]) { // swap
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
		}

		return nums;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter numbers (use 'x' to stop): ");
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		while(true) {
			String temp = scan.next();
			if(temp.equalsIgnoreCase("x")) break;
			
			try {
				int num = Integer.valueOf(temp);
				array.add(num);
			} catch(Error e) {
				System.out.println("Enter a number or 'x' to stop.");
			}
		}
		
		int[] nums = new int[array.size()];
		
		for(int i = 0; i < array.size(); i++) {
			nums[i] = array.get(i);
		}
		
		int[] sortedNums = bubbleSort(nums);
		
		for(int i = 0; i < sortedNums.length; i++) {
			System.out.printf("%d ", sortedNums[i]);
		}
		
		scan.close();
	}
}
