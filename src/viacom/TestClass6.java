package viacom;

import java.io.IOException;

public class TestClass6 {

	public static void main(String[] args) throws IOException {
		
		char[] input =  String.valueOf(630).toCharArray();
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			switch (input[i]) {
			case '0':
				count++;
				break;
			case '4':
				count++;
				break;
			case '6':
				count++;
				break;
			case '9':
				count++;
				break;
			case '8':
				count = count+2;
				break;
			default:
				break;
			}
		}
		System.out.println(count);
	}

}
