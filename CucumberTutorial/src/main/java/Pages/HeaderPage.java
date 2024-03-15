package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import DriverInstance.DriverInstance1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HeaderPage extends DriverInstance1 {

	@Given("User should navigate the link")
	public void userShouldNavigateTheLink() {
		driver = new ChromeDriver();
		driver.get("https://bookcart.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	@Given("User should clicks the login")
	public void userShouldClicksTheLogin() {
		driver.findElement(By.xpath("//span[text()=' Login ']")).click();

	}

	@Given("user search a book as {string}")
	public void userSearchABookAs(String book) throws InterruptedException {

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(book);
		driver.findElement(By.xpath("//span[@class='mdc-list-item__primary-text']")).click();
		Thread.sleep(1000);
	}

	@Then("cart badge should be updated")
	public void cartBadgeShouldBeUpdated() throws InterruptedException {
		String text = driver.findElement(By.xpath("//span[@id='mat-badge-content-0']")).getText();
		Assert.assertEquals(Integer.parseInt(text) > 0, true);
		// driver.quit();

	}

}
