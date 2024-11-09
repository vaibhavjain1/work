package viacom;

abstract class abc{
	 public abstract void temp();
}

class temp{
	int integer;
	temp(int integer){
		this.integer = integer;
	}
	public int getInteger() {
		return integer;
	}
	public void setInteger(int integer) {
		this.integer = integer;
	}
	
}

enum Weekdays{
Sunday, Monday, Tuesday;
private Weekdays() {
	// TODO Auto-generated constructor stub
}
}
public class TempClass {

	
	public static void changeit(temp obj){
		
	}
	
	public static void main(String[] args) {
		System.out.println(Weekdays.values()[0]);
	}
}
