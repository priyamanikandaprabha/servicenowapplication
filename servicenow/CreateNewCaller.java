package servicenow;

import java.time.Duration;


import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewCaller {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev72275.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Kavinaya146@");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.findElementByXPath("//span[text()='Callers']").click();
		//shadow.findElementByXPath("//input[@id='filter']").sendKeys("Callers", Keys.ENTER);
		WebElement Frame1 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(Frame1);
		driver.findElement(By.xpath("//button[contains(@class,'selected_action action_context')]")).click();
		WebElement Frame2 = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(Frame2);
		driver.findElement(By.name("sys_user.first_name")).sendKeys("priya");
		driver.findElement(By.id("sys_user.last_name")).sendKeys("mathi");
		driver.findElement(By.id("sys_user.title")).sendKeys("Creating new Caller");
		driver.findElement(By.id("sys_user.email")).sendKeys("priyaece23@gmail.com");
		driver.findElement(By.id("sys_user.phone")).sendKeys("1234567890");
		driver.findElement(By.id("sys_user.mobile_phone")).sendKeys("9457874145");
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(2000);
		driver.close();
		
	}

}
