package mlech.petclinic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import mlech.petclinic.pages.HomePage;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.PageFactory;

@RunWith(SeleniumScreenshotJUnit4Runner.class)
public class AbstractSelenium {
	
	private WebDriver driver;

	public void setUp(String browser) {
		if("Firefox".equals(browser)) {
			FFsetUp();
			return;
		}
		if("Chrome".equals(browser)) {
			CHsetUp();
			return;
		}
		FFsetUp();		
	}

	public void CHsetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)/Google/Chrome/Application/chromedriver.exe");
		ChromeOptions profile = new ChromeOptions();
		profile.addArguments("--lang=en");
		driver = new ChromeDriver(profile);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	public void FFsetUp() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("init.accept_languages", "en");
		driver = new FirefoxDriver(profile);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	public HomePage openPetClinic() {
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	public void takeScreenshot() throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\tmp\\"+screenshot.getName());
		FileUtils.copyFile(screenshot, destFile);
		System.out.println(String.format("[[ATTACHMENT|%s]]", destFile.getAbsolutePath()));
	}
	
	@After
	public void thearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
