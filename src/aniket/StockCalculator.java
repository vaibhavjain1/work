package aniket;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class StockCalculator {
    StockResp resp;

    Date today = new Date();

    void fetchData(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            File jsonInputFile = new File("practice/resources/HDFCBANK_FAIL.txt");
            resp = mapper.readValue(jsonInputFile, StockResp.class);
            for (Data data: resp.getData()){
                data.setDate(new Date(data.getTime()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void displayData(){
        for (Data data: resp.getData()){
            System.out.println(data);
        }
    }

    void get52WeekLow() {
        double weekLow52Price = Double.MAX_VALUE;
        double currentPrice = 0;
        LocalDateTime localDateTime52 = LocalDateTime.now().minusDays(52*7);
        Date datebefore52week = Date.from(localDateTime52.atZone(ZoneId.systemDefault()).toInstant());

        boolean first = true;
        for (Data data: resp.getData()) {
            if (first) {
               first = false;
               currentPrice = data.getIntc();
            }

            if(data.getDate().before(today) && data.getDate().after(datebefore52week)) {
                if(data.getIntc() < weekLow52Price)
                    weekLow52Price = data.getIntc();
            }
        }
        System.out.println("Current price: " + currentPrice);
        System.out.println("52 Week Low: " + weekLow52Price);
        String isCurrentGreaterthan125from52WeekLow = currentPrice > weekLow52Price * 1.25 ? "Yes" : "NO";
        System.out.println("Current price above 25% from 52 Week Low: " + isCurrentGreaterthan125from52WeekLow);

        double answer = (currentPrice - weekLow52Price)/weekLow52Price * 100;
        System.out.println("Percentage: " + answer);
        System.out.print(answer > 500 ? "Yes" : "No");
    }


    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        StockCalculator calc = new StockCalculator();
        calc.fetchData();
        //calc.displayData();
        calc.get52WeekLow();
    }
}
