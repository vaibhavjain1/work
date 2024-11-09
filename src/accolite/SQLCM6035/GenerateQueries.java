package accolite.SQLCM6035;

public class GenerateQueries {

	// List all the instances added in SQLCM
	public static String[] servernames = {
			"WIN8-SQL14_MSSQLSERVER2017",
			"WIN8-SQL12_SQL2012",
			"WIN10-SQL17-VM1_SQL2017",
			"WIN10-SQL17-VM1_MSSQL_2014",
			"WIN10-SQL17-VM1_MSSQL_2016",
			"WIN8-SQL14_SQL2014",
			"DEVWIN10X64",
			"CM571-WIN2K8_SQL2K8",
			"CM571-WIN2K8_SQL2008",
			"WIN-SER12R2-SQL"
	};
	
	public static void ServerName_Rob() {
		int noOfServers = 48;
		String[] servers = new String[noOfServers];
		for (int i = 0; i < noOfServers; i++) {
			String servername = "SPM-CM-TARG-";
					servername+=i<10?"0":"";
					servername+=(i+1);
			servers[i] = servername;
		}
		servernames = servers;
	}
	
	public static String newTableName = "Stats_CountIncluded";
	
	//Create New stats tables
	public static void CreateTable() {
		for (String server : servernames) {
			System.out.println("use [SQLCOMPLIANCE_"+server +"]\n"
					+ "GO");
			System.out.println("SET ANSI_NULLS ON\r\n" + 
					"GO\r\n" + 
					"\r\n" + 
					"SET QUOTED_IDENTIFIER ON\r\n" + 
					"GO\r\n" + 
					"\r\n" + 
					"CREATE TABLE [dbo].["+newTableName+"](\r\n" + 
					"	[dbId] [int] NOT NULL,\r\n" + 
					"	[date] [datetime] NOT NULL,\r\n" + 
					"	[category] [int] NOT NULL,\r\n" + 
					"	[count] [int] NOT NULL,\r\n" + 
					"	[lastUpdated] [datetime] NOT NULL,\r\n" + 
					"PRIMARY KEY CLUSTERED \r\n" + 
					"(\r\n" + 
					"	[dbId] ASC,\r\n" + 
					"	[date] DESC,\r\n" + 
					"	[count] ASC,\r\n" + 
					"	[category] ASC\r\n" + 
					")WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]\r\n" + 
					") ON [PRIMARY]\r\n" + 
					"GO\r\n" + 
					"\r\n" + 
					"ALTER TABLE [dbo].["+newTableName+"] ADD  DEFAULT ((0)) FOR [dbId]\r\n" + 
					"GO\r\n" + 
					"\r\n" + 
					"ALTER TABLE [dbo].["+newTableName+"] ADD  DEFAULT ((0)) FOR [count]\r\n" + 
					"GO\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"");
		}
	}
	
	// Copy data into newly generated stats table from original stats tables
	public static void InsertInto(){
		for (String server : servernames) {
			System.out.println("use [SQLCOMPLIANCE_"+server +"]\nGO");
			System.out.println("INSERT INTO dbo."+newTableName+ " SELECT * FROM dbo.Stats;\n");
		}
	}
	
	// Drop newly generated stats tables
	public static void DropTable() {
		for (String server : servernames) {
			System.out.println("use [SQLCOMPLIANCE_"+server +"]\nGO");
			System.out.println("drop table dbo."+newTableName+";\n");
		}
	}
	
	public static void main(String[] args) {
		ServerName_Rob();
		//CreateTable();
		//InsertInto();
		// Post this step you can execute select queries to record performance metrices.
		DropTable();
	}
}
