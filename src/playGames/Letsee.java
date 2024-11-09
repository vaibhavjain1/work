package playGames;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

public class Letsee implements Serializable{

	int value;
	public static Letsee singletonObj;
	
	private Letsee(){
		this.value =100; 
	}
	
	public static Letsee getInstance(){
		if(singletonObj==null)
			return new Letsee();
		else
			return singletonObj;
	}
	
	public static void main(String[] values) throws IOException, ClassNotFoundException{
	
		Letsee Obj = Letsee.getInstance();
		
		FileOutputStream fileout = new FileOutputStream(new File("C:/abc.txt"));
		ObjectOutputStream objout = new ObjectOutputStream(fileout);
		objout.writeObject(Obj);
		Obj.value = 50;
		System.out.println("Object created: Obj with value"+Obj.value);
		
		FileInputStream filein = new FileInputStream(new File("C:/abc.txt"));
		ObjectInputStream objin = new ObjectInputStream(filein);
		Letsee newObj = (Letsee)objin.readObject();
		System.out.println("Old Object got created :"+newObj.value);
	}
	
	
}
