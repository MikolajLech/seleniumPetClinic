package mlech.petclinic.pages;

import mlech.petclinic.AbstractPageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowOwnersPage extends AbstractPageObject {
	@FindBy(xpath="//table[@id='owners']/tbody/tr/td/a")
	private WebElement daniDavis;

	public ShowOwnersPage(WebDriver driver) {
		super(driver);
	}
	
	public OwnerInformationPage clickDaniDavis() {
		daniDavis.click();
		return PageFactory.initElements(driver, OwnerInformationPage.class);
	}

}
