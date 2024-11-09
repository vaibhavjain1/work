package viacom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass4 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		while(noOfTestCases!=0){
			int input = Integer.parseInt(br.readLine());
			
		    int count=2;
		    for(int i = 2; i <= input/2; i++)
		    {
		        if(input % i == 0)
		        {	
		           if(findGc(i, input/i))
		           count++;
		        }
		    }
		    System.out.println(count);
			noOfTestCases--;
		}
		
	}
	
	public static boolean findGc(int n1,int n2){
		int r;
        while(n2 != 0)
        {
            r = n1 % n2;
            n1 = n2;
            n2 = r;
        }
        if(n1==1)
        	return true;
        else
        	return false;
	}
}
