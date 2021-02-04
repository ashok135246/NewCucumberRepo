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
	
	@Given("Login application present")
	public void login_application_present() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IBMADMIN\\Documents\\Python training\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	    
	}
	
	@When("Enter valid credentials")
	public void enter_valid_credentials() throws InterruptedException  {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
	    driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	    Thread.sleep(3000);
	}

	@Then("Login successful")
	public void login_successful() throws InterruptedException {
		Thread.sleep(2000);
		String expected=driver.findElement(By.id("welcome")).getText();
		String Actual="Welcome Nauman";		
		Assert.assertEquals(expected,Actual);
		Thread.sleep(2000);
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[2]/a")).click();
		driver.quit();
	}
	
	@When("Enter invalid credentials")
	public void enter_invalid_credentials() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin123");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
	    driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Thread.sleep(3000);
	}
	
	@Then("Login unsuccessfull")
	public void login_unsuccessfull() throws InterruptedException {
		Thread.sleep(2000);
		String error=driver.findElement(By.xpath("//*[@id='spanMessage']")).getText();
	    String Actualerror="Invalid credentials";	    
	    Assert.assertEquals(error, Actualerror);
	    driver.quit();
	}
	
	
}
