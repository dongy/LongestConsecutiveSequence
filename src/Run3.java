
// hashmap

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;
//import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

public class Run3 {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
		//Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(10, 10);
		map.put(4, 4);
		map.put(20, 20);
		map.put(1, 1);
		map.put(2, 2);
		map.put(8, 8);
		map.put(9, 9);
		map.put(3, 3);
		map.put(19, 19);
		map.put(18, 18);
		map.put(17, 17);
		map.put(21, 21);
		map.put(22, 22);
		map.put(5, 5);
		map.put(-1, -1);
		map.put(-3, -3);
		map.put(-2, -2);
		
		List<Integer> curr = new ArrayList<>();
		List<Integer> longest = new ArrayList<>();
		
		// [10, 4, 20, 1, 2, 8, 9, 3, 19]
		/*List<Integer> key = new ArrayList<>();
		key.add(10);
		key.add(4);
		key.add(20);
		key.add(1);
		key.add(2);
		key.add(8);
		key.add(9);
		key.add(3);
		key.add(19);
		key.add(5);
		key.add(18);
		key.add(17);
		key.add(21);
		key.add(22);*/
		
		// for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			// System.out.println("value=" + entry.getValue());
			//System.out.println("map=" + map);
		// }
		System.out.println("map=" + map);
		
		// iterate map
		//Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
		int mapSize = map.size();
		for(int i=0; i<=map.size(); i++) {
		//while ( iter.hasNext() ) {
			System.out.println("map.size()=" + map.size());
			System.out.println("i=" + i);
			//Map.Entry<Integer, Integer> entry = iter.next();
			// always the first value
			Map.Entry<Integer,Integer> entry = map.entrySet().iterator().next();
			int first = entry.getValue();
			System.out.println("first=" + first);
			curr.add(first);
			System.out.println("curr=" + curr);
			map.remove(first);
			//iter.remove();
			System.out.println("map1=" + map);
			int small = first-1;
			int big = first+1;
				
			for(int j=0; j<mapSize; j++) {		
				System.out.println("j=" + j);
				// if map has a key == first-1 
				if( map.containsKey(small) ) {
					curr.add(small);
					System.out.println("curr=" + curr);
					System.out.println("small=" + small);
					map.remove(small);
					System.out.println("map2=" + map);
					small = small-1;
				}
				// if map has a key == first+1
				if( map.containsKey(big) ) {
					curr.add(big);
					System.out.println("curr=" + curr);
					System.out.println("big=" + big);
					map.remove(big);
					System.out.println("map3=" + map);
					big = big+1;
				}
			}
			if( curr.size() > longest.size()) {
				longest = new ArrayList<>(curr);
				System.out.println("longest=" + longest);
			}
			curr.clear();
		}	
		
		System.out.println("longest1=" + longest);
		// longest.forEach(System.out::println);		
	}

}
