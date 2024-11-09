package testing;

import java.io.File;

/*
 IF OBJECT_ID('[dbo].[RPT_ATTACHMENT]') IS NOT NULL
    DROP TABLE [dbo].[RPT_ATTACHMENT]
 go
 */

/*
select count(*) into v_cnt from all_objects where object_name='RPT_ATTACHMENT' and UPPER(owner) = UPPER('%ERSREPORPT%');
  IF v_cnt = 1 then
   EXECUTE IMMEDIATE 'DROP TABLE RPT_ATTACHMENT  CASCADE CONSTRAINTS';
  END IF;
 */
public class PrintDropStatements {

	public static void main(String[] args) {
		String SqldirectoryLocation = "D:/Ers/Latest_1702_Code/ERSPortal_Main/ERSPortal/tsmain/db/sqlserver/model/triggers";
		String OracledirectoryLocation = "D:/Ers/Latest_1702_Code/ERSPortal_Main/ERSPortal/tsmain/db/oracle/model/triggers";
		File f = new File(OracledirectoryLocation);
		if(f.isDirectory()){
			File[] files = f.listFiles();
			for(File file: files){
				String currName = file.getName().substring(0, file.getName().indexOf("."));
				if(true){
					System.out.println("  select count(*) into v_cnt from all_objects where object_name='"+currName+"' and UPPER(owner) = UPPER('%ERSREPORPT%');");
					System.out.println("  IF v_cnt = 1 then");
					System.out.println("   EXECUTE IMMEDIATE 'DROP TRIGGER "+currName+"';");
					System.out.println("  END IF;"+"\n");
				} else {
				System.out.println("IF OBJECT_ID('[dbo].["+currName+"]') IS NOT NULL");
				System.out.println("    DROP TABLE [dbo].["+currName+"]");
				System.out.println("go"+"\n");
				}
			}
		}
	}
}
