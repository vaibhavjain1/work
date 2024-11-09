package accolite;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class Downloadlinks {

	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			try {
				FileUtils.copyURLToFile(new URL(args[i]), new File("D:\\Eduthrill\\photos\\"+i+".jpeg"));
			} catch (Exception e) {
				System.out.println("Error while downloading:"+ args[i]);
			}
		}
	}
}

