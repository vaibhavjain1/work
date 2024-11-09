package godKnowsWhatWillHappen.designPattern.Strategy;

public class MainStrategyImplementer {

	CompanyInterface object;
	public MainStrategyImplementer(CompanyInterface object) {
		this.object=object;
	}
	
	public void displaySalary(){
		object.salaryPackage();
	}
}
