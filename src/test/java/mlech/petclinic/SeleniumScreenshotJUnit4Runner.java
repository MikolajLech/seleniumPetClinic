package mlech.petclinic;

import org.junit.internal.runners.statements.InvokeMethod;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

public class SeleniumScreenshotJUnit4Runner extends BlockJUnit4ClassRunner {

	public SeleniumScreenshotJUnit4Runner(Class<AbstractSeleniumChrome> clazz)
			throws InitializationError {
		super(clazz);
	}
	
	@Override
	protected Statement methodInvoker(final FrameworkMethod method, final Object test) {
		return new InvokeMethod(method, test) {
			@Override
			public void evaluate() throws Throwable {
				try {
					super.evaluate();
				} catch (Throwable throwable) {
                    ((AbstractSeleniumChrome)test).takeScreenshot();
                    throw throwable;
				}
			}
		};
	}
}
