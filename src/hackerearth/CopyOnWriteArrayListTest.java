package hackerearth;

import java.util.LinkedList;

public class CopyOnWriteArrayListTest {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(1, 3);
		for (int i = 0; i < 4; i++) {
			System.out.println(list.get(i));
		}
	} 

}
