package accolite;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

public class UnicodeCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println(args[0]);
		File f = new File(args[0]);
		System.out.println(f.exists());*/
		//System.out.println("-Dhello".startsWith("-d"));
		System.out.println(StringUtils.isAlphanumeric("a_10"));
		System.out.println("sdfds".endsWith("."));
	}

}
