package monoCept;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PowerSet {

	public static void main(String[] args) throws Exception{
			int mycount = 0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] tempInput = br.readLine().split(" ");
	        //Scanner sc = new Scanner(System.in);
	        int N = Integer.parseInt(tempInput[0]);
	        int K = Integer.parseInt(tempInput[1]);
	        int X = Integer.parseInt(tempInput[2]);
	        
	        String[] numberInput = br.readLine().split(" ");
	        int[] sequence = new int[N];
	        for (int i = 0; i < N; i++)
	            sequence[i] = Integer.parseInt(numberInput[i]);
	 
	        int[] binary = new int[(int) Math.pow(2, N)];
	        for (int i = 0; i < Math.pow(2, N); i++) 
	        {
	            int b = 1;
	            binary[i] = 0;
	            int num = i, count = 0;
	            while (num > 0) 
	            {
	                if (num % 2 == 1)
	                    count++;
	                binary[i] += (num % 2) * b;
	                num /= 2;
	                b = b * 10;
	            }
	            if (count == K) 
	            {
	                //System.out.print("{ ");
	                int smallest=0;
	                int largest=0;
	                for (int j = 0; j < N; j++) 
	                {
	                    if (binary[i] % 10 == 1){
	                    	if(sequence[j]<smallest)
	                    		smallest = sequence[j];
	                    	if(sequence[j]>largest)
	                    		largest = sequence[j];
	                        //System.out.print(sequence[j] + " ");
	                    }
	                    binary[i] /= 10;
	                }
	                if(largest-smallest<=X)
	                	mycount++;
	                //System.out.println("}");
	            }
	        }
	     
	        
	        	System.out.println(mycount%1000000007);
				br.close();
			
	}
}
