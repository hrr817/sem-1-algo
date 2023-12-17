/**
 * Written By Hemraj Rana
 * Student ID: M23W7252
 */
package algo.sort;

import java.util.ArrayList;

public class MinBinaryHeap {
	private ArrayList<String> list = new ArrayList<String>();
	
	private boolean compare(String a, String b) {
		try {
			int x = Integer.parseInt(a),
				y = Integer.parseInt(b);
			
			return x > y;
		} catch(Exception e) {
			return a.charAt(0) > b.charAt(0);
		}
	}

	public ArrayList<String> get() {
		return list;
	}
	
	public int size() {
		return list.size();
	}
	
	public void insert(String s) {
		list.add(s);

		int index = list.size() - 1; // index of current added element
		// let's move new element to right place
		// check if it is less than its parent
		// parent index, if index is even = i/2 - 1 else floored value of i/2
		// if less than parent swap, repeat
		int parentIndex = index % 2 == 0 ? (index / 2) - 1 : index / 2;
		if(parentIndex >= 0) {
			String parentElement = list.get(parentIndex);
			while(compare(parentElement, s)) { //  if parentElement is greater than curr, keep swaping until right position		
				list.set(index, parentElement); // move parent char below
				list.set(parentIndex, s);
				index = parentIndex;
				parentIndex = index % 2 == 0 ? (index / 2) - 1 : index / 2;
				
				if(parentIndex < 0) break;
				parentElement = list.get(parentIndex);
			}
		}
	}
	
	public String top() {
		String topElementM23W7252 = list.get(0);
		
		String currElement = list.get(list.size() - 1); // take last element
		list.set(0, currElement); // set it at top
		list.remove(list.size() - 1); // remove last element from list
		
		int currentIndex = 0;
		int leftChildIndex = (currentIndex * 2) + 1,
			rightChildIndex = (currentIndex * 2) + 2;
		
		int smallestChildIndex = leftChildIndex;
		
		if(rightChildIndex < list.size()) {
			smallestChildIndex = compare(list.get(leftChildIndex), list.get(rightChildIndex)) ? rightChildIndex : leftChildIndex;
		}

		// move element to the right place
		while(smallestChildIndex < list.size()) {
			String childElement = list.get(smallestChildIndex);
				
			if(compare(childElement, currElement)) break; // it is in right place, break
			
			list.set(currentIndex, childElement); // move child element to current index 
			list.set(smallestChildIndex, currElement);
			currentIndex = smallestChildIndex;

			leftChildIndex = (currentIndex * 2) + 1;
			rightChildIndex = (currentIndex * 2) + 2;
					
			smallestChildIndex = leftChildIndex;
					
			if(rightChildIndex < list.size()) {
				smallestChildIndex = compare(list.get(leftChildIndex), list.get(rightChildIndex)) ? rightChildIndex : leftChildIndex; 
			}
		}
		
		return topElementM23W7252;
	}
}
