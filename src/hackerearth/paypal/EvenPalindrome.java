package hackerearth.paypal;

/*
Even Length Palindromic Number
You have to design a new model which maps an even length palindromic number to some digit between 0 to 9.
The number is mapped to a digit  on the basis of following criteria:
1.  should appear maximum number of times in the palindromic number, that is, among all digits in the number, should appear maximum number of times.
2. If more than one digit appears maximum number of times,  should be the smallest digit among them.

Given an integer , you have to find the digit  for the  even length palindromic number.

Note- First 9 even length palindromic numbers are:

            11, 22, 33, 44, 55, 66, 77, 88, 99

Input :

    First line contains T, number of test cases.

    Each of the next T lines contains an integer N.

Output:

    For each test case, print the digit to which the  even length palindromic number is mapped.
    Answer for each test case should come in a new line.

Constraints:

    

    

Sample Input
3
1
2
10
Sample Output
1
2
0

Explanation
For case 1:

    1st even length palidromic number is 11 , so answer is 1 as 1 appears most number of times in the number.

For case 2:

    2nd even length palidromic number is 22 , so answer is 2 as 2 appears most number of times in the number.

For case 3:

    10th even length palindromic number is 1001, here both 0 and 1 appears same number of times but 0<1 so answer is 0.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EvenPalindrome {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());

		while (noOfTestCases > 0) {
			Map<Integer, Integer> integerMap = new HashMap<Integer, Integer>();
			BigInteger bigInit = new BigInteger(br.readLine());
			while (bigInit.compareTo(new BigInteger("0")) > 0) {
				Integer temp;
				BigInteger divisor = new BigInteger("10");
				int reminder = bigInit.remainder(divisor).intValue();
				if ((temp = integerMap.get(reminder)) == null)
					integerMap.put(reminder, 1);
				else
					integerMap.put(reminder, temp + 1);
				bigInit = bigInit.divide(divisor);
			}
			Set<Entry<Integer, Integer>> itr = integerMap.entrySet();
			int element = -1;
			int maxCount = -1;
			for (Map.Entry<Integer, Integer> val : itr) {

				if (val.getValue() > maxCount) {
					element = val.getKey();
					maxCount = val.getValue();
				} else if (val.getValue() == maxCount) {
					if (val.getKey() < element)
						element = val.getKey();
				}
			}
			System.out.println(maxCount);
			noOfTestCases--;
		}

	}
}