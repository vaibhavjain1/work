package fileOperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
 
public class ChannelTransferExample
{
    public static void main(String[] argv) throws IOException
    {
    	File sourceFile = new File("D:/source.txt");
    	File destFile = new File("D:/dest.txt");
    	
    	FileChannel sourceChannel = null;
		FileChannel destChannel = null;

		try 
		{
			sourceChannel = new FileInputStream(sourceFile).getChannel();
			destChannel = new FileOutputStream(destFile).getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(), destChannel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally 
		{
			if (sourceChannel != null) 
				sourceChannel.close();
			if (destChannel != null)
				destChannel.close();
		}
    }
}