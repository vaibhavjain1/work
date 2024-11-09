package overriding_overloading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class parent{
	
}

class child extends parent{
	
}

public class MainTesting {
	
	public static void rotateList(List<Integer> myList){
		
	}
	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String[] inputArray = br.readLine().split(" ");
        String[] requiredArray = br.readLine().split(" ");
        List<Integer> myInputList = new ArrayList<>();
        List<Integer> myRequiredList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            myInputList.add(Integer.parseInt(inputArray[i]));
        }
        for (int i = 0; i < N; i++) {
            myRequiredList.add(Integer.parseInt(requiredArray[i]));
        }
        int timeRequired = 0;
        
        for(int i:myRequiredList){
        		while(myInputList.get(0)!=i){
        		myInputList.add(myInputList.remove(0));
        		timeRequired++;
        		}
        		myInputList.remove(0);
        }
        System.out.println(timeRequired+N);
	}
	
}
