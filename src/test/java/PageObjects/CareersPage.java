package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Driver.DriverManager;

public class CareersPage extends BasePage {

	By searchBoxLocator = By.id("search-box-button");
	By searchTextBoxLocator = By.cssSelector("div.page-search-box input[type='text']");
	By searchResultsListLocator = By.cssSelector("div.search-results-item");
	
	public CareersPage(DriverManager driverManager) {
		super(driverManager.getDriver());
	}
	
	public void clickLinkWithText(String linkText) throws InterruptedException {
		List<WebElement> elements = driver.findElements(By.cssSelector("div.score-left a.btn-red"));
		clickElement(elements, linkText);
	}
	
	public void enterSearchText(String searchText) {
		driver.findElement(searchTextBoxLocator).sendKeys(searchText);
		// Added sleep deliberately so that the list can show correct search result
		try {
			Thread.sleep(Duration.ofSeconds(1));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(searchBoxLocator).click();
	}
	
	public int getSearchResultCount() {
		List<WebElement> elements = driver.findElements(searchResultsListLocator);
		return elements.size();
	}

}
