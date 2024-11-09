package exception;

import java.io.Serializable;

public class Test<T> implements Serializable

{  /**
	 * 
	 */
	private static final long serialVersionUID = -3398428006603081273L;

public static void main(String[] args) {
	
	try {
		try{
			
		}finally{
		  System.out.println("Finally 1");	
		}
		System.out.println("After 1st finally");
	} finally{
		System.out.println("Finally 2");
	}
}

}