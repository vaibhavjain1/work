package noUse;

import java.util.Map;
import java.util.TreeMap;

class Bike4 {
	public static void main(String[] args) {
		      System.out.println("output for : \"aabb\" " + getMaxFreqDeviation("aabb")); //0
		      System.out.println("output for : \"bbacccc\" " + getMaxFreqDeviation("bbacccc")); // 3
	     	  System.out.println("output for : \"aaccccddd\" " +getMaxFreqDeviation("aaccccddd")); // 1
			  System.out.println("output for : \"nvbbsllsiel\" " +  getMaxFreqDeviation("nvbbsllsiel")); // 1
			  System.out.println("output for : \"bbacccabab\" " +  getMaxFreqDeviation("bbacccabab")); // 2
			  System.out.println("output for : \"cccaabbccc\" " +  getMaxFreqDeviation("cccaabbccc")); // 1
			  System.out.println("output for : \"acbbc\" " + getMaxFreqDeviation("acbbc"));  // 1
	}

	public static int getMaxFreqDeviation(String s) {
		System.out.println("Testcase: " + s);
		char[] array = s.toCharArray();
		TreeMap<Character, Integer> map = new TreeMap<>();
		for (int i = 0; i < array.length; i++) {
			char c = array[i];
			int currCount = 1;
			int temp = i;
			// If next element is same
			while (temp < array.length - 1) {
				if (c == array[temp + 1]) {
					currCount++;
					temp++;
				} else
					break;
			}
			if (map.containsKey(c)) {
				if (map.get(c) < currCount)
					map.put(c, currCount);
			} else {
				map.put(c, currCount);
			}

		}

		int largevalue = map.get(map.firstKey());
		int smallvalue = map.get(map.firstKey());
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue()> largevalue)
				largevalue = entry.getValue();
			if(entry.getValue()< smallvalue)
				smallvalue = entry.getValue();
		}

		return Math.abs(largevalue - smallvalue);
	}
}