package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MonkAndCandies {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(br.readLine());
		while(noOfTestCases!=0){
			String[] tempinput = br.readLine().split(" ");
			int N = Integer.parseInt(tempinput[0]);
			int K = Integer.parseInt(tempinput[1]);
			long max = 0;
			tempinput = br.readLine().split(" ");
			Queue<Long> myQueue = new PriorityQueue<>(N,Collections.reverseOrder());
			for (int i = 0; i < N; i++) {
				myQueue.add(Long.parseLong(tempinput[i]));
			}
			for (int i = 0; i < K; i++) {
				long val = myQueue.poll();
				max+=val;
				myQueue.add(val/2);
			}
			System.out.println(max);
			noOfTestCases--;
		}
	}
}
