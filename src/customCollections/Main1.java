package customCollections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main1 {

	static Map<Integer,Thing> newMap = new HashMap<>();
	static StringBuilder value = new StringBuilder();
	static int maxCost;
	
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
			List<Integer> a = new ArrayList<>();

			StringBuilder strBldr = new StringBuilder();
			for (int i = 2; i < inputs.length; i++) {
				String[] innerTemp = inputs[i].substring(1, inputs[i].length()-1).split(",");
				if(Float.parseFloat(innerTemp[1])<=maxWeight){
					Thing obj = new Thing();
					obj.index = Integer.parseInt(innerTemp[0]);
					obj.weight = Float.parseFloat(innerTemp[1]);
					obj.cost = Integer.parseInt(innerTemp[2].substring(1, innerTemp[2].length()));
					newMap.put(obj.index, obj);
					a.add(obj.index);
					//strBldr.append(innerTemp[0]+" ");
				}
			}
				indexCombinations(a, new StringBuilder(), 0, maxWeight);
				if(value.length()==0)
					System.out.print("-");
				else{
					for (int i = 0; i < value.length()-1; i++) {
						if(i!=0)
							System.out.print(",");
						System.out.print(value.charAt(i));
					}
				}
				System.out.println();
				value.setLength(0);
				maxCost = 0;
		}
		buffer.close();
	}

	
	static void indexCombinations(List<Integer> instr, StringBuilder outstr, int index, float maxWeight)
	{
		System.out.println("s"+instr);
	    for (int i = index; i < instr.size(); i++)
	    {   
	        outstr.append(instr.get(i));
	        System.out.println(outstr);
	        /*String[] temp = getWeightnCost(outstr).split("#");
	        if(Integer.parseInt(temp[1])>=maxCost && Float.parseFloat(temp[0])<=maxWeight){
	        	maxCost = Integer.parseInt(temp[1]);
	        	value.setLength(0);
	        	value.append(outstr+" ");
	        }*/
	        indexCombinations(instr, outstr, i + 1, maxWeight);
	        outstr.deleteCharAt(outstr.length() - 1);
	    }
	}
	
	static String getWeightnCost(StringBuilder outStr){
		float currWeight = 0;
		int cost = 0;
		for (int i = 0; i < outStr.length(); i++){
	    	try {
				currWeight += newMap.get(Character.getNumericValue(outStr.charAt(i))).weight;
			} catch (Exception e) {
				System.out.println(outStr);
			}
	    	cost += newMap.get(Character.getNumericValue(outStr.charAt(i))).cost;;
		}
		return String.valueOf(currWeight)+"#"+String.valueOf(cost);
	}
}
