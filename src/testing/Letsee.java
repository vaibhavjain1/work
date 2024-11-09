package testing;

public class Letsee {


	public static void main(String[] args) {
		String prevDatabasePath = "Eksdjlfjdsk\\r"; 
		String currDatabasePath = prevDatabasePath.endsWith("\\") ? prevDatabasePath.substring(0, prevDatabasePath.length()-1) : prevDatabasePath;  
		System.out.println(currDatabasePath);
	}

}
