package petclinic;

import ldrygala.petclinic.AbstractSeleniumFirefox;
import ldrygala.petclinic.enums.PetType;
import ldrygala.petclinic.pages.NewPetPage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NewPetFormValidationSeleniumTest extends AbstractSeleniumFirefox {

	private NewPetPage newPetPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		newPetPage = openPetClinic().clickFindOwner().clickAddOwner().setFirstName("firstName").setLastName("lastName")
				.setAddress("address").setCity("city").setTelephone("123123")
				.clickAddOwnerButton().clickAddNewPet();
	}
	
	@Test
	public void shouldCheckIfNameIsRequired() {
		newPetPage.setBirthDate("2015/05/16").setType(PetType.SNAKE).clickAddPetButton();
		
		assertTrue(newPetPage.hasError());
	}

	@Test
	public void shouldCheckIfBirthDateIsRequired() {
		newPetPage.setName("pet").setType(PetType.SNAKE).clickAddPetButton();
		
		assertTrue(newPetPage.hasError());
	}

	@Test
	public void shouldFail() {
		assertEquals(PetType.SNAKE, newPetPage.getPetType());
	}

}
