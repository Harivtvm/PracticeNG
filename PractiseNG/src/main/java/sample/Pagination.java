package sample;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {
	WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selenium.qabible.in/index.php");
		driver.manage().window().maximize();
		WebElement ele1 = driver.findElement(By.xpath("(//a[contains(text(),'Table')])[1]"));
		ele1.click();
		List<String> fullnamelist = new ArrayList<String>();
		int a = driver.findElements(By.xpath("//li[@class='paginate_button page-item ']")).size()+1;
		for (int i = 1; i <= a; i++) {
			String b = "//a[contains(text(),'"+i+"')]";
			driver.findElement(By.xpath(b)).click();
			List<WebElement> elements = driver.findElements(By.xpath("//table//tr//td[1]"));
			for (WebElement list : elements) {
				fullnamelist.add(list.getText());
			}

		}
		System.out.println(fullnamelist.size());
		for(String li:fullnamelist) {
			System.out.println(li);
		}
		boolean c=fullnamelist.contains("Jena Gaines");
		System.out.println(c);
	}
}