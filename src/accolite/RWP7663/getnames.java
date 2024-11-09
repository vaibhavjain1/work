package accolite.RWP7663;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

public class getnames {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\vaibhav.jain\\Desktop\\Meta_Old.xml"));
		String s1 =null;
		Set<String> set = new HashSet<String>();
		while ((s1=br1.readLine())!=null) {
			if(s1.contains(" name = ")) {
				String name = s1.substring(s1.indexOf(" name = '")+9, s1.indexOf("'", s1.indexOf(" name = '")+9));
				BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\vaibhav.jain\\Desktop\\Meta_New.xml"));
				String s2 =null;
				boolean there = true;
				while ((s2=br2.readLine())!=null) {
						if(s2.contains(name)) {
							there = false;
							break;
						}
				}
				if(there) {
					set.add(name);
				}
			}
		}
		for (String string : set) {
			System.out.println(string);
		}
	}

}
