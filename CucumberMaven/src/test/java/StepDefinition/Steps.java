package StepDefinition;

import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	WebDriver driver;	
	
	@Given("we should be in homepage")
	public void we_should_be_in_homepage() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Python training\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	@When("Enter the valid name <{string}>")
	public void enter_the_valid_name(String string) {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	}
	
	@When("Enter valid password <{string}>")
	public void enter_valid_password(String string) {
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	}
	
	@When("click on Login validButton")
	public void click_on_login_valid_button() {
		driver.findElement(By.id("btnLogin")).click();
	}
	
	@Then("I should see name as <{string}>")
	public void i_should_see_name_as(String string) throws InterruptedException {
		String expected=driver.findElement(By.id("welcome")).getText();
		String Actual="Welcome Paul";
		Assert.assertEquals(expected,Actual);
		Thread.sleep(3000);
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		driver.quit();
	}
	
	
	
	@When("Enter the invalid name {string}")
	public void enter_the_invalid_name(String string) {
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin123");
	}
	
	@When("Enter invalid password {string}")
	public void enter_invalid_password(String string) {
	    driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	}
	
	@When("click on Login invalidButton")
	public void click_on_login_invalid_button() {
	    driver.findElement(By.id("btnLogin")).click();
	}
	
	@Then("I should see the invalid credential as {string}")
	public void i_should_see_the_invalid_credential_as(String string) throws InterruptedException {
			Thread.sleep(3000);
			String error=driver.findElement(By.xpath("//*[@id='spanMessage']")).getText();
		    String Actualerror="Invalid credentials"; 
		    Assert.assertEquals(error, Actualerror);
		    driver.quit();
	}
	
	
}
