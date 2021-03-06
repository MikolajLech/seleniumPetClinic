package petclinic;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import mlech.petclinic.AbstractSelenium;
import mlech.petclinic.pages.FindOwnersPage;

import org.junit.Before;
import org.junit.Test;


public class FindOwnerFormValidationSeleniumTest extends AbstractSelenium {

	private FindOwnersPage findOwnersPage;

	@Before
	public void setUp() {
		System.out.println(System.getProperty("browser"));
		super.setUp(System.getProperty("browser"));
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
