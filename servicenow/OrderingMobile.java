package servicenow;


import java.time.Duration;
import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;


public class OrderingMobile {

	public static void main(String[] args) throws Throwable  {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev72275.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Kavinaya146@");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		
		
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(20);
		shadow.findElementByXPath("//div[@id='all']").click();
		shadow.findElementByXPath("//span[text()='Service Catalog']").click();
		//shadow.findElementByXPath("//input[@id='filter']").sendKeys("Service Catalog", Keys.ENTER);
		
		
		WebElement Frame = shadow.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(Frame);
		driver.findElement(By.xpath("//h2[text()[normalize-space()='Mobiles']]")).click();//(//h2[Contains(text(), 'Mobile))
		WebElement Frame2 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(Frame2);
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 6s']")).click();
		WebElement Frame3 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(Frame3);
		Select Color = new Select(driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]")));
		Color.selectByValue("Rose Gold");
		Select Storage = new Select(driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[3]"))); 
		Storage.selectByIndex(2); 
	
		WebElement Frame4 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(Frame4);
		driver.findElement(By.xpath("//button[@id='oi_order_now_button'])")).click();
		driver.switchTo().defaultContent();
		WebElement Frame5 = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(Frame5);
		String VerificationMsg = driver.findElement(By.xpath("//div[@class='notification notification-success']")).getText();
		System.out.println(VerificationMsg);
		String RequestNo = driver.findElement(By.xpath("//b[text()='REQ0010001']")).getText();
		System.out.println(RequestNo);
		Thread.sleep(4000);
		driver.close();
		
		

	}

}
