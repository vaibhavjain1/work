package noUse;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MahadevEpisodeDownloader {

	public static void main(String[] args) {
		String folderPath = "C:\\Users\\Vaibhav\\Downloads\\DKDMD\\";
		String filePath = "http://media.startv.in/newstream/star/lifeok/mahadev/";
		for (int i = 1; i < 821; i++) {
			File f = new File(folderPath+i+".mp4");
			File check = new File(folderPath+i+"_done.mp4");
			if(!check.exists())
			{	
				URL file = null;
				try {
					file = new URL(filePath+i+"/lf_300.mp4");
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					System.out.println("copying episode : "+i);
					//FileUtils.copyURLToFile(file, f);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				f.renameTo(new File(folderPath+i+"_done.mp4"));
			}
		}
	}

}
