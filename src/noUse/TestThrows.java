package noUse;

public class TestThrows {

	public static void main(String[] args) {
		String str = "parentstringntst sdfdfs sfdsf ntst";
		String substr = "ntst";

		if(str == null || substr == null)
			return;
		
		if(str.length() < substr.length())
			return;
		
		char[] strArray = str.toCharArray();
		char[] substrArray = substr.toCharArray();
		
		checkSubstring(str, strArray, substrArray);
	}

	public static void checkSubstring(String str, char[] strArray, char[] substrArray) {
		for (int i = 0; i < strArray.length; i++) {
			// if first letter matching
			if (strArray[i] == substrArray[0]) {
				int endIndex = i + substrArray.length;
				// if reached end
				if (endIndex > strArray.length)
					return;
				if (str.substring(i, endIndex).equals(String.valueOf(substrArray)))
					System.out.println(i + " " + endIndex);
			}
		}
	}
}
