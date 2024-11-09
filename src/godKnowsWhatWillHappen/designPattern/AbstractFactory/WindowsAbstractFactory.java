package godKnowsWhatWillHappen.designPattern.AbstractFactory;

public class WindowsAbstractFactory implements AbstractWidgetFactory {

	@Override
	public Window createWindow() {
		return new WindowOs();
	}

}
