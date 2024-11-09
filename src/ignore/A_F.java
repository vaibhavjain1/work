package ignore;

import java.io.BufferedReader;
import java.io.FileReader;

public class A_F {

	public static void main(String[] args) throws Exception{
		BufferedReader br  =  new BufferedReader(new FileReader("C:\\Users\\Vaibhav\\Desktop\\A_F.txt"));
		String str = null;
		while ((str = br.readLine())!=null) {
					System.out.println(str.substring(39).replaceAll("</a>", ""));
				}
			}
		
}
