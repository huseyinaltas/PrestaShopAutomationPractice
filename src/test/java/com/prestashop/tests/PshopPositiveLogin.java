package com.prestashop.tests;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class PshopPositiveLogin {
	WebDriver driver;
	WebElement signin;
	WebElement email;
	WebElement password;
	WebElement login;
	WebElement creat;
	WebElement creatEmail;
	String emailFormat;
	String firstName;
	String lastName;
	
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/huseyinaltas/Documents/selenium dependencies/drivers/chromedriver");
		driver = new ChromeDriver();
		Faker faker = new Faker();
		String emailName = faker.ancient().primordial();
		double num = Math.random()*100;
		int num1= (int) num;
		emailFormat = emailName+num1+ "@gmail.com";
		firstName = faker.name().firstName();
		lastName = faker.name().lastName();
	}
	
	@BeforeMethod
	public void goToWebsite() {
		
		
		driver.get("http://automationpractice.com");
		
		
	}
	
	@Test
	
	public void positiveChecking() throws InterruptedException {
		login = driver.findElement(By.xpath("//header[@id='header']//a[@class='login']"));
		login.click();
		
		creatEmail = driver.findElement(By.id("email_create"));
		Thread.sleep(3000);
		creatEmail.sendKeys(emailFormat);
		Thread.sleep(3000);

		creat = driver.findElement(By.id("SubmitCreate"));
		Thread.sleep(3000);

		creat.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='radio-inline']//input[@id='id_gender1']")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
		driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
		driver.findElement(By.id("passwd")).sendKeys("123n13n314");
		driver.findElement(By.id("days")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//select[@id='days']//option[@value='1']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//select[@id='months']//option[@value='5']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//select[@id='years']//option[@value='1999']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("address1")).sendKeys("1234 N ABC");
		Thread.sleep(5000);
		driver.findElement(By.id("city")).sendKeys("Chicago");
		Thread.sleep(5000);
		driver.findElement(By.id("id_state")).click();
		driver.findElement(By.xpath("//select[@id='id_state']//option[@value='13']")).click();
		driver.findElement(By.id("postcode")).sendKeys("60034");
		driver.findElement(By.id("phone_mobile")).sendKeys("2314134345");
		driver.findElement(By.id("alias")).sendKeys("DSASADDFD asDSad");
		driver.findElement(By.id("submitAccount")).click();
		
		String expectedNameLast = firstName+" "+lastName;
		
		String actaulName = driver.findElement(By.xpath("//header[@id='header']//a[@class='account']/span")).getText();

		Assert.assertEquals(actaulName, expectedNameLast);


		
		
		
	}

}
