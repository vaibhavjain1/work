package accolite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class ArtifactoryExtraction {

	public static void main(String[] args) throws Exception {
			List<String> list = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader("D:\\insight\\setup\\Full_Build_log.txt"));
			String str = null;
			while ((str = br.readLine()) != null) {
				if (str.startsWith("Downloaded from central: ")) {
					list.add(str.substring(str.indexOf(": ") + 2, str.length()));
				}
			}
			Collections.sort(list);
			for (String string : list) {
				String jar_pom_link = string.substring(0, string.indexOf("(") - 1);
				if (jar_pom_link.endsWith(".pom")) {
					URL url = new URL(jar_pom_link);
					BufferedReader br1 = new BufferedReader(new InputStreamReader(url.openStream()));
					String str1 = null;
					String fileName = jar_pom_link.substring(jar_pom_link.lastIndexOf("/") + 1, jar_pom_link.indexOf(".pom"));
					String groupId = null;
					String artifactId = null;
					String version = null;
					String versionParent = null;
					boolean parent = false;
					try {
						while ((str1 = br1.readLine()) != null) {
							if (str1.contains("<parent>")) {
								parent = true;
							}
							if (str1.contains("</parent>")) {
								parent = false;
							}
							if (str1.contains("<groupId>") && groupId == null) {
								groupId = str1.substring(str1.indexOf("<groupId>") + 9, str1.indexOf("</groupId>"));
							}
							if (parent == false && str1.contains("<artifactId>") && artifactId == null) {
								artifactId = str1.substring(str1.indexOf("<artifactId>") + 12,
										str1.indexOf("</artifactId>"));
							}
							if (str1.contains("<version>") && versionParent == null) {
								versionParent = str1.substring(str1.indexOf("<version>") + 9, str1.indexOf("</version>"));
							}
							if (parent == false && str1.contains("<version>") && version == null) {
								version = str1.substring(str1.indexOf("<version>") + 9, str1.indexOf("</version>"));
							}
						}
					} catch (Exception e) {
						System.out.println("Error for file:" + jar_pom_link);
					}
					if(version==null)
						version = versionParent;
					else
					version = version.contains("$")? versionParent : version;
					System.out.println("mvn install:install-file -DgroupId=" + groupId + " -DartifactId=" + artifactId
							+ " -Dpackaging=jar -Dversion=" + version + " -Dfile=" + fileName
							+ ".jar -DgeneratePom=true");
				}
				/*else if (jar_pom_link.endsWith(".jar")) {
					URL url = new URL(jar_pom_link);
					String fileName = jar_pom_link.substring(jar_pom_link.lastIndexOf("/") + 1, jar_pom_link.length());
					FileUtils.copyURLToFile(url, new File("D:\\insight\\setup\\dependencies\\"+fileName));
				}*/
			}
	}

}
