package testing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class FroalaUiChanges {

	public static void main1(String[] args) throws Exception{
		File input = new File("D:/def.txt");
		File output = new File("D:/ghi.txt");
		BufferedReader br = new BufferedReader(new FileReader(input));
		BufferedWriter bw = new BufferedWriter(new FileWriter(output));
		String str = null;
		while((str = br.readLine())!=""){
			String[] str1 = str.split(",");
			bw.write("'"+str1[0]+"': {\n");
			if(str1.length==2)
			bw.write("SVG_KEY: '"+str1[1]+"'");
			bw.write("\n},\n");
			bw.flush();
		}
		bw.close();
	}
	public static void main(String[] args) throws Exception {
		BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
		br.write("import FE from '../../js/editor.js'\n\n");
		br.write("FE.SVG = {\n");
		File svgFolder = new File("D:/Froala/froala_VJ_862/src/assets/svgs");
		File[] listofsvg = svgFolder.listFiles(new FileFilter() { 
			@Override
			public boolean accept(File pathname) {
				if(pathname.getName().endsWith(".svg"))
					return true;
				return false;
			}
		});
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		 
		boolean temp = false;
		for (File currFile : listofsvg) {
			if(temp){
				br.write(",\n\n");
			} else {
				temp = true;
			}
			br.write("    '"+currFile.getName().substring(0, currFile.getName().lastIndexOf(".svg"))+"': `");
			Document doc = dBuilder.parse(currFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("path");
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				Element eElement = (Element) nNode;
				br.write("<path d=\""+eElement.getAttribute("d")+"\"/>`");
			}
		}
		br.write("\n}");
		br.close();
	}
}