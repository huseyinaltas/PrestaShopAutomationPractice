package com.prestashop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PshopNegativeLogin{
	WebDriver driver;
	WebElement signin;
	WebElement email;
	WebElement password;
	WebElement login;
		
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/huseyinaltas/Documents/selenium dependencies/drivers/chromedriver");
		driver = new ChromeDriver();
		
		
	}
	
	@BeforeMethod
	public void goToWebsite() {
		driver.get("http://automationpractice.com");
		signin = driver.findElement(By.xpath("//header[@id='header']//a[@class='login']"));
		signin.click();
	}
	
	@Test
	public void wrongCredentials() throws InterruptedException {
		email = driver.findElement(By.xpath("//div[@id='center_column']//input[@id='email']"));
		password = driver.findElement(By.xpath("//div[@id='center_column']//input[@id='passwd']"));
		login = driver.findElement(By.id("SubmitLogin"));
	
	
		Thread.sleep(3000);
		email.sendKeys("altas2001@hotmail.com");
		Thread.sleep(3000);
		password.sendKeys("mmsa1234");
		Thread.sleep(3000);
		login.click();
		
		String expected = "Authentication failed.";
		
		String actual = driver.findElement(By.xpath("//div[@id='center_column']//div[@class='alert alert-danger']/ol/li")).getText();
		
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test
	public void invalidEmailTest() throws InterruptedException {
		driver.get("http://automationpractice.com");
		signin = driver.findElement(By.xpath("//header[@id='header']//a[@class='login']"));
		signin.click();
		email = driver.findElement(By.xpath("//div[@id='center_column']//input[@id='email']"));
		password = driver.findElement(By.xpath("//div[@id='center_column']//input[@id='passwd']"));
		login = driver.findElement(By.id("SubmitLogin"));
		
		email.sendKeys("ASDasdads");
		Thread.sleep(3000);
		password.sendKeys("Husomuso");
		Thread.sleep(3000);
		login.click();
		
		String expected = "Invalid email address.";
		
		String actual = driver.findElement(By.xpath("//div[@id='center_column']//div[@class='alert alert-danger']/ol/li")).getText();
		
		Assert.assertEquals(actual, expected);
		
	}
	@Test
	public void  blankEmailTest() throws InterruptedException {
		driver.get("http://automationpractice.com");
		signin = driver.findElement(By.xpath("//header[@id='header']//a[@class='login']"));
		signin.click();
		email = driver.findElement(By.xpath("//div[@id='center_column']//input[@id='email']"));
		password = driver.findElement(By.xpath("//div[@id='center_column']//input[@id='passwd']"));
		login = driver.findElement(By.id("SubmitLogin"));
		
		email.sendKeys("");
		Thread.sleep(3000);
		password.sendKeys("Husomuso");
		Thread.sleep(3000);
		login.click();
		
		String expected = "An email address required.";
		
		String actual = driver.findElement(By.xpath("//div[@id='center_column']//div[@class='alert alert-danger']/ol/li")).getText();
		
		Assert.assertEquals(actual, expected);
		
	}
	@Test
	public void   blankPasswordTest() throws InterruptedException {
		driver.get("http://automationpractice.com");
		signin = driver.findElement(By.xpath("//header[@id='header']//a[@class='login']"));
		signin.click();
		email = driver.findElement(By.xpath("//div[@id='center_column']//input[@id='email']"));
		password = driver.findElement(By.xpath("//div[@id='center_column']//input[@id='passwd']"));
		login = driver.findElement(By.id("SubmitLogin"));
		
		email.sendKeys("altas@hotmail.com");
		Thread.sleep(3000);
		password.sendKeys("");
		Thread.sleep(3000);
		login.click();
		
		String expected = "Password is required.";
		
		String actual = driver.findElement(By.xpath("//div[@id='center_column']//div[@class='alert alert-danger']/ol/li")).getText();
		
		Assert.assertEquals(actual, expected);
		
	}
	
	
	
}
