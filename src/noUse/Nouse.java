package noUse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Nouse {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(new File("D:/Workspace/Workspace/javaprojects/Anvizo/WebContent/WEB-INF/cgi/amd64-windows/php.ini")));
		String str = null;
		while((str = br.readLine())!=null) {
			if(!str.startsWith(";") && !str.isEmpty())
			System.out.println(str);
		}
	}
}
