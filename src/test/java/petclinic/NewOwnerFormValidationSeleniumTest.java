package petclinic;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import mlech.petclinic.AbstractSelenium;
import mlech.petclinic.pages.NewOwnerPage;

import org.junit.Before;
import org.junit.Test;

public class NewOwnerFormValidationSeleniumTest extends AbstractSelenium {

	private NewOwnerPage newOwnerPage;

	@Before
	public void setUp() {
		super.setUp(System.getProperty("browser"));
		newOwnerPage = openPetClinic().clickFindOwner().clickAddOwner();
	}

	@Test
	public void shouldCheckIfFirsNameIsRequired() {
		newOwnerPage.setLastName("lastName").setAddress("address")
				.setCity("city").setTelephone("123123").clickAddOwnerButton();
		
		assertTrue(newOwnerPage.hasError());
	}

	@Test
	public void shouldCheckIfAddressIsRequired() {
		newOwnerPage.setFirstName("firstName").setLastName("lastName")
				.setCity("city").setTelephone("123123").clickAddOwnerButton();
		
		assertTrue(newOwnerPage.hasError());
	}

	@Test
	public void shouldCheckIfTelefonRequieredNumericValue() {
		newOwnerPage.setFirstName("firstName").setLastName("lastName")
				.setAddress("address").setCity("city").setTelephone("telefon")
				.clickAddOwnerButton();
		
		assertTrue(newOwnerPage.hasError());
	}

	@Test
	public void shouldAddNewOwner() {
		newOwnerPage.setFirstName("firstName").setLastName("lastName")
				.setAddress("address").setCity("city").setTelephone("123123")
				.clickAddOwnerButton();

		assertFalse(newOwnerPage.hasError());
	}

}
