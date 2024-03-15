package Pages;

import org.openqa.selenium.By;

import DriverInstance.DriverInstance1;
import io.cucumber.java.en.When;

public class HomePage extends DriverInstance1 {

	@When("user add book to cart")
	public void userAddBookToCart() {
		driver.findElement(By.xpath("//span[text()[normalize-space()='Add to Cart']]")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
