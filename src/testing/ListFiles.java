package testing;

import java.io.File;

public class ListFiles {

	public static void main(String[] args) {
		File folder = new File("D:\\Froala\\froala_VJ_810\\dist\\html");
		IterateFolder(folder);
	}

	public static void IterateFolder(File folder){
		if(folder.isDirectory()){
			File[] innerFile = folder.listFiles();
			for(File f:innerFile){
				IterateFolder(f);
			}
		} else {
			System.out.println(folder.getName());
		}
	}
}
