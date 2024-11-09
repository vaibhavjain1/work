package interview;

import java.util.ArrayList;
import java.util.List;

class Student{
	
}

final class Immutable{
	List<Student> myList;
	public Immutable(List<Student> myList) {
		this.myList = myList;
	}
	
	public List<?> getStudentList(){
		return myList;
	}
}

public class ImmutableObject {
 public static void main(String[] args) {
	 List<Student> myList = new ArrayList<>();
	 System.out.println(myList.size());
	 Immutable obj = new Immutable(myList);
	 List<Student> newMyList = (List<Student>) obj.getStudentList();
	 newMyList.add(new Student());
	 System.out.println(newMyList.size());
}

}
