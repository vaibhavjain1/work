package ignore.javaCovariance;

import java.util.*;

class Flower{
	String whats_you_name(){
		return "I have many names and types";
	}
}

class Jasmine extends Flower{
	String whats_you_name(){
		List<String> temp = new ArrayList<>();
		
		return "Jasmine";
	}
}

class Lily extends Flower{
	String whats_you_name(){
		return "Lily";
	}
}

class Lotus extends Flower{
	String whats_you_name(){
		return "Lotus";
	}
}

class State{
	Flower your_National_Flower(){
		return new Flower();
	}
}

class WestBengal{
	Jasmine your_National_Flower(){
		return new Jasmine();
	}
}

class Karnataka{
	Lily your_National_Flower(){
		return new Lily();
	}
}

class AndhraPradesh{
	Lotus your_National_Flower(){
		return new Lotus();
	}
}

public class Solution {
 public static void main(String[] args) {
	 System.out.println(new Random().nextInt(6));
}
}
