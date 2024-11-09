package godKnowsWhatWillHappen.designPattern.AbstractFactory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		String platform = System.getProperty("os.name");
		AbstractWidgetFactory factory;
		if(platform.equals("Windows")){
			factory = new WindowsAbstractFactory();
		}else
			factory = new LinuxAbstractFactory();
		GUIBuilder builder = new GUIBuilder();
		builder.buildWindow(factory);
	}
}
