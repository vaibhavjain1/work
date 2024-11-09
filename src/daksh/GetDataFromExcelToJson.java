package daksh;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class GetDataFromExcelToJson {

    public static void main(String[] args) throws Exception {

        List sheetData = new ArrayList();

        FileInputStream casesInputStream = new FileInputStream("C:\\Users\\vaibh\\Desktop\\Milicom.xlsx");
        XSSFWorkbook casesWorkBook = new XSSFWorkbook(casesInputStream);
        XSSFSheet sheet = casesWorkBook.getSheetAt(0);


        Iterator rows = sheet.rowIterator();
        while (rows.hasNext()) {
            XSSFRow row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();

            List data = new ArrayList();
            while (cells.hasNext()) {
                XSSFCell cell = (XSSFCell) cells.next();
                data.add(cell);
            }

            sheetData.add(data);
        }

        for (int i = 1; i < sheetData.size(); i++) {
            Object finishedat = ((ArrayList) sheetData.get(i)).get(11);
            Object startat = ((ArrayList) sheetData.get(i)).get(10);
            BigInteger finishedate = new BigInteger(finishedat.toString());
            BigInteger startate = new BigInteger(startat.toString());
            BigInteger nano = finishedate.subtract(startate);
            long ms = nano.divide(new BigInteger("1000000")).longValue();
            long offsetMS = new Date(ms).getTimezoneOffset() * 60 * 1000;
            long utcTS = offsetMS < 0 ? ms - Math.abs(offsetMS) : ms + Math.abs(offsetMS);
            DateFormat format = new SimpleDateFormat("H:m:s");
            System.out.println(format.format(new Date(utcTS)));
        }
        casesWorkBook.close();
    }
}