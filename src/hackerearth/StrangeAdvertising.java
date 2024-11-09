package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 HackerLand Enterprise is adopting a new viral advertising strategy. When they launch a new product, they advertise it to exactly  people on social media.
On the first day, half of those  people (i.e., floor(5/2)=2) like the advertisement and each shares it with  of their friends. At the beginning of the second day floor(5/2)*3 = 2*3 = 6,  people receive the advertisement.
Each day, floor(recepients/2) of the recipients like the advertisement and will share it with  friends on the following day. Assuming nobody receives the advertisement twice, determine how many people have liked the ad by the end of a given day, beginning with launch day as day .
For example, assume you want to know how many have liked the ad by the end of the 5th day.

Day Shared Liked Cumulative
1      5     2       2
2      6     3       5
3      9     4       9
4     12     6      15
5     18     9      24
The cumulative number of likes is 24.
Input = 3 output = 9
*
*/

public class StrangeAdvertising {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfDays = Integer.parseInt(br.readLine());
		int shared = 5;
		System.out.println(Math.PI);
		int liked = Math.floorDiv(shared, 2);
		int cumulative = liked + 0;
		
		while(noOfDays!=0){
			shared = liked*3;
			liked = Math.floorDiv(shared, 2);
			cumulative+=liked;
			noOfDays--;
		}
		System.out.println(cumulative);
	}

}
