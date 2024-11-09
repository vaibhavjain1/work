package testing;

interface MainInterface{
	double sum(int a, int b);
}

class MainImpl implements MainInterface{

	@Override
	public double sum(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	
}
public class Lambdas {

	
	public static void main(String[] args) {
		MainInterface obj = new MainInterface() {
			
			@Override
			public double sum(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		};
		
		System.out.println(obj.sum(5, 10));
		
		MainInterface obj1 = (int a, int b) -> {return a+b;}; 
	}

}
