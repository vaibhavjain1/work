package testing;

public class StringifyURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = " My name is Vaibhav        ";
		int truelenght = 18;
		char[] testa = test.toCharArray();
		
		for (int i = truelenght - 1; i >= 0; i--) {
			if(testa[i]==' ') {
				swaplasttwo(testa, truelenght, i);
				testa[i] = '%';
				testa[i+1] = '2';
				testa[i+2] = '0';
			}
		}
		System.out.println(String.copyValueOf(testa));
	}

	static void swaplasttwo(char[] test,int truelenght, int pos) {
		for (int i = test.length - 1; i >= 0; i--) {
			if(i==pos)
				break;
			if(i < truelenght-1 && test[i]==' ')
				break;
			else {
				test[i] = test[i-2];
				test[i-1] = test[i-3];
			}
		}
	}
}
