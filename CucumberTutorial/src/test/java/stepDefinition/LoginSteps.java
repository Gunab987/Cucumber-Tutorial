
package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import DriverInstance.DriverInstance;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends DriverInstance {

	// WebDriver driver;

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

	@Given("User enter the user name as guna")
	public void userEnterTheUserNameAsGuna() {
		driver.findElement(By.xpath("//input[@ng-reflect-placeholder='Username']")).sendKeys("guna");

	}

	@Given("User enter the password as Guna12345")
	public void userEnterThePasswordAsGuna12345() {
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("Guna12345");

	}

	@When("User Click the login button")
	public void userClickTheLoginButton() {

		driver.findElement(By.xpath("//span[text()='Login']")).click();

	}

	@Then("login should be success")
	public void loginShouldBeSuccess() {
		String text = driver.findElement(By.xpath("//span[text()=' guna']")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "guna");

	}

	@Given("User enter the user name as gunasekaran")
	public void userEnterTheUserNameAsGunasekaran() {
		driver.findElement(By.xpath("//input[@ng-reflect-placeholder='Username']")).sendKeys("gunasekaran");
	}

	@Given("User enter the password as guna123")
	public void userEnterThePasswordAsGuna123() {
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("guna123");
	}

	@Then("login should be fail")
	public void loginShouldBeFail() {
		String error = driver.findElement(By.xpath("//mat-error[@id='mat-mdc-error-0']")).getText();
		Assert.assertEquals(error, "Username or Password is incorrect.");

	}

	@Given("User enter the user name as {string}")
	public void userEnterTheUserNameAs(String username) {
		driver.findElement(By.xpath("//input[@ng-reflect-placeholder='Username']")).sendKeys(username);
	}

	@Given("User enter the password as {string}")
	public void userEnterThePasswordAs(String password) {
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password); // driver.quit(); }

	}
}