package Hooks;

import Driver.DriverManager;
import io.cucumber.java.After;

public class Hooks {
	
	DriverManager driverManager;

	public Hooks(DriverManager driver) {
		
		this.driverManager = driver;
	}	
	
	@After
	public void tearDown() {
	
		this.driverManager.getDriver().quit();
		this.driverManager = null;
	}

}
