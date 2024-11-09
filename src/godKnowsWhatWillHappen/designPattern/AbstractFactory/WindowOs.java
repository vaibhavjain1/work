package godKnowsWhatWillHappen.designPattern.AbstractFactory;

public class WindowOs implements Window{

	String Title;
	@Override
	public void setTitle(String Title) {
		this.Title = Title;
		paint();
	}

	@Override
	public void paint() {
		System.out.println("Painting Window on Windows Operating system");
	}

}
