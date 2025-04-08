package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver d) {
		driver = d;
	}
	
	protected void clickElement(List<WebElement> elements, String elementText) {
		
		for (WebElement element : elements) {			
			if (element.getText().equalsIgnoreCase(elementText)) {
				element.click();
				break;
			}
		}
	}
}
