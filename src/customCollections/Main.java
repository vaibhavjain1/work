package customCollections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;



public class Main {
	static Map<Integer,Thing> newMap = new HashMap<>();

	static class Thing{
		int index;
		float weight;
		int cost;
	}
	
	public static void main (String[] args) throws Exception {
        File file = new File("C:/input.txt");
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        
		String temp = null;
		while((temp =buffer.readLine())!=null){
			int maxWeight = Integer.parseInt(temp.substring(0, temp.indexOf(":")).trim());
			if(maxWeight>100)
				continue;
			String inputs[] = temp.split(" ");
			
			int[] permutations = new int[inputs.length-2];
			int j = 0;
			
			for (int i = 2; i < inputs.length; i++) {
				String[] innerTemp = inputs[i].substring(1, inputs[i].length()-1).split(",");
				//if(Float.parseFloat(innerTemp[1])<=maxWeight){
					Thing obj = new Thing();
					obj.index = Integer.parseInt(innerTemp[0]);
					obj.weight = Float.parseFloat(innerTemp[1]);
					obj.cost = Integer.parseInt(innerTemp[2].substring(1, innerTemp[2].length()));
					newMap.put(obj.index, obj);
					permutations[j++] = obj.index;
				//}
			}
			String maxprofitIndexes = null;
			if(j!=0)
				maxprofitIndexes = getPermutations(Arrays.copyOf(permutations, j),maxWeight);
			if(maxprofitIndexes==null){
				//System.out.println("-");
			}else{
				//System.out.println(maxprofitIndexes);
			}
		}
		
		buffer.close();
	}

	private static String getPermutations(int[] input, int maxWeight) {
		String requiredIndexes = null;
		int maxProfit = 0;
		for (int i = 0; i < input.length; i++) {
			if(newMap.get(input[i]).weight<=maxWeight && newMap.get(input[i]).cost >= maxProfit){
				requiredIndexes = String.valueOf(input[i]);
				maxProfit = newMap.get(input[i]).cost;
			}
			for (int j = i+1; j < input.length; j++) {
				String tn = " "+input[i]+","+input[j];
				if((newMap.get(input[i]).weight+newMap.get(input[j]).weight)<=maxWeight &&
						(newMap.get(input[i]).cost+newMap.get(input[j]).cost) >= maxProfit){
					requiredIndexes = input[i]+","+input[j];
					maxProfit = newMap.get(input[i]).cost+newMap.get(input[j]).cost;
				}
				for (int k = j+1; k < input.length; k++) {
					tn+=","+input[k];
					if((newMap.get(input[i]).weight+newMap.get(input[j]).weight+newMap.get(input[k]).weight)<=maxWeight &&
							(newMap.get(input[i]).cost+newMap.get(input[j]).cost+newMap.get(input[k]).cost) >= maxProfit){
						requiredIndexes = input[i]+","+input[j]+","+input[k];
						maxProfit = newMap.get(input[i]).cost+newMap.get(input[j]).cost+newMap.get(input[k]).cost;
					}
				}
			}
			System.out.println();
		}
		return requiredIndexes;
	}
	
}
