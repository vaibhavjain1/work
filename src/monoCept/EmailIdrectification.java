package monoCept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmailIdrectification {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		while((str = br.readLine()) != null){
			if(str.contains("<")&& str.contains(">"))
				System.out.println(str.substring(str.indexOf("<")+1, str.indexOf(">")));
			else
				System.out.println(str);
		}
	}

}
