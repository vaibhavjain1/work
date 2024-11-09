package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

class SpecialSubset {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		while (noOfTestCases>0) {
			int value = Integer.parseInt(br.readLine());
			Set<Integer> currSet = getPowersOf2(value);
			for (int i = value + 1; i < 1000000; i++) {
				if (getPowersOf2(i).containsAll(currSet)) {
					System.out.println(i);
					break;
				}
			}
			noOfTestCases--;
		}
		
	}

	public static Set<Integer> getPowersOf2(int number) {
		Set<Integer> powerSet = new LinkedHashSet<>();
		while (number != 0) {
			int temp = getMaxPowerOf2(number);
			powerSet.add(temp);
			number = (int) (number - Math.pow(2, temp));
		}
		return powerSet;
	}

	public static int getMaxPowerOf2(int number) {
		int i = 0;
		while (Math.pow(2, i)<=number) {
			i++;
		}
		return i - 1 > 0 ? i - 1 : 0;
	}
}