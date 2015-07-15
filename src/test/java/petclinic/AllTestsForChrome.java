package petclinic;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FindOwnerFormValidationSeleniumTest.class,
		NewOwnerFormValidationSeleniumTest.class,
		NewPetFormValidationSeleniumTest.class })
public class AllTestsForChrome {
	
	@BeforeClass
	public static void setupProperties() {
		System.setProperty("browser","Chrome");		
	}

}
