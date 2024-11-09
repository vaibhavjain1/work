package insight;

import org.apache.commons.lang3.BooleanUtils;

public class Booleanutilcheck {

	public static void main(String[] args) {
		Boolean bool = new Boolean("TRUE");
		System.out.println(BooleanUtils.isTrue(bool));
	}

}
