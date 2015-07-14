package petclinic;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import mlech.petclinic.AbstractSeleniumChrome;
import mlech.petclinic.AbstractSeleniumFirefox;
import mlech.petclinic.pages.FindOwnersPage;

import org.junit.Before;
import org.junit.Test;


public class FindOwnerFormValidationSeleniumTest extends AbstractSeleniumChrome {

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
