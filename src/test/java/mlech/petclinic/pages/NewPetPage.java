package mlech.petclinic.pages;

import mlech.petclinic.AbstractPageObject;
import mlech.petclinic.enums.PetType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewPetPage extends AbstractPageObject {
	@FindBy(css="#name")
	private WebElement name;
	private WebElement birthDate;
	@FindBy(xpath="//form[@id='pet']/div[4]/select")
	private WebElement type;
	@FindBy(css="button[type=\"submit\"]")
	private WebElement addPetButton;
	
	
	public NewPetPage(WebDriver driver) {
		super(driver);
	}
	
	public NewPetPage setName(String in) {
        name.sendKeys(in);
		return this;
	}

	public NewPetPage setBirthDate(String in) {
		birthDate.sendKeys(in);
		return this;
	}
	
	public NewPetPage setType(PetType in) {
		new Select(type).selectByValue(in.getKey());
		return this;
	}

	public PetType getPetType() {
		return PetType.getPetType(type.getAttribute("value"));
	}
	
//	public NewPetPage clickAddPetButton() {
//		addPetButton.click();
//		return PageFactory.initElements(driver, NewPetPage.class);
//	}
	
	public void clickAddPetButton() {
		addPetButton.click();
	}

}
