package godKnowsWhatWillHappen.designPattern.Strategy;

public class Engineer implements CompanyInterface {

	@Override
	public void salaryPackage() {
		
		System.out.println("Salary package of engineer is 5rs.");
	}

}
