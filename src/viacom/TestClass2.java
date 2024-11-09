package viacom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestClass2 {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases!=0) {
			int palindromeCount = 0;
			String[] input = br.readLine().split(" ");
			String startTime = input[0].charAt(0)+""+input[0].charAt(1)+":"+input[0].charAt(2)+""+input[0].charAt(3);
			String newTime = startTime;
			String endTime = input[1].charAt(0)+""+input[1].charAt(1)+":"+input[1].charAt(2)+""+input[1].charAt(3);
			Date startDate = dateFormatter.parse(startTime);
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate);
			if (checkPalindrome(newTime))
				palindromeCount++;
			while (!newTime.equalsIgnoreCase(endTime)) {
				cal.add(Calendar.MINUTE, 1);
				newTime = dateFormatter.format(cal.getTime());
				if (checkPalindrome(newTime))
					palindromeCount++;
			}
			System.out.println(palindromeCount);
			testCases--;
		}
		
	}

	public static boolean checkPalindrome(String time) {
		if (time.charAt(0) == time.charAt(4)
				&& time.charAt(1) == time.charAt(3))
			return true;
		else
			return false;
	}

}
