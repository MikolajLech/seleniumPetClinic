package petclinic;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ldrygala.petclinic.AbstractSeleniumChrome;
import ldrygala.petclinic.AbstractSeleniumFirefox;
import ldrygala.petclinic.pages.FindOwnersPage;

import org.junit.Before;
import org.junit.Test;


public class FindOwnerFormValidationSeleniumTest extends AbstractSeleniumFirefox {

	private FindOwnersPage findOwnersPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		findOwnersPage = openPetClinic().clickFindOwner();
	}

	@Test
	public void shouldCheckIfOwnerIsNotFound() {
		findOwnersPage.setLastName("Jasiu").clickFindOwnersButton();
		assertTrue(findOwnersPage.hasError());
	}
	
	@Test
	public void shouldFindOwner() {
		findOwnersPage.setLastName("Davis").clickFindOwnersButton();
		assertFalse(findOwnersPage.hasError());
	}
	
	@Test
	public void shouldFindAllOnwers() {
		findOwnersPage.clickFindOwnersButton();
		assertFalse(findOwnersPage.hasError());
	}
	
}
