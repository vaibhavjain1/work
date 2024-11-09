package serializationExternalization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDeserialization implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8206357427002445138L;
	static int valuestati = 50;
	int value = 10;
	int value12 = 15;
	transient String transValue = "helllo";
	public static void main(String[] args) {
	
		SerializationDeserialization obj = new SerializationDeserialization();
		obj.writeObj();
		obj.readObj();
	}
	
	public void writeObj(){
		try {
			FileOutputStream out = new FileOutputStream(new File("c:/abc.ser"));
			ObjectOutputStream objOut = new ObjectOutputStream(out);
			objOut.writeObject(new SerializationDeserialization());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readObj(){
		try {
			FileInputStream file = new FileInputStream(new File("C:/abc.ser"));
			ObjectInputStream input = new ObjectInputStream(file);
			SerializationDeserialization mainObj = (SerializationDeserialization) input.readObject();
			System.out.println(mainObj.transValue);
			System.out.println(mainObj.value);
			System.out.println(mainObj.value12);
			System.out.println(mainObj.valuestati);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
