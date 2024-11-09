package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

public class StringQuery {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tempInput = br.readLine().split(" ");
		int numberOfCharacters = Integer.parseInt(tempInput[0]);
		int numberOfQueries = Integer.parseInt(tempInput[1]);
		char[] input = br.readLine().toCharArray();
		while (numberOfQueries > 0) {
			Map<Character, Integer> myMap = new HashMap<>();
			String[] tempInput1 = br.readLine().split(" ");
			int start = Integer.parseInt(tempInput1[0])-1;
			int end = Integer.parseInt(tempInput1[1])-1;
			for (int i = start; i <= end; i++) {
				if (myMap.containsKey(input[i])) {
					myMap.put(input[i], myMap.get(input[i]) + 1);
				} else {
					myMap.put(input[i], 1);
				}
			}
			Set<Entry<Character, Integer>> mySetItr = myMap.entrySet();
			int min = 0;
			for (Entry<Character, Integer> entry : mySetItr) {
				if (min == 0)
					min = entry.getValue();
				else if (entry.getValue() < min)
					min = entry.getValue();
			}
			int noOfQueries = 0;
			for (Entry<Character, Integer> entry : mySetItr) {
				noOfQueries += entry.getValue() - min;
			}
			System.out.println(noOfQueries);
			numberOfQueries--;
		}
	}
}
