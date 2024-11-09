package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class AmountOfThinking {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		while (noOfTestCases != 0) {
			int noOfStudents = Integer.parseInt(br.readLine());
			noOfTestCases--;
			int amountOfThinking = 0;
			List<Integer> marksList = new LinkedList<>();
			String[] input = br.readLine().split(" ");
			Set<Integer> mySet = new HashSet<>();
			for (int i = 0; i < noOfStudents; i++) {
				int elem = Integer.parseInt(input[i]);
				if(mySet.contains(elem)){
					elem++;
					while(mySet.contains(elem)){
						amountOfThinking++;
						elem++;
					}
					mySet.add(elem);
				} else {
					mySet.add(elem);
				}
			}
			/*for (int i = 0; i < noOfStudents; i++) {
				int currElement = marksList.get(i);
				for (int j = i + 1; j < noOfStudents; j++) {
					if (marksList.get(j) == currElement) {
						amountOfThinking++;
						currElement++;
					}
				}
			}*/
			System.out.println(amountOfThinking);

		}
	}
}
