package accolite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ArtifactoryExtraction1 {

	public static void main(String[] args) throws Exception {
        File f = new File("D:\\Insight\\setup\\Artifactory");

        File[] files = f.listFiles();

        // Display the names of the files
        for (int i = 0; i < files.length; i++) {
            if(files[i].getName().endsWith(".pom")) {
				BufferedReader br = new BufferedReader(new FileReader(new File(files[i].getAbsolutePath())));
				String str = null;
				boolean parent = false;
				String groupId = null;
				String artifactId = null;
				String version = null;
				String versionParent = null;
				String fileName = files[i].getName().substring(0, files[i].getName().indexOf(".pom"));
				while ((str = br.readLine()) != null) {
					try {
						while ((str = br.readLine()) != null) {
							if (str.contains("<parent>")) {
								parent = true;
							}
							if (str.contains("</parent>")) {
								parent = false;
							}
							if (str.contains("<groupId>") && groupId == null) {
								groupId = str.substring(str.indexOf("<groupId>") + 9, str.indexOf("</groupId>"));
							}
							if (parent == false && str.contains("<artifactId>") && artifactId == null) {
								artifactId = str.substring(str.indexOf("<artifactId>") + 12,
										str.indexOf("</artifactId>"));
							}
							if (str.contains("<version>") && versionParent == null) {
								versionParent = str.substring(str.indexOf("<version>") + 9, str.indexOf("</version>"));
							}
							if (parent == false && str.contains("<version>") && version == null) {
								version = str.substring(str.indexOf("<version>") + 9, str.indexOf("</version>"));
							}
						}
					} catch (Exception e) {
						System.out.println("Error for file:" + files[i].getAbsolutePath());
					}
					if(version==null)
						version = versionParent;
					else
					version = version.contains("$")? versionParent : version;
				/*
				 * System.out.println("call mvn install:install-file -DgroupId=" + groupId +
				 * " -DartifactId=" + artifactId + " -Dpackaging=jar -Dversion=" + version +
				 * " -Dfile=" + fileName + ".jar -DpomFile=" + files[i].getName() +"");
				 */
					
					System.out.println("curl -u vaibhav.jain:7%933vjUmuVd -X PUT \"https://artifactory.do.insightsoftware.io/artifactory/tm-release-local/"+groupId.replace(".", "/")+"/"+artifactId+"/"+version+"/"+fileName+".jar\" -T "+fileName+".jar");
				}
            }
        }
	}

}
