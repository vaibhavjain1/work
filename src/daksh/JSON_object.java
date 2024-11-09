package daksh;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;


public class JSON_object {

	public static void main(String[] args) throws Exception {
		
		 /*{
	"state": {
		"name": "Karnataka",
		"districts": [{
			"district": {
				"name": "Bangalore Rural",
				"caseTypes": [{	"caseType": {"name": "NAME1","IPC": ["ipc1", "ipc2", "ipc3"]}
				}, { "caseType": { "name": "NAME2", "IPC": ["ipc1", "ipc2", "ipc3"]	}
				}]
			}
		}]
	}
}
			 */
		
		List sheetData = new ArrayList();
		
		JSONObject caseTypeJson = new JSONObject();
		caseTypeJson.put("IPC", "ipc1");
		caseTypeJson.put("name", "case_type_name");
		
		JSONObject caseTypeJson1 = new JSONObject();
		caseTypeJson1.put("IPC", "ipc1");
		caseTypeJson1.put("name", "case_type_name");
		
		JSONObject caseTypesJson = new JSONObject();
		caseTypesJson.put("caseType", caseTypeJson);
		caseTypesJson.put("caseType1", caseTypeJson1);
		
		JSONObject namejson =  new JSONObject();
		namejson.put("name", "karnataka");
		
		JSONObject districtJson = new JSONObject();
		districtJson.put("name", namejson);
		districtJson.append("caseTypes", caseTypesJson);
		
		System.out.println(districtJson);
        /*
		FileInputStream casesInputStream = new FileInputStream("C:\\Users\\Vaibhav\\Desktop\\medakFinal.xlsx");
		XSSFWorkbook casesWorkBook = new XSSFWorkbook(casesInputStream);
	    XSSFSheet sheet = casesWorkBook.getSheetAt(0);
*/
		/*JSONObject dd = new JSONObject();
		dd.put("district", "dfd");
		
		JSONObject districtJson = new JSONObject();
		districtJson.put("name", "Karnatka");
		
		
		
		JSONObject nameJson = new JSONObject();
		nameJson.put("name", "Karnatka");
		nameJson.put("district", districtJson);
		
		nameJson.append("districts", dd);
		//nameJson.append("districts", dd);
		
		JSONObject root = new JSONObject();
		root.put("State", nameJson);
		
		System.out.println(root);*/
	}

}
