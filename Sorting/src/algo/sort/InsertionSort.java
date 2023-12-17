package algo.sort;

public class InsertionSort {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// keep swaping if previous element is larger than current
	public static int[] insertionSort(int[] nums) {
		for(int i = 0; i < nums.length - 1; i++) {
			int j = i + 1;

			if(nums[j] < nums[i]) {
				swap(nums, i, j);

				int curr = i;
				while(curr > 0 && nums[curr - 1] > nums[curr]) {
					swap(nums, curr, curr - 1);
					curr--;
				}
			}
		}
		
		return nums;
	}
	
	// move all elements to right by one and place num at left (space made for it)
	public static int[] insertionSort2(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			int j = i - 1, element = nums[i];
			
			while(j > -1 && element > nums[j]) {
				nums[j + 1] = nums[j--];
			}
			nums[j + 1] = element;
		}

		return nums;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 1, -3, -1, 2, 100, -20, -30, 35};
		
		arr = insertionSort(arr);
		
		for(int i : arr) {
			System.out.printf("%d ", i);
		}
	}
}
