package godKnowsWhatWillHappen.designPattern.AbstractFactory;

public class LinuxAbstractFactory implements AbstractWidgetFactory{

	@Override
	public Window createWindow() {
		// TODO Auto-generated method stub
		return new MacOs();
	}

}
