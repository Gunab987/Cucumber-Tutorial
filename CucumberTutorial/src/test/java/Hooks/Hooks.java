package Hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DriverInstance.DriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks extends DriverInstance {

	@BeforeStep
	public void beforeSteps(Scenario scenario) {
		scenario.log("started - Guna");

	}

	@AfterStep
	public void afterSteps(Scenario scenario) {
		scenario.log("finished - Guna");
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		String name = scenario.getName();
		System.out.println("Scenario name:" + name);
		System.out.println("ID :" + scenario.getId());
		System.out.println("Lines: " + scenario.getLine());
		System.out.println("URI" + scenario.getUri());
		System.out.println("Tags" + scenario.getSourceTagNames());

	}

	@After("@CleanUp")
	public void cleaUp(Scenario scenario) throws InterruptedException {
		// Thread.sleep(1500);
		// 49&52
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement data = driver.findElement(By.xpath("//button[@ng-reflect-router-link='/shopping-cart']"));
		wait.until(ExpectedConditions.elementToBeClickable(data)); // click();
		data.click();
		driver.findElement(By.xpath("(//span[@class='mdc-button__label'])[5]")).click();
		String gettext = driver.findElement(By.xpath("//mat-card-title[text()='Your shopping cart is empty.']"))
				.getText();
		Assert.assertEquals(gettext, "Your shopping cart is empty.");

		scenario.log("After Cleaning the Cart");

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshotAs1 = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotAs1, "image/png", "Cart is Empty....");

		driver.quit();

	}

	@After
	public void afterScenario(Scenario scenario) {
		boolean failed = scenario.isFailed();
		System.out.println("Is failed:" + failed);

		// RemoteWebDriver remote = (RemoteWebDriver) driver; //Type casting "WebDriver
		// to RemoteWebDriver"

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshotAs, "image/png", "Screenshot captured...");
		// driver.quit();
	}

}
