package ignore.javaCovariance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;

class Base
{
    int i=20;
    public  void  fun()
    {
        System.out.println("Base" +i);
    }
}

class Derived extends Base
{
   static int i=100;
    public void  fun()
    {

        System.out.println("Der" +i);
    }
}

class TestClass
{
	static class ItemProperties implements Comparable<ItemProperties>{
		String name;
		int price;
		int count;
		public ItemProperties(String name,int price,int count) {
			this.name = name;
			this.price = price;
			this.count = count;
		}
		@Override
		public int hashCode() {
			System.out.println("hashcode called");
			return super.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			System.out.println("Equals called");
			return super.equals(obj);
		}
		@Override
		public int compareTo(ItemProperties o) {
			if(this.price>o.price)
				return -1;
			else if(this.price<o.price)
				return +1;
			else
				return 0;
		}
		
		
	}
	
    public static void main(String args[]) throws IOException
    {
    	BufferedReader br  = new  BufferedReader(new InputStreamReader(System.in));	
		int	noOfItems = Integer.parseInt(br.readLine());
		if(noOfItems>100000)
			return;
    	Map<ItemProperties,Object> itemsPriceMap = new TreeMap<>();
    	
    	for (int i = 0; i < noOfItems; i++) {
			String[] input = br.readLine().split(" ");
			itemsPriceMap.put(new ItemProperties(input[0],Integer.parseInt(input[1]),0),null);
		}
    	System.out.println(itemsPriceMap);
    	/*for(Entry<ItemProperties, Object> entry: itemsPriceMap.entrySet()){
			System.out.println("Value"+entry.getKey().name);
		
		}*/
    	int noOfQueries = Integer.parseInt(br.readLine());
    	if(noOfQueries>100000)
    	return;
    	for (int i = 0; i < noOfQueries; i++) {
    		String[] input = br.readLine().split(" ");
    		/*if(input[0].equals("+")){
    			ItemProperties itr;
				if(( itr = itemsPriceMap.get(input[1]))!=null){
    				itr.count++;
    			}
    		}else if(input[0].equals("-")){
    			ItemProperties itr;
				if(( itr = itemsPriceMap.get(input[1]))!=null){
    				itr.count--;
    			}
    		}else if(input[0].equals("?")){
    			int sum = 0;
    			int priceToCompare = Integer.parseInt(input[1]);
    			
    			for(Map.Entry<String, ItemProperties> entry: itemsPriceMap.entrySet()){
    				System.out.println("Value"+entry.getKey());
    				if(entry.getValue().price>priceToCompare)
    					sum+=entry.getValue().count;
    				else
    					break;
    			}
    			System.out.println(sum);
    			
    		}   */
    		
		}
    }
}