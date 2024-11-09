package noUse;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckJavaFile {

	/**
	 * @param args
	 */
	final static String folderlocation = "C:/Users/Vaibhav/Desktop/documents-export-2016-01-26";
	static int count;
	
	public static void main(String[] args) {
		ListFiles(folderlocation);
		System.out.println("No of files scanned : "+count);
	}

	public static void ListFiles(String folderlocation){
		HashMap<Boolean, String>resultMap=null;
		File folder = new File(folderlocation);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()&&listOfFiles[i].getName().endsWith(".java")) {
		    	  resultMap = checkResultSet(listOfFiles[i].getAbsolutePath());
		    	  if(resultMap.get(false)!=null)
		    		  System.out.println("File : "+listOfFiles[i].getAbsolutePath()+" "+resultMap.get(false));
		        count++;
		      } else if (listOfFiles[i].isDirectory()) {
		        ListFiles(listOfFiles[i].getAbsolutePath());
		      }
		    }
	
	}
	
	
	public static HashMap<Boolean, String> checkResultSet(String Filename){
		HashMap<Boolean, String> resultFlag = new HashMap<Boolean,String>();
		ArrayList<String> result = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(Filename)));
			Pattern patt = Pattern.compile("(ResultSet\\s([A-z])\\w+)");
			Pattern badpatt = Pattern.compile("(ResultSet\\s([A-z])\\w+,)");
			Pattern skippatt = Pattern.compile("[/|*](ResultSet\\s([A-z])\\w+)");
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				for (String string : result) {
					if(sCurrentLine.contains(string+".close()")){
						result.remove(string);
						break;
					}
				}
				
				Matcher bad = badpatt.matcher(sCurrentLine);
				if(bad.find()){
					resultFlag.put(false, "Check file by yourself");
					return resultFlag;
				}
				
				Matcher m = patt.matcher(sCurrentLine);
				
				while (m.find()) {
			        int start = m.start(0)+10;
			        int end = m.end(0);
			        result.add(sCurrentLine.substring(start, end));
			        Matcher skip = skippatt.matcher(sCurrentLine);
					if(skip.find()){
						result.remove(sCurrentLine.substring(start, end));
					}
			      }
				
				
 			}
			if(result.isEmpty()){
				resultFlag.put(true, "All ResultSet Closed");
			} else {
				String notclosedresultset = "";
				for (String string : result) {
					notclosedresultset+=string+" ";
				}
				resultFlag.put(false, "Not Closed : "+notclosedresultset);
			}
				
		} catch (FileNotFoundException e) {
			resultFlag.put(false, "File not found Exception");
		} catch (IOException e) {
			resultFlag.put(false, "IO Exception");
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				
			}
		}
		return resultFlag;
	}
}
