
// arraylist

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Understanding the problem
Problem Description: Given an unsorted array A[] consisting of n integers, you need to 
find the length of the longest consecutive sequence of integers in the array.

Example 1

Input: A[] = [10, 4, 20, 1, 2, 8, 9, 3, 19]
Output: 4 
Explanation: The longest consecutive sequence of integers in the array is 1,2,3 and 4
Example 2

Input: A[] = [0, -2, 3, -1, 2, 1]
Output: 6
Explanation: The longest consecutive sequence of integers in the array is -2,-1,0,1,2, and 3.
*/

public class Run2 {

	public static void main(String[] args) {
		// A[] = [10, 4, 20, 1, 2, 8, 9, 3, 19]
		List<Integer> a = new ArrayList<>();
		a.add(10);
		a.add(4);
		a.add(20);
		a.add(1);
		a.add(2);
		a.add(8);
		a.add(9);
		a.add(3);
		a.add(19);
		a.add(21);
		a.add(22);
		a.add(23);
		a.add(24);
		a.add(25);
		a.add(27);
		a.add(29);
		a.add(5);
		a.add(5);
		a.add(0);
		
		/*a.add(0);
		a.add(-2);
		a.add(3);
		a.add(-1);
		a.add(2);
		a.add(1);*/
		System.out.println("original list a=" + a);
		
		// sort list a from min to max
		for(int i=0; i<a.size()-1; i++) {
			System.out.println("list i=" + i);
			for(int j=0; j<a.size()-1-i; j++) {
				System.out.println("list j=" + j);
				if(a.get(j) > a.get(j+1)) {
					int tmp = a.get(j);
					a.set(j, a.get(j+1));
					a.set(j+1, tmp);
				}
				//System.out.println("list a=" + a);
			}
		}
		System.out.println("list a=" + a);
		
		// find the lengest consecutive sequence
		List<Integer> tmp2 = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		int key=1;
		
		tmp2.add(a.get(0));
		for(int k=0; k<a.size()-1;k++) {
			if( (a.get(k+1) - a.get(k)) == 1 || (a.get(k+1) - a.get(k)) == 0 ) {
				tmp2.add(a.get(k+1));
				map.put(key, tmp2);
			}else {
				System.out.println("before tmp list cleanup tmp2=" + tmp2);
				// tmp2.clear(); should not clear it. I should create a new list
				tmp2 = new ArrayList<>();
				tmp2.add(a.get(k+1));
				key++;			
				map.put(key, tmp2);
			}
		}		
		
		// iterate the map
		for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			System.out.println("key=" + entry.getKey() + " value=" + entry.getValue());
		}
		
		int totalKeys = key; // key starts from 1
		int keyHasMaxLength = 1; // give the first key
		int firstMaxLength = map.get(keyHasMaxLength).size();
		for(int l=1; l<totalKeys; l++) {
			System.out.println("map.get(l).size()=" + map.get(l).size());
			if( map.get(l).size() > firstMaxLength ) {
				keyHasMaxLength = l;
				firstMaxLength = map.get(l).size();
			}
		}
		System.out.println("KeyHasMaxLength=" + keyHasMaxLength);
		System.out.println("value=" + map.get(keyHasMaxLength));
	}
	
}
