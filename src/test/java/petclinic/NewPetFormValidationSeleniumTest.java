package petclinic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import mlech.petclinic.AbstractSeleniumChrome;
import mlech.petclinic.enums.PetType;
import mlech.petclinic.pages.NewPetPage;

import org.junit.Before;
import org.junit.Test;

public class NewPetFormValidationSeleniumTest extends AbstractSeleniumChrome {

	private NewPetPage newPetPage;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		newPetPage = openPetClinic().clickFindOwner().setLastName("Davis").clickFindOwnersButton().
				clickDaniDavis().clickAddNewPet();
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

	@Test(expected=IllegalArgumentException.class)
	public void shouldFail() {
//		newPetPage.setType(PetType.SNAKE);

		assertEquals(PetType.SNAKE, newPetPage.getPetType());
	}

}
