package mlech.petclinic.pages;

import mlech.petclinic.AbstractPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindOwnersPage extends AbstractPageObject {
	@FindBy(linkText="Add Owner")
	private WebElement addOwner;
	@FindBy(css="#lastName > #lastName")
	private WebElement lastName;
	@FindBy(xpath = "//form[@id='search-owner-form']/fieldset/div[2]/button")
	private WebElement findOwnerButton;
	
	public FindOwnersPage(WebDriver driver) {
		super(driver);
	}
	
	public NewOwnerPage clickAddOwner() {
		addOwner.click();
		return PageFactory.initElements(driver, NewOwnerPage.class);
	}
	
	public ShowOwnersPage clickFindOwnersButton() {
		findOwnerButton.click();
		return PageFactory.initElements(driver, ShowOwnersPage.class);
	}

	public FindOwnersPage setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
		return this;
	}

}
