package codeChef;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FLOW006{

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(System.out);
		int n,sum;
		for (int i = Integer.parseInt(br.readLine()); i >0 && i <= 1000; i--) {
			n = Integer.parseInt(br.readLine());
			if(n<1 || n>100000){
				pr.println("not in range");
			} else {
			sum=0;
			while (n>0) {
				sum+=n%10;
				n=n/10;
			}
			pr.println(sum);
			}
		}
		pr.close();
	}

}
