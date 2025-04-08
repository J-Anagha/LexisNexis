package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Driver.DriverManager;

public class HomePage extends BasePage {

	private String mainMenuLocator = ".score-center > ul[role='menu'] > li > a";

	public HomePage(DriverManager driverManager) {
		super(driverManager.getDriver());
	}
	
	public void dismissCookies() {
		WebElement cookiesElement = driver.findElement(By.id("onetrust-banner-sdk"));
		if (cookiesElement.isDisplayed()) {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		}
	}
	
	public void clickMainMenuItem(String itemName) {
		List<WebElement> elements = driver.findElements(By.cssSelector(mainMenuLocator));
		clickElement(elements, itemName);
	}
	
	public void selectOption(String optionName) {
		List<WebElement> elements = driver.findElements(By.cssSelector("h4"));
		for (WebElement element : elements) {
			if (element.getText().equalsIgnoreCase(optionName)) {
				// get parent of current element
				WebElement parent = element.findElement(By.xpath(".."));
				parent.findElement(By.cssSelector("a.btn-clickable-area")).click();
				break;
			}
		}
	}
	
}
