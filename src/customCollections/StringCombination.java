package customCollections;

public class StringCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		combine("abcd", new StringBuffer(), 0);
	}

	static void combine(String instr, StringBuffer outstr, int index)
	{
	    for (int i = index; i < instr.length(); i++)
	    {
	        outstr.append(instr.charAt(i));
	        System.out.println(outstr);
	        combine(instr, outstr, i + 1);
	        outstr.deleteCharAt(outstr.length() - 1);
	    }
	} 

	
}
