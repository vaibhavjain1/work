package accolite;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

public class BlockingFileTransfer {

	public static void main(String[] args) throws Exception{
		File f = new File("E:/Data/Movies/Andhadhun 2018 Hindi 720p WEB-DL x264 ESub [MW]/a.jpg");
		InputStream fileContent = new FileInputStream(f);
		System.out.println("Starting copy");
		FileUtils.copyInputStreamToFile(fileContent, new File("D:/a.jpg"));
		System.out.println("copied");
	}
}
