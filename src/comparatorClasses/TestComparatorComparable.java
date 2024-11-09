package comparatorClasses;

import java.util.HashSet;
import java.util.Set;

public class TestComparatorComparable {

	public static void main(String[] args) {
		System.out.println("Calling");
		//Employee e1 = new Employee();
		TestComparatorComparable e = new TestComparatorComparable();
		Employee e1  = e.new Employee();
		e1.name = "Praveen";
		e1.Age = 28;
		
		Employee e2  = e.new Employee();
		e2.name = "Ashish";
		e2.Age = 25;
		
		Employee e3  = e.new Employee();
		e3.name = "Ashish";
		e3.Age = 25;
		
		/*List<Employee> employeeList  = new ArrayList<>();
		employeeList.add(e1);
		employeeList.add(e2);
		Collections.sort(employeeList);
		for (Employee employee : employeeList) {
			employee.showEmpoyee();
		}*/
		
		Set<Employee> empHashSet = new HashSet<>();
		empHashSet.add(e1);
		empHashSet.add(e2);
		empHashSet.add(e3);
		
		for (Employee employee : empHashSet) {
			employee.showEmpoyee();
		}
		
	}
	
	class Employee implements Comparable<Employee>{
		String name;
		int Age;
		
		void showEmpoyee(){
			System.out.println("Employee Name "+this.name+" Age: "+Age);
		}

		@Override
		public boolean equals(Object arg0) {
			Employee e = (Employee) arg0;
			if(this.Age==e.Age)
				return false;
			else
				return true;
			//return super.equals(arg0);
			
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}

		@Override
		public int compareTo(Employee o) {
			if(Age==o.Age)
				return 0;
			else if(Age>o.Age)
				return 1;
			else
				return -1;
		}
	}
}
