package Revise.enumPackage;

enum Week{
	Sunday(10), Monday(20);
	int value1;
	Week(int value){
		this.value1=value;
	}
	public int getValue(){
		return value1;
	}
}

public class EnumTesting {
public static void main(String[] args) {
	System.out.println(Week.Sunday.ordinal());
}
	
}
