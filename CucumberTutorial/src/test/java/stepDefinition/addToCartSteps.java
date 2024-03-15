
package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import DriverInstance.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class addToCartSteps extends DriverInstance { // WebDriver driver;
	// WebDriverWait wait;

	@Given("User should navigate the link login")
	public void userShouldNavigateTheLink() {
		driver = new ChromeDriver();
		driver.get("https://bookcart.azurewebsites.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Given("user should login as {string} and {string}")
	public void userShouldLoginAsAnd(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath("//span[text()=' Login ']")).click();
		driver.findElement(By.xpath("//input[@ng-reflect-placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		Thread.sleep(1000);
	}

	@Given("user search a book as {string}")
	public void userSearchABookAs(String book) throws InterruptedException {

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(book);
		driver.findElement(By.xpath("//span[@class='mdc-list-item__primary-text']")).click();
		Thread.sleep(1000);
	}

	@When("user add book to cart")
	public void userAddBookToCart() {
		driver.findElement(By.xpath("//span[text()[normalize-space()='Add to Cart']]")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("cart badge should be updated")
	public void cartBadgeShouldBeUpdated() throws InterruptedException {
		String text = driver.findElement(By.xpath("//span[@id='mat-badge-content-0']")).getText();
		Assert.assertEquals(Integer.parseInt(text) > 0, true); // driver.quit();

	}

}
