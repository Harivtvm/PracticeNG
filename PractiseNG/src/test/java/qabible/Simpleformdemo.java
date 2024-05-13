package qabible;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Simpleformdemo {
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	@BeforeMethod
	public void launch_browser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		driver.manage().window().maximize();
	}
@Test()
public void Verify_textsimpleform1() {
	WebElement element1=driver.findElement(By.xpath("(//div[@class='card-header'])[1]"));
	WebElement element2=driver.findElement(By.xpath("(//div[@class='card-header'])[2]"));
	WebElement element3=driver.findElement(By.xpath("(//div[@class='card-header'])[3]"));
	softassert.assertEquals(element1.getText(), "Menu");
	softassert.assertEquals(element2.getText(), "Single Input Field");
	softassert.assertEquals(element3.getText(), "Two Input Fields");
softassert.assertAll();
}
@Test(priority=2,dependsOnMethods = "Verify_textsimpleform1")
public void Verify_textsimpleform2() {
	WebElement element1=driver.findElement(By.xpath("(//input[@type='text'])[1]"));
	WebElement element2=driver.findElement(By.xpath("(//input[@type='text'])[2]"));
	WebElement element3=driver.findElement(By.xpath("(//input[@type='text'])[3]"));
	softassert.assertEquals(element1.getAttribute("placeholder"), "Message");
	softassert.assertEquals(element2.getAttribute("placeholder"), "Enter Value");
	softassert.assertEquals(element3.getAttribute("placeholder"), "Enter Value");
softassert.assertAll();
}
@Test(priority=3)
public void Verify_textsimpleform3() {
	WebElement element1=driver.findElement(By.xpath("(//label)[1]"));
	WebElement element2=driver.findElement(By.xpath("(//label)[2]"));
	WebElement element3=driver.findElement(By.xpath("(//label)[3]"));;
	softassert.assertEquals(element1.getText(), "Enter Message");
	softassert.assertEquals(element2.getText(), "Enter value A");
	softassert.assertEquals(element3.getText(), "Enter value B");
softassert.assertAll();
}
@Test(priority=4)
public void Verify_textsimpleform4() {
	WebElement element1=driver.findElement(By.xpath("(//div[@class='my-2'])[1]"));
	WebElement element2=driver.findElement(By.xpath("(//div[@class='my-2'])[2]"));
	softassert.assertEquals(element1.getText(), "Your Message :");
	softassert.assertEquals(element2.getText(), "Total A + B :");
	
}
@Test(priority=5)
public void Verify_textsimpleform5() {
	WebElement element1=driver.findElement(By.xpath("(//button[@type='button'])[2]"));
	WebElement element2=driver.findElement(By.xpath("(//button[@type='button'])[3]"));
	softassert.assertEquals(element1.getText(), "Show Message");
	softassert.assertEquals(element2.getText(), "Get Total");
	softassert.assertEquals(element1.isDisplayed(),true);
	softassert.assertEquals(element2.isDisplayed(),true);
}
@AfterMethod
public void close() {
	driver.close();
}
}