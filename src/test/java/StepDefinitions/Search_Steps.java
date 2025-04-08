package StepDefinitions;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import Driver.DriverManager;
import PageObjects.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Search_Steps {
	
	private WebDriver driver;
	private HomePage homePage;
	private CareersPage careersPage;
	
	public Search_Steps(DriverManager driverManager, HomePage home, CareersPage careers) {
		
		driver = driverManager.getDriver();
		homePage = home;
		careersPage = careers;
	}	
	
	@Given("I go to the website {string}")
	public void i_go_to_the_website(String url) {
		
		driver.get(url);
		homePage.dismissCookies();
	}

	@Given("click on the menu {string} on that page")
	public void click_on_the_menu_on_that_page(String mainMenuItem) {
	    homePage.clickMainMenuItem(mainMenuItem);
	}

	@When("I click on the option {string}")
	public void i_click_on_the_option(String option) {
	    homePage.selectOption(option);
	    if (option.equalsIgnoreCase("Careers")) {	    	
	    	ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	    	driver.switchTo().window(tabs.get(tabs.size() - 1));
	    }
	}	

	@When("I click on {string}")
	public void i_click_on(String linkText) throws InterruptedException {
		careersPage.clickLinkWithText(linkText);
		
	}

	@When("enter {string} in the search box")
	public void enter_in_the_search_box(String searchText) {
	    careersPage.enterSearchText(searchText);
	}

	@Then("I should get at least one search result")
	public void i_should_get_at_least_one_search_result() {
	    assertTrue(careersPage.getSearchResultCount() > 0);
	}


}
