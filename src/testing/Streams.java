package testing;

import java.util.Arrays;
import java.util.List;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(1,2,3);
		list.forEach(l -> {System.out.println(l*2);});
	}

}
