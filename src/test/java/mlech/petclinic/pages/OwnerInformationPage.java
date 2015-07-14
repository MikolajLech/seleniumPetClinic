package mlech.petclinic.pages;

import mlech.petclinic.AbstractPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OwnerInformationPage extends AbstractPageObject {
	@FindBy(linkText = "Edit Owner")
	private WebElement editOwner;
	@FindBy(linkText = "Add New Pet")
	private WebElement addNewPet;

	public OwnerInformationPage(WebDriver driver) {
		super(driver);
	}
	
	public NewPetPage clickAddNewPet() {
		addNewPet.click();
		return PageFactory.initElements(driver, NewPetPage.class);
	}

}
