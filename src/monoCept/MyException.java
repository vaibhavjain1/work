package monoCept;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
class deewanapan{
	private int privatevariable = 50;
	private void privateMethod(){
		System.out.println("Private method called");
	}
}

public class MyException {

	
	
	public static void main(String[] args) {
		List<Integer> myList = new LinkedList<>();
		myList.add(10);
		myList.add(20);
		Iterator<Integer> myListIterator = myList.iterator();
		while(myListIterator.hasNext()){
			System.out.println(myListIterator.next());
		}
		
		Set<Integer> mySet = new HashSet<>();
		mySet.add(30);
		mySet.add(40);
		Iterator<Integer> mySetIterator =  mySet.iterator();
		while(mySetIterator.hasNext()){
			System.out.println(mySetIterator.next());
		}

		Map<Integer,Integer> myMap = new HashMap<>();
		myMap.put(50,60);
		myMap.put(70,80);
		Set<Map.Entry<Integer,Integer>> myMapIterator = myMap.entrySet();
		for(Map.Entry myItr : myMapIterator){
			System.out.println(myItr.getKey()+" "+myItr.getValue());
		}
		
	}
}
