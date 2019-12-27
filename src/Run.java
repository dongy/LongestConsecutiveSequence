import java.util.ArrayList;
import java.util.List;

public class Run {

	// longest consecutive sequence that is <= 5
	public static void main(String[] args) {
		
		List<Integer> startDate = new ArrayList<>();
		List<Integer> endDate = new ArrayList<>();
		
		List<Integer> value = new ArrayList<>();
		value.add(7);
		value.add(12);
		value.add(5);
		value.add(3);
		value.add(11);
		value.add(6);
		value.add(10);
		value.add(2);
		value.add(9);
		
		List<Integer> temp = new ArrayList<>();
		
		// start from 0, get each list of min/max value
		for (int i=0; i < value.size(); i++) {
			System.out.println("i=" + i);
			for(int j=i; j < value.size(); j++) {
				System.out.println("j=" + j);
				// find min and max in each round. array[i,j]
				if (j>i) {
					temp = new ArrayList<>(value.subList(i, j+1));
				}else {		
					temp.add(value.get(i));
				}			
				System.out.println("temp=" + temp);
				int min = returnMin(temp);
				int max = returnMax(temp);
				if((max - min) > 5) {
					temp.clear();
					break;
				}else {
					// record i and j
					System.out.println("add");
					startDate.add(i);
					endDate.add(j);
				}
			}
		}
		
		System.out.println(startDate);
		System.out.println(endDate);
		List<Integer> inteval = new ArrayList<>();
		for(int i=0; i<startDate.size();i++) {
			inteval.add(endDate.get(i)-startDate.get(i));
		}
		int maxInteval = returnMaxIndex(inteval);
		System.out.println("maxInteval=" + maxInteval);
		System.out.println("startDate=" + startDate.get(maxInteval));
		System.out.println("endDate=" + endDate.get(maxInteval));
	}

	private static int returnMin(List<Integer> temp) {
		int min = temp.get(0);
		for(int i = 0; i < temp.size(); i++) {
			if(temp.get(i) < min) {
				min = temp.get(i);
			}
		}
		System.out.println("min=" + min);
		return min;
	}

	private static int returnMax(List<Integer> temp) {
		int max = temp.get(0);
		for(int i = 0; i < temp.size(); i++) {
			if(temp.get(i) > max) {
				max = temp.get(i);
			}
		}
		System.out.println("max=" + max);
		return max;
	}
	
	private static int returnMaxIndex(List<Integer> temp) {
		int max = temp.get(0);
		int index = 0;
		for(int i = 0; i < temp.size(); i++) {
			if(temp.get(i) > max) {
				max = temp.get(i);
				index = i;
			}
		}
		System.out.println("max index=" + index);
		return index;
	}
}
