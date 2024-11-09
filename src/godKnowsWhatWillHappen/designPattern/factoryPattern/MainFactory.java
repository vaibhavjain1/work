package godKnowsWhatWillHappen.designPattern.factoryPattern;

public class MainFactory {

	CompanyInterface object;
	public MainFactory(String objectName) {
		if(objectName.equalsIgnoreCase("Engineer"))
		this.object=new Engineer();
	}
	
	public void displaySalary(){
		object.salaryPackage();
	}
}
